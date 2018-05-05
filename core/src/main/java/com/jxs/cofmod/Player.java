package com.jxs.cofmod;

import com.jxs.cofmod.control.Modable;

public class Player extends Modable {
	public static final int C=5;

	@Override
	public void onCreate() {
		
	}

    //固定函数
	public static final void addExp(Object par) {call(C, "addExp", toInt(par));}
	public static final void addItemCreativeInv(Object id, final Object num, final Object data) {call(C, "addItemCreativeInv", toInt(id), toInt(num), toInt(data));}
	public static final void addItemCreativeInv(Object id, final Object num) {call(C, "addItemCreativeInv", toInt(id), toInt(num));}
	public static final void addItemCreativeInv(Object id, boolean num) {call(C, "addItemCreativeInv", toInt(id), num);}
	public static final void addItemInventory(Object id, final Object num, final Object data) {call(C, "addItemInventory", toInt(id), toInt(num), toInt(data));}
	public static final boolean canFly() {return call(C, "canFly");}
	public static final void clearInventorySlot(Object slot) {call(C, "clearInventorySlot", toInt(slot));}
	public static final boolean enchant(Object slot, final Object id, final Object level) {return call(C, "enchant", toInt(slot), toInt(id), toInt(level));}
	public static final int getArmorSlot(Object slot) {return call(C, "getArmorSlot", toInt(slot));}
	public static final int getArmorSlotDamage(Object slot) {return call(C, "getArmorSlotDamage", toInt(slot));}
	public static final int getCarriedItem() {return call(C, "getCarriedItem");}
	public static final int getCarriedItemCount() {return call(C, "getCarriedItemCount");}
	public static final int getCarriedItemData() {return call(C, "getCarriedItemData");}
	public static final int getDimension() {return call(C, "getDimension");}
	public static final Integer[] getEnchantments(Object slot) {return (Integer[]) call(C, "getEnchantments", toInt(slot));}
	public static final long getEntity() {return call(C, "getEntity");}
	public static final int getExhaustion() {return call(C, "getExhaustion");}
	public static final long getExp() {return call(C, "getExp");}
	public static final int getHunger() {return call(C, "getHunger");}
	public static final int getHunger(Object id) {return call(C, "getHunger", toInt(id));}
	public static final int getInventorySlot(Object par) {return call(C, "getInventorySlot", toInt(par));}
	public static final int getInventorySlotCount() {return call(C, "getInventorySlotCount");}
	public static final int getInventorySlotData() {return call(C, "getInventorySlotData");}
	public static final String getItemCustomName(Object id) {return (String) call(C, "getItemCustomName", toInt(id));}
	public static final int getLevel() {return call(C, "getLevel");}
	public static final String getName(Object entity) {return (String) call(C, "getName", entity);}
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
	public static final int getSaturation() {return call(C, "getSaturation");}
	public static final int getScore() {return call(C, "getScore");}
	public static final int getSelectedSlotId() {return call(C, "getSelectedSlotId");}
	public static final boolean isFlying() {return call(C, "isFlying");}
	public static final boolean isPlayer(Object entity) {return call(C, "isPlayer", entity);}
	public static final void setArmorSlot(Object slot, final Object id, final Object data) {call(C, "setArmorSlot", toInt(slot), toInt(id), toInt(data));}
	public static final void setCanFly(boolean fly) {call(C, "setCanFly", fly);}
	public static final void setCanFly(Object fly) {call(C, "setCanFly", toInt(fly));}
	public static final void setExhaustion(Object par) {call(C, "setExhaustion", toInt(par));}
	public static final void setExp(Object par) {call(C, "setExp", toDouble(par));}
	public static final void setFlying(boolean par) {call(C, "setFlying", par);}
	public static final void setHealth(Object par) {call(C, "setHealth", toInt(par));}
	public static final void setHunger(Object par) {call(C, "setHunger", toDouble(par));}
	public static final void setInventorySlot(Object slot, final Object id, final Object num, final Object data) {call(C, "setInventorySlot", toInt(slot), toInt(id), toInt(num), toInt(data));}
	public static final void setItemCustomName(Object id, final String name) {call(C, "setItemCustomName", toInt(id), name);}
	public static final void setLevel(Object level) {call(C, "setLevel", toInt(level));}
	public static final void setSelectedSlotId(Object level) {call(C, "setSelectedSlotId", toInt(level));}
	public static final void setSaturation(Object level) {call(C, "setSaturation", toDouble(level));}
}
