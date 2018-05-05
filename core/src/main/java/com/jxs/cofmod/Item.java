package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Item extends Modable {
	public static final int C=2;

	private static int Max_Id=250;
	private String ItemName=null;
	private int ItemId=-1;

	@Override
	public void onCreate() {
		ModPE.setItem(getItemId(), getTexture(), getTextureOffset(), getItemName(), getMaxStakeSize());
		setMaxDamage(getItemId(), getMaxDamage());
		setHandEquipped(getItemId(), isHandEquipped());
		if (inCreativeBag()) Player.addItemCreativeInv(getItemId(), 1);
	}

	//公共函数
	public static final int getMaxId() {
		return Max_Id;
	}
	public static final void setMaxId(int id) {
		Max_Id = id;
	}

	//待重写函数
	public boolean inCreativeBag() {
		return true;
	}

	public boolean isHandEquipped() {
		return false;
	}

	public int getMaxStakeSize() {
		return 64;
	}

	public String getItemName() {
		if (ItemName == null)
			ItemName = this.getClass().getSimpleName();
		return ItemName;
	}

	public int getItemId() {
		if (ItemId == -1) {
			int i=Max_Id;
			while (isValidItem(i)) i++;
			ItemId = i;
			Max_Id = i;
		}
		return ItemId;
	}

	public int getMaxDamage() {
		return 1;
	}

	public String getTexture() {
		return "apple";
	}

	public int getTextureOffset() {
		return 0;
	}

	//自定义钩子
	public void onUse(int x, int y, int z, int idt, int bid, int bidt, int side) {}

//固定函数
	public static final void addCraftRecipe(Object id, Object num, Object data, JsArray scriptable) {call(C, "addCraftRecipe", toInt(id), toInt(num), toInt(data), scriptable);}
	public static final void addFurnaceRecipe(Object id1, Object id2, Object data) {call(C, "addFurnaceRecipe", toInt(id1), toInt(id2), toInt(data));}
	public static final void addShapedRecipe(Object id, Object num, Object data, JsArray scriptable, JsArray scriptable2) {call(C, "addShapedRecipe", toInt(id), toInt(num), toInt(data), scriptable, scriptable2);}
	public static final void defineArmor(Object id, String texture, Object special, String name, String skin, Object fang, Object damage, Object type) {call(C, "defineArmor", toInt(id), texture, toInt(special), name, skin, toInt(fang), toInt(damage), toInt(type));}
	public static final void defineThrowable(Object id, String texture, Object special, String name, Object maxstack) {call(C, "defineThrowable", toInt(id), texture, toInt(special), name, toInt(maxstack));}
	public static final void getCustomThrowableRenderType(Object id) {call(C, "getCustomThrowableRenderType", toInt(id));}
	public static final int getMaxDamage(Object id) {return call(C, "getMaxDamage", toInt(id));}
	public static final int getMaxStackSize(Object id) {return call(C, "getMaxStackSize", toInt(id));}
	public static final String getName(Object par1int, Object par2int, boolean zh) {return (String) call(C, "getName", toInt(par1int), toInt(par2int), zh);}
	public static final void getTextureCoords(Object par1int, Object par2int) {call(C, "getTextureCoords", toInt(par1int), toInt(par2int));}
	public static final int getUseAnimation(Object ani) {return call(C, "getUseAnimation", toInt(ani));}
	public static final void internalNameToId(String name) {call(C, "internalNameToId", name);}
	public static final boolean isValidItem(Object par1int) {return call(C, "isValidItem", toInt(par1int));}
	public static final void setCategory(Object id, Object damage, Object category) {call(C, "setCategory", toInt(id), toInt(damage), toInt(category));}
	public static final void setEnchantType(Object id, Object type, Object level) {call(C, "setEnchantType", toInt(id), toInt(type), toInt(level));}
	public static final void setHandEquipped(Object id, boolean act) {call(C, "setHandEquipped", toInt(id), act);}
	public static final void setMaxDamage(Object id, Object damage, Object rdamage) {call(C, "setMaxDamage", toInt(id), toInt(damage), toInt(rdamage));}
	public static final void setMaxDamage(Object id, Object damage) {call(C, "setMaxDamage", toInt(id), toInt(damage));}
	public static final void setProperties(Object id, Object group) {call(C, "setProperties", toInt(id), group);}
	public static final void setStackedByData(Object id, boolean act) {call(C, "setStackedByData", toInt(id), act);}
	public static final int translatedNameToId(String par1String) {return call(C, "translatedNameToId", par1String);}
}
