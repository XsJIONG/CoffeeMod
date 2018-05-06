package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

import static com.jxs.cofmod.S.*;

public class Player extends Modable {
	public static final int C=5;

	@Override
	public void onCreate() {}

    //固定函数
	public static final void addExp(int p1) {call(C, "addExp", p1);}
	public static final void addItemCreativeInv(int p1, int p2, int p3) {call(C, "addItemCreativeInv", p1, p2, p3);}
	public static final void addItemInventory(int p1, int p2, int p3) {call(C, "addItemInventory", p1, p2, p3);}
	public static final boolean canFly() {return call(C, "canFly");}
	public static final void clearInventorySlot(int p1) {call(C, "clearInventorySlot", p1);}
	public static final boolean enchant(int p1, int p2, int p3) {return call(C, "enchant", p1, p2, p3);}
	public static final int getArmorSlot(int p1) {return call(C, "getArmorSlot", p1);}
	public static final int getArmorSlotDamage(int p1) {return call(C, "getArmorSlotDamage", p1);}
	public static final int getCarriedItem() {return call(C, "getCarriedItem");}
	public static final int getCarriedItemCount() {return call(C, "getCarriedItemCount");}
	public static final int getCarriedItemData() {return call(C, "getCarriedItemData");}
	public static final int getDimension() {return call(C, "getDimension");}
	public static final Object[] getEnchantments(int p1) {return (Object[]) call(C, "getEnchantments", p1);}
	public static final long getEntity() {return call(C, "getEntity");}
	public static final double getExhaustion() {return call(C, "getExhaustion");}
	public static final double getExp() {return call(C, "getExp");}
	public static final double getHunger() {return call(C, "getHunger");}
	public static final int getInventorySlot(int p1) {return call(C, "getInventorySlot", p1);}
	public static final int getInventorySlotCount(int p1) {return call(C, "getInventorySlotCount", p1);}
	public static final int getInventorySlotData(int p1) {return call(C, "getInventorySlotData", p1);}
	public static final String getItemCustomName(int p1) {return (String) call(C, "getItemCustomName", p1);}
	public static final int getLevel() {return call(C, "getLevel");}
	public static final String getName(Object p1) {return (String) call(C, "getName", p1);}
	public static final int getPointedBlockData() {return call(C, "getPointedBlockData");}
	public static final int getPointedBlockId() {return call(C, "getPointedBlockId");}
	public static final int getPointedBlockSide() {return call(C, "getPointedBlockSide");}
	public static final int getPointedBlockX() {return call(C, "getPointedBlockX");}
	public static final int getPointedBlockY() {return call(C, "getPointedBlockY");}
	public static final int getPointedBlockZ() {return call(C, "getPointedBlockZ");}
	public static final long getPointedEntity() {return call(C, "getPointedEntity");}
	public static final double getPointedVecX() {return call(C, "getPointedVecX");}
	public static final double getPointedVecY() {return call(C, "getPointedVecY");}
	public static final double getPointedVecZ() {return call(C, "getPointedVecZ");}
	public static final double getSaturation() {return call(C, "getSaturation");}
	public static final int getScore() {return call(C, "getScore");}
	public static final int getSelectedSlotId() {return call(C, "getSelectedSlotId");}
	public static final double getX() {return call(C, "getX");}
	public static final double getY() {return call(C, "getY");}
	public static final double getZ() {return call(C, "getZ");}
	public static final boolean isFlying() {return call(C, "isFlying");}
	public static final boolean isPlayer(Object p1) {return call(C, "isPlayer", p1);}
	public static final void setArmorSlot(int p1, int p2, int p3) {call(C, "setArmorSlot", p1, p2, p3);}
	public static final void setCanFly(boolean p1) {call(C, "setCanFly", p1);}
	public static final void setExhaustion(double p1) {call(C, "setExhaustion", p1);}
	public static final void setExp(double p1) {call(C, "setExp", p1);}
	public static final void setFlying(boolean p1) {call(C, "setFlying", p1);}
	public static final void setHealth(int p1) {call(C, "setHealth", p1);}
	public static final void setHunger(double p1) {call(C, "setHunger", p1);}
	public static final void setInventorySlot(int p1, int p2, int p3, int p4) {call(C, "setInventorySlot", p1, p2, p3, p4);}
	public static final void setItemCustomName(int p1, String p2) {call(C, "setItemCustomName", p1, p2);}
	public static final void setLevel(int p1) {call(C, "setLevel", p1);}
	public static final void setSaturation(double p1) {call(C, "setSaturation", p1);}
	public static final void setSelectedSlotId(int p1) {call(C, "setSelectedSlotId", p1);}
}
