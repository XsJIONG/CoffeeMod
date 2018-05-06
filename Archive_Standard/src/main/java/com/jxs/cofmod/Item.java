package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import java.util.*;

import static com.jxs.cofmod.S.*;

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
		if (inCreativeBag()) Player.addItemCreativeInv(getItemId(), 1, 0);
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
	public static final void addCraftRecipe(int p1, int p2, int p3, int[] p4) {call(C, "addCraftRecipe", p1, p2, p3, eval(Arrays.toString(p4)));}
	public static final void addFurnaceRecipe(int p1, int p2, int p3) {call(C, "addFurnaceRecipe", p1, p2, p3);}
	public static final void addShapedRecipe(int p1, int p2, int p3, String[] p4, int[] p5) {
		StringBuffer b=new StringBuffer('[');
		for (int i=0;i<p4.length;i++) b.append('\"').append(p4[i]).append("\",[");
		if (b.length()!=1) b.delete(b.length()-2,b.length());
		b.append(']');
		call(C, "addShapedRecipe", p1, p2, p3, eval(b.toString()), eval(Arrays.toString(p5)));
	}
	public static final void defineArmor(int p1, String p2, int p3, String p4, String p5, int p6, int p7, int p8) {call(C, "defineArmor", p1, p2, p3, p4, p5, p6, p7, p8);}
	public static final void defineArmorSpec(int p1, String p2, int p3, String p4, String p5, int p6, int p7, int p8) {call(C, "defineArmorSpec", p1, p2, p3, p4, p5, p6, p7, p8);}
	public static final void defineThrowable(int p1, String p2, int p3, String p4, int p5) {call(C, "defineThrowable", p1, p2, p3, p4, p5);}
	public static final int getCustomThrowableRenderType(int p1) {return call(C, "getCustomThrowableRenderType", p1);}
	public static final int getMaxDamage(int p1) {return call(C, "getMaxDamage", p1);}
	public static final int getMaxStackSize(int p1) {return call(C, "getMaxStackSize", p1);}
	public static final String getName(int p1, int p2, boolean p3) {return (String) call(C, "getName", p1, p2, p3);}
	public static final int[] getTextureCoords(int p1, int p2) {return (int[]) call(C, "getTextureCoords", p1, p2);}
	public static final int getUseAnimation(int p1) {return call(C, "getUseAnimation", p1);}
	public static final int internalNameToId(String p1) {return call(C, "internalNameToId", p1);}
	public static final boolean isValidItem(int p1) {return call(C, "isValidItem", p1);}
	public static final void reregisterRecipes() {call(C, "reregisterRecipes");}
	public static final void setCategory(int p1, int p2) {call(C, "setCategory", p1, p2);}
	public static final void setEnchantType(int p1, int p2, int p3) {call(C, "setEnchantType", p1, p2, p3);}
	public static final void setHandEquipped(int p1, boolean p2) {call(C, "setHandEquipped", p1, p2);}
	public static final void setMaxDamage(int p1, int p2) {call(C, "setMaxDamage", p1, p2);}
	public static final void setProperties(int p1, Object p2) {call(C, "setProperties", p1, p2);}
	public static final void setStackedByData(int p1, boolean p2) {call(C, "setStackedByData", p1, p2);}
	public static final void setUseAnimation(int p1, int p2) {call(C, "setUseAnimation", p1, p2);}
	public static final int translatedNameToId(String p1) {return call(C, "translatedNameToId", p1);}
}
