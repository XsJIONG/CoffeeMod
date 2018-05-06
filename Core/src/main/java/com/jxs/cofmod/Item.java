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
	public static final void addCraftRecipe(int p1, int p2, int p3, int[] p4) {}
	public static final void addFurnaceRecipe(int p1, int p2, int p3) {}
	public static final void addShapedRecipe(int p1, int p2, int p3, Object[][] p4, int[] p5) {}
	public static final void defineArmor(int p1, String p2, int p3, String p4, String p5, int p6, int p7, int p8) {}
	public static final void defineArmorSpec(int p1, String p2, int p3, String p4, String p5, int p6, int p7, int p8) {}
	public static final void defineThrowable(int p1, String p2, int p3, String p4, int p5) {}
	public static final int getCustomThrowableRenderType(int p1) {return 0;}
	public static final int getMaxDamage(int p1) {return 0;}
	public static final int getMaxStackSize(int p1) {return 0;}
	public static final String getName(int p1, int p2, boolean p3) {return null;}
	public static final int[] getTextureCoords(int p1, int p2) {return null;}
	public static final int getUseAnimation(int p1) {return 0;}
	public static final int internalNameToId(String p1) {return 0;}
	public static final boolean isValidItem(int p1) {return false;}
	public static final void reregisterRecipes() {}
	public static final void setCategory(int p1, int p2) {}
	public static final void setEnchantType(int p1, int p2, int p3) {}
	public static final void setHandEquipped(int p1, boolean p2) {}
	public static final void setMaxDamage(int p1, int p2) {}
	public static final void setProperties(int p1, Object p2) {}
	public static final void setStackedByData(int p1, boolean p2) {}
	public static final void setUseAnimation(int p1, int p2) {}
	public static final int translatedNameToId(String p1) {return 0;}
}
