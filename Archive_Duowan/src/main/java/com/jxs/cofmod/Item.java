package com.jxs.cofmod;

import com.mcbox.pesdk.launcher.impl.*;
import com.mcbox.pesdk.mcfloat.model.*;
import com.mcbox.pesdkb.mcpelauncher.*;
import com.mcbox.pesdkb.mcpelauncher.api.modpe.*;
import java.util.*;

public class Item {
	private static List<Object[]> activeRecipes = new ArrayList<>();
	public static Map<Integer, Integer> itemIdToRendererId = new HashMap<>();
	public static Map<Integer, Integer> rendererToItemId = new HashMap<>();

	public static String getName(int id, int damage, boolean raw) {
		if (ScriptManager.nativeIsValidItem(id)) {
			return ScriptManager.nativeGetItemName(id, damage, raw);
		}
		throw new IllegalArgumentException(S.join("物品", String.valueOf(id), "不可用"));
	}

	public static void addCraftRecipe(int id, int count, int damage, int[] expanded) {
		StringBuilder temprow = new StringBuilder();
		char nextchar = 'a';
		int[] ingredients = new int[expanded.length];
		int i = 0;
		while (i < expanded.length) {
			int inputid = expanded[i];
			int inputcount = expanded[i + 1];
			int inputdamage = expanded[i + 2];
			char nextchar2 = (char) (nextchar + 1);
			char mychar = nextchar;
			for (int a = 0; a < inputcount; a++) {
				temprow.append(mychar);
			}
			ingredients[i] = mychar;
			ingredients[i + 1] = inputid;
			ingredients[i + 2] = inputdamage;
			i += 3;
			nextchar = nextchar2;
		}
		int temprowLength = temprow.length();
		if (temprowLength > 9) {
			ScriptManager.scriptPrint("在无形状的配方中最多允许有9个配料，多余的部分已经删除");
			temprow.delete(9, temprow.length());
			temprowLength = temprow.length();
		}
		int width = temprowLength <= 4 ? 2 : 3;
		String[] shape = new String[((temprowLength % width != 0 ? 1 : 0) + (temprowLength / width))];
		for (i = 0; i < shape.length; i++) {
			int begin = i * width;
			int end = begin + width;
			if (end > temprowLength) {
				end = temprowLength;
			}
			shape[i] = temprow.substring(begin, end);
		}
		verifyAndAddShapedRecipe(id, count, damage, shape, ingredients);
	}

	public static void addFurnaceRecipe(int inputId, int outputId, int outputDamage) {
		if (!ScriptManager.nativeIsValidItem(inputId)) {
			throw new IllegalArgumentException("熔炉配方的原材料物品不可用:" + inputId);
		} else if (ScriptManager.nativeIsValidItem(outputId)) {
			ScriptManager.nativeAddFurnaceRecipe(inputId, outputId, outputDamage);
		} else {
			throw new IllegalArgumentException("熔炉配方的输出物品不可用:" + outputId);
		}
	}

	public static void addShapedRecipe(int id, int count, int damage, String[] shape, int[] ingredients) {
		if (ingredients.length % 3 != 0)
			throw new IllegalArgumentException("配方数组必须是[\"?\",ID,特殊值, ...]的格式");
		verifyAndAddShapedRecipe(id, count, damage, shape, ingredients);
		DtPluginImpl.getInstance().addPluginComposed(id, shape, ingredients);
	}

	private static void verifyAndAddShapedRecipe(int id, int count, int damage, String[] shape, int[] ingredients) {
		if (id < 0 || id >= ScriptManager.ITEM_ID_COUNT)
			throw new RuntimeException(S.join("非法的配方:物品ID(", String.valueOf(id), ")必须介于0和", String.valueOf(ScriptManager.ITEM_ID_COUNT), "之间"));
		else if (ScriptManager.nativeIsValidItem(id)) {
			int i = 0;
			while (i < ingredients.length) {
				if (ScriptManager.nativeIsValidItem(ingredients[i + 1]))
					i += 3;
				else
					throw new RuntimeException("配方的原材料物品不可用:" + id);
			}
			for (Object[] r : activeRecipes) {
				if (((Integer) r[0]).intValue() == id && ((Integer) r[1]).intValue() == count && ((Integer) r[2]).intValue() == damage && Arrays.equals((String[]) r[3], shape) && Arrays.equals((int[]) r[4], ingredients))
					throw new IllegalArgumentException("配方已经存在");
			}
			activeRecipes.add(new Object[]{Integer.valueOf(id), Integer.valueOf(count), Integer.valueOf(damage), shape, ingredients});
			ScriptManager.nativeAddShapedRecipe(id, count, damage, shape, ingredients);
		} else throw new IllegalArgumentException("配方的输出物品不可用:" + id);
	}

	public static void reregisterRecipes() {
		for (Object[] r : activeRecipes)
			ScriptManager.nativeAddShapedRecipe(((Integer) r[0]).intValue(), ((Integer) r[1]).intValue(), ((Integer) r[2]).intValue(), (String[]) r[3], (int[]) r[4]);
	}

	public static void setMaxDamage(int id, int maxDamage) {
		ScriptManager.nativeSetItemMaxDamage(id, maxDamage);
	}

	public static void setCategory(int id, int category) {
		if (category < 0 || category > 4)
			throw new IllegalArgumentException(S.join("不可用的物品类别", String.valueOf(category), ":物品类别必须是ItemCategory.MATERIAL, ItemCategory.DECORATION, ItemCategory.TOOL, ItemCategory.FOOD其中的一个"));
		ScriptManager.nativeSetItemCategory(id, category, 0);
	}

	public static void setHandEquipped(int id, boolean yep) {
		ScriptManager.nativeSetHandEquipped(id, yep);
	}

	public static void defineArmor(int id, String iconName, int iconIndex, String name, String texture, int damageReduceAmount, int maxDamage, int armorType) {
		if (armorType < 0 || armorType > 3)
			throw new IllegalArgumentException(S.join("不可用的盔甲类型", String.valueOf(armorType), ":盔甲类型必须是ArmorType.helmet, ArmorType.chestplate,ArmorType.leggings, ArmorType.boots其中的一个"));
		else if (id < 0 || id >= ScriptManager.ITEM_ID_COUNT)
			throw new IllegalArgumentException("物品ID必须大于等于0并且小于" + ScriptManager.ITEM_ID_COUNT);
		else if (ScriptManager.itemsMeta == null || ScriptManager.itemsMeta.hasIcon(iconName, iconIndex)) {
			String newSkinPath = OldEntityTextureFilenameMapping.m.get(texture);
			if (newSkinPath != null)
				texture = newSkinPath;
			ScriptManager.nativeDefineArmor(id, iconName, iconIndex, name, texture, damageReduceAmount, maxDamage, armorType);
			DtPluginImpl.getInstance().addPluginList(new PluginItem(id, iconName, name, iconIndex, texture, 2));
		} else
			throw new IllegalArgumentException(S.join("物品图标", String.valueOf(iconName), ":", String.valueOf(iconIndex), "不存在"));
	}

	public static void defineArmorSpec(int id, String iconName, int iconIndex, String name, String texture, int damageReduceAmount, int maxDamage, int armorType) {
		if (armorType < 0 || armorType > 3)
			throw new IllegalArgumentException(S.join("不可用的盔甲类型", String.valueOf(armorType), ":盔甲类型必须是ArmorType.helmet, ArmorType.chestplate,ArmorType.leggings, ArmorType.boots其中的一个"));
		else if (id < 0 || id >= ScriptManager.ITEM_ID_COUNT)
			throw new IllegalArgumentException("物品ID必须大于等于0并且小于" + ScriptManager.ITEM_ID_COUNT);
		else if (ScriptManager.itemsMeta == null || ScriptManager.itemsMeta.hasIcon(iconName, iconIndex))
			ScriptManager.nativeDefineArmor(id, iconName, iconIndex, name, texture, damageReduceAmount, maxDamage, armorType);
		else
			throw new IllegalArgumentException(S.join("物品图标", String.valueOf(iconName), ":", String.valueOf(iconIndex), "不存在"));
	}

	public static boolean isValidItem(int id) {
		return ScriptManager.nativeIsValidItem(id);
	}

	public static void setProperties(int id, CharSequence props) {
		if (isValidItem(id)) {
			if (!ScriptManager.nativeItemSetProperties(id, props.toString()))
				throw new IllegalArgumentException("为物品设置属性失败:" + id);
			return;
		}
		throw new IllegalArgumentException(id + "不是一个可用的物品");
	}

	public static int getUseAnimation(int id) {
		return ScriptManager.nativeItemGetUseAnimation(id);
	}

	public static void setUseAnimation(int id, int animation) {
		ScriptManager.nativeItemSetUseAnimation(id, animation);
	}

	public static void setStackedByData(int id, boolean stacked) {
		ScriptManager.nativeItemSetStackedByData(id, stacked);
	}

	public static void setEnchantType(int id, int flag, int value) {
		ScriptManager.nativeSetAllowEnchantments(id, flag, value);
	}

	public static int getMaxDamage(int id) {
		return ScriptManager.nativeGetItemMaxDamage(id);
	}

	public static int[] getTextureCoords(int id, int damage) {
		float[] var2 = new float[6];
		if (ScriptManager.nativeGetTextureCoordinatesForItem(id, damage, var2))
			return new int[] {(int)((double)(var2[0] * var2[4]) + 0.5D), (int)((double)(var2[1] * var2[5]) + 0.5D), (int)((double)(var2[2] * var2[4]) + 0.5D), (int)((double)(var2[3] * var2[5]) + 0.5D), (int)((double)var2[4] + 0.5D), (int)((double)var2[5] + 0.5D)};
		else
			throw new IllegalArgumentException(S.join("无法获取物品", String.valueOf(id), ":", String.valueOf(damage), "的材质"));
	}

	public static int internalNameToId(String name) {
		return nameToIdImpl(name, true);
	}

	public static int translatedNameToId(String name) {
		return nameToIdImpl(name, false);
	}

	private static int nameToIdImpl(String name, boolean internal) {
		if (name == null) {
			return -1;
		}
		int i;
		name = name.replace(" ", "_").toLowerCase();
		for (i = 256; i < 4096; i++) {
			if (idHasName(name, i, internal)) {
				return i;
			}
		}
		for (i = 1; i < 256; i++) {
			if (idHasName(name, i, internal)) {
				return i;
			}
		}
		try {
			return Integer.parseInt(name);
		} catch (Exception e) {
			return -1;
		}
	}

	private static boolean idHasName(String targetname, int id, boolean internal) {
		int startSub = 0;
		String name = ScriptManager.nativeGetItemName(id, 0, internal);
		if (name == null) {
			return false;
		}
		if (internal) {
			int endSub = name.endsWith(".name") ? name.length() - 5 : name.length();
			if (name.startsWith("tile.") || name.startsWith("item.")) {
				startSub = 5;
			}
			name = name.substring(startSub, endSub);
		}
		return targetname.equals(name.replace(" ", "_").toLowerCase());
	}

	public static int getMaxStackSize(int id) {
		return ScriptManager.nativeItemGetMaxStackSize(id);
	}

	public static void defineThrowable(int id, String iconName, int iconSubindex, String name, int maxStackSize) {
		if (id < 0 || id >= ScriptManager.ITEM_ID_COUNT)
			throw new IllegalArgumentException("物品ID必须大于等于0并且小于" + ScriptManager.ITEM_ID_COUNT);
		else if (ScriptManager.itemsMeta == null || ScriptManager.itemsMeta.hasIcon(iconName, iconSubindex)) {
			ScriptManager.nativeDefineSnowballItem(id, iconName, iconSubindex, name, maxStackSize);
			int renderer = RendererManager.nativeCreateItemSpriteRenderer(id);
			itemIdToRendererId.put(Integer.valueOf(renderer), Integer.valueOf(id));
			rendererToItemId.put(Integer.valueOf(id), Integer.valueOf(renderer));
		} else 
			throw new IllegalArgumentException(S.join("物品图标", String.valueOf(iconName), ":", String.valueOf(iconSubindex), "不存在"));
	}

	public static int getCustomThrowableRenderType(int itemId) {
		Integer i = rendererToItemId.get(Integer.valueOf(itemId));
		if (i != null)
			return i.intValue();
		throw new IllegalArgumentException(itemId + "不是一个自定义投掷物");
	}
}
