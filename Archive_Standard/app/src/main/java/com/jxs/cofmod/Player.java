package com.jxs.cofmod;

import com.jxs.cofmod.control.Modable;
import static com.jxs.cofmod.S.*;

public class Player extends Modable {
	public static final int C=5;

	@Override
	public void onCreate() {}

    //固定函数
	public static final void addExp(int p1) {}
	public static final void addItemCreativeInv(int p1, int p2, int p3) {}
	public static final void addItemInventory(int p1, int p2, int p3) {}
	public static final boolean canFly() {return false;}
	public static final void clearInventorySlot(int p1) {}
	public static final boolean enchant(int p1, int p2, int p3) {return false;}
	public static final int getArmorSlot(int p1) {return 0;}
	public static final int getArmorSlotDamage(int p1) {return 0;}
	public static final int getCarriedItem() {return 0;}
	public static final int getCarriedItemCount() {return 0;}
	public static final int getCarriedItemData() {return 0;}
	public static final int getDimension() {return 0;}
	public static final Object[] getEnchantments(int p1) {return null;}
	public static final long getEntity() {return 0;}
	public static final double getExhaustion() {return 0;}
	public static final double getExp() {return 0;}
	public static final double getHunger() {return 0;}
	public static final int getInventorySlot(int p1) {return 0;}
	public static final int getInventorySlotCount(int p1) {return 0;}
	public static final int getInventorySlotData(int p1) {return 0;}
	public static final String getItemCustomName(int p1) {return null;}
	public static final int getLevel() {return 0;}
	public static final String getName(Object p1) {return null;}
	public static final int getPointedBlockData() {return 0;}
	public static final int getPointedBlockId() {return 0;}
	public static final int getPointedBlockSide() {return 0;}
	public static final int getPointedBlockX() {return 0;}
	public static final int getPointedBlockY() {return 0;}
	public static final int getPointedBlockZ() {return 0;}
	public static final long getPointedEntity() {return 0;}
	public static final double getPointedVecX() {return 0;}
	public static final double getPointedVecY() {return 0;}
	public static final double getPointedVecZ() {return 0;}
	public static final double getSaturation() {return 0;}
	public static final int getScore() {return 0;}
	public static final int getSelectedSlotId() {return 0;}
	public static final double getX() {return 0;}
	public static final double getY() {return 0;}
	public static final double getZ() {return 0;}
	public static final boolean isFlying() {return false;}
	public static final boolean isPlayer(Object p1) {return false;}
	public static final void setArmorSlot(int p1, int p2, int p3) {}
	public static final void setCanFly(boolean p1) {}
	public static final void setExhaustion(double p1) {}
	public static final void setExp(double p1) {}
	public static final void setFlying(boolean p1) {}
	public static final void setHealth(int p1) {}
	public static final void setHunger(double p1) {}
	public static final void setInventorySlot(int p1, int p2, int p3, int p4) {}
	public static final void setItemCustomName(int p1, String p2) {}
	public static final void setLevel(int p1) {}
	public static final void setSaturation(double p1) {}
	public static final void setSelectedSlotId(int p1) {}
}
