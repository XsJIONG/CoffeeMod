package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import com.mcbox.pesdkb.mcpelauncher.*;

public class Host extends Modable {
	private static long playerEnt;
	public static final void print(String text) {
		ScriptManager.scriptPrint(text);
	}
	public static final double getPlayerX() {return ScriptManager.nativeGetPlayerLoc(0);}
	public static final double getPlayerY() {return ScriptManager.nativeGetPlayerLoc(1);}
	public static final double getPlayerZ() {return ScriptManager.nativeGetPlayerLoc(2);}
	public static final long getPlayerEnt() {return playerEnt = ScriptManager.nativeGetPlayerEnt();}
	public static final NativePointer getLevel() {return new NativePointer(ScriptManager.nativeGetLevel());}
	public static final void setPosition(Object ent, double x, double y, double z) {ScriptManager.nativeSetPosition(ScriptManager.getEntityId(ent), (float) x, (float) y, (float) z);}
	public static final void setVelX(Object ent, double s) {ScriptManager.nativeSetVel(ScriptManager.getEntityId(ent), (float) s, 0);}
	public static final void setVelY(Object ent, double s) {ScriptManager.nativeSetVel(ScriptManager.getEntityId(ent), (float) s, 1);}
	public static final void setVelZ(Object ent, double s) {ScriptManager.nativeSetVel(ScriptManager.getEntityId(ent), (float) s, 2);}
	public static final void explode(double x, double y, double z, double r, boolean fire) {try {ScriptManager.nativeExplode((float) x, (float) y, (float) z, (float) r, fire);} catch (Throwable t) {ScriptManager.nativeExplode((float) x, (float) y, (float) z, (float) r, fire, true, Float.POSITIVE_INFINITY);}}
	public static final void addItemInventory(int id, int amount, int damage) {ScriptManager.nativeAddItemInventory(id, amount, damage);}
	public static final void rideAnimal(Object rider, Object ani) {ScriptManager.nativeRideAnimal(ScriptManager.getEntityId(rider), ScriptManager.getEntityId(ani));}
	public static final long spawnChicken(double x, double y, double z, String tex) {
		if (ScriptManager.invalidTexName(tex)) tex = "mob.chicken";
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, 10, tex);
	}
	public static final long spawnCow(double x, double y, double z, String tex) {
		if (ScriptManager.invalidTexName(tex)) tex = "mob.cow";
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, 11, tex);
	}
	public static final int getCarriedItem() {return ScriptManager.nativeGetCarriedItem(0);}
	public static final void preventDefault() {ScriptManager.nativePreventDefault();}
	public static final void setTile(int x, int y, int z, int id, int damage) {ScriptManager.nativeSetTile(x, y, z, id, damage);}
	public static final void clientMessage(String text) {ScriptManager.wordWrapClientMessage(text);}
	public static final void setNightMode(boolean night) {ScriptManager.nativeSetNightMode(night);}
	public static final int getTile(int x, int y, int z) {return ScriptManager.nativeGetTile(x, y, z);}
	public static final void setPositionRelative(Object ent, double x, double y, double z) {ScriptManager.nativeSetPositionRelative(ScriptManager.getEntityId(ent), (float) x, (float) y, (float) z);}
	public static final void setRot(Object ent, double yaw, double pitch) {ScriptManager.nativeSetRot(ScriptManager.getEntityId(ent), (float) yaw, (float) pitch);}
	public static final double getPitch(Object entObj) {
		long ent;
		if (entObj == null || !(entObj instanceof Number))
			ent = getPlayerEnt();
		else
			ent = ((Number) entObj).longValue();
		return (double) ScriptManager.nativeGetPitch(ent);
	}
	public static final double getYaw(Object entObj) {
		long ent;
		if (entObj == null || !(entObj instanceof Number))
			ent = getPlayerEnt();
		else
			ent = ((Number) entObj).longValue();
		return (double) ScriptManager.nativeGetYaw(ent);
	}
	public static final long spawnPigZombie(double x, double y, double z, int item, String tex) {
		if (ScriptManager.invalidTexName(tex)) tex = "mob.pigzombie";
		long ent=ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, 36, tex);
		if (item == 0 || !ScriptManager.nativeIsValidItem(item)) item = 283;
		ScriptManager.nativeSetCarriedItem(ent, item, 1, 0);
		return ent;
	}
	public static final long bl_spawnMob(double x, double y, double z, int id, String tex) {
		if (ScriptManager.invalidTexName(tex)) tex = null;
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, id, tex);
	}
	public static final void bl_setMobSkin(Object ent, String tex) {ScriptManager.nativeSetMobSkin(ScriptManager.getEntityId(ent), tex);}
}
