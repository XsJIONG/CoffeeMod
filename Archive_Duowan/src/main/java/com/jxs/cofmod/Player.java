package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import com.mcbox.pesdkb.mcpelauncher.*;

public class Player {
	private static long playerEnt = 0;
	
	public static double getX() {
		return (double) ScriptManager.nativeGetPlayerLoc(0);
	}

	public static double getY() {
		return (double) ScriptManager.nativeGetPlayerLoc(1);
	}

	public static double getZ() {
		return (double) ScriptManager.nativeGetPlayerLoc(2);
	}

	public static long getEntity() {
		playerEnt = ScriptManager.nativeGetPlayerEnt();
		return playerEnt;
	}

	public static int getCarriedItem() {
		return ScriptManager.nativeGetCarriedItem(0);
	}

	public static void addItemInventory(int id, int amount, int damage) {
		if (ScriptManager.nativeIsValidItem(id)) {
			ScriptManager.nativeAddItemInventory(id, amount, damage);
			return;
		}
		throw new IllegalArgumentException("不可用的物品ID:" + id);
	}

	public static void setHealth(int value) {
		ScriptManager.nativeSetMobHealth(ScriptManager.nativeGetPlayerEnt(), value);
	}

	public static int getSelectedSlotId() {
		return ScriptManager.nativeGetSelectedSlotId();
	}

	public static void setSelectedSlotId(int slot) {
		ScriptManager.nativeSetSelectedSlotId(slot);
	}

	public static void clearInventorySlot(int slot) {
		ScriptManager.nativeClearSlotInventory(slot);
	}

	public static void setInventorySlot(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
		ScriptManager.nativeSetInventorySlot(paramInt1, paramInt2, paramInt3, paramInt4);
	}

	public static int getInventorySlot(int slot) {
		return ScriptManager.nativeGetSlotInventory(slot, 0);
	}

	public static int getInventorySlotData(int slot) {
		return ScriptManager.nativeGetSlotInventory(slot, 1);
	}

	public static int getInventorySlotCount(int slot) {
		return ScriptManager.nativeGetSlotInventory(slot, 2);
	}

	public static int getCarriedItemData() {
		return ScriptManager.nativeGetCarriedItem(1);
	}

	public static int getCarriedItemCount() {
		return ScriptManager.nativeGetCarriedItem(2);
	}

	public static void addItemCreativeInv(int id, int count, int damage) {
		ScriptManager.nativeAddItemCreativeInv(id, count, damage);
	}

	public static int getArmorSlot(int slot) {
		return Entity.getArmor(Long.valueOf(getEntity()), slot);
	}

	public static int getArmorSlotDamage(int slot) {
		return Entity.getArmorDamage(Long.valueOf(getEntity()), slot);
	}

	public static void setArmorSlot(int slot, int id, int damage) {
		Entity.setArmor(Long.valueOf(getEntity()), slot, id, damage);
	}

	public static String getName(Object ent) {
		if (isPlayer(ent))
			return ScriptManager.nativeGetPlayerName(ScriptManager.getEntityId(ent));
		if (ent == null || ScriptManager.getEntityId(ent) == getEntity())
			return ScriptManager.getPlayerNameFromConfs();
		return "不是一个玩家";
	}

	public static boolean isPlayer(Object ent) {
		return Entity.getEntityTypeId(Long.valueOf(ScriptManager.getEntityId(ent))) == 63;
	}

	public static long getPointedEntity() {
		return ScriptManager.nativePlayerGetPointedEntity();
	}

	public static int getPointedBlockX() {
		return ScriptManager.nativePlayerGetPointedBlock(0);
	}

	public static int getPointedBlockY() {
		return ScriptManager.nativePlayerGetPointedBlock(1);
	}

	public static int getPointedBlockZ() {
		return ScriptManager.nativePlayerGetPointedBlock(2);
	}

	public static int getPointedBlockId() {
		return ScriptManager.nativePlayerGetPointedBlock(16);
	}

	public static int getPointedBlockData() {
		return ScriptManager.nativePlayerGetPointedBlock(17);
	}

	public static int getPointedBlockSide() {
		return ScriptManager.nativePlayerGetPointedBlock(18);
	}

	public static double getPointedVecX() {
		return (double) ScriptManager.nativePlayerGetPointedVec(0);
	}

	public static double getPointedVecY() {
		return (double) ScriptManager.nativePlayerGetPointedVec(1);
	}

	public static double getPointedVecZ() {
		return (double) ScriptManager.nativePlayerGetPointedVec(2);
	}

	public static boolean isFlying() {
		return ScriptManager.nativePlayerIsFlying();
	}

	public static void setFlying(boolean val) {
		ScriptManager.nativePlayerSetFlying(val);
	}

	public static boolean canFly() {
		return ScriptManager.nativePlayerCanFly();
	}

	public static void setCanFly(boolean val) {
		ScriptManager.nativePlayerSetCanFly(val);
	}

	public static int getDimension() {
		return ScriptManager.nativePlayerGetDimension();
	}

	public static double getHunger() {
		return (double) ScriptManager.nativePlayerGetHunger(getEntity());
	}

	public static void setHunger(double value) {
		ScriptManager.nativePlayerSetHunger(getEntity(), (float) value);
	}

	public static double getExhaustion() {
		return (double) ScriptManager.nativePlayerGetExhaustion();
	}

	public static void setExhaustion(double value) {
		ScriptManager.nativePlayerSetExhaustion((float) value);
	}

	public static double getSaturation() {
		return (double) ScriptManager.nativePlayerGetSaturation();
	}

	public static void setSaturation(double value) {
		ScriptManager.nativePlayerSetSaturation((float) value);
	}

	public static int getLevel() {
		return ScriptManager.nativePlayerGetLevel();
	}

	public static void setLevel(int value) {
		ScriptManager.nativePlayerSetLevel(value);
	}

	public static void addExp(int value) {
		ScriptManager.nativePlayerAddExperience(value);
	}

	public static double getExp() {
		return (double) ScriptManager.nativePlayerGetExperience();
	}

	public static void setExp(double value) {
		ScriptManager.nativePlayerSetExperience((float) value);
	}

	public static boolean enchant(int slot, int enchantment, int level) {
		if (enchantment >= 0 && enchantment <= 24) {
			return ScriptManager.nativePlayerEnchant(slot, enchantment, level);
		}
		throw new IllegalArgumentException("Invalid enchantment: " + enchantment);
	}

	public static EnchantmentInstance[] getEnchantments(int slot) {
		int[] ret = ScriptManager.nativePlayerGetEnchantments(slot);
		if (ret == null) {
			return null;
		}
		EnchantmentInstance[] en = new EnchantmentInstance[(ret.length / 2)];
		for (int i = 0; i < en.length; i++) {
			en[i] = new EnchantmentInstance(ret[i * 2], ret[(i * 2) + 1]);
		}
		return en;
	}

	public static String getItemCustomName(int slot) {
		return ScriptManager.nativePlayerGetItemCustomName(slot);
	}

	public static void setItemCustomName(int slot, String name) {
		ScriptManager.nativePlayerSetItemCustomName(slot, name);
	}

	public static int getScore() {
		return ScriptManager.nativePlayerGetScore();
	}
}
