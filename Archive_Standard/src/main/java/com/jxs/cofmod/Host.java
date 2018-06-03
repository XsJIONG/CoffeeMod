package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

import static com.jxs.cofmod.S.*;

public class Host extends Modable {
	public static final int C=-1;

	public static final void print(String text) {call(C, "print", C);}
	public static final double getPlayerX() {return call(C, "getPlayerX");}
	public static final double getPlayerY() {return call(C, "getPlayerY");}
	public static final double getPlayerZ() {return call(C, "getPlayerZ");}
	public static final long getPlayerEnt() {return call(C, "getPlayerEnt");}
	public static final NativePointer getLevel() {
		Object obj=call(C, "getLevel");
		if (obj == null) return null;
		try {
			return new NativePointer(obj.getClass().getField("value").getLong(obj));
		} catch (Throwable t) {return null;}
	}
	public static final void setPosition(Object ent, double x, double y, double z) {call(C, "setPosition", ent, x, y, z);}
	public static final void setVelX(Object ent, double s) {call(C, "setVelX", ent, s);}
	public static final void setVelY(Object ent, double s) {call(C, "setVelY", ent, s);}
	public static final void setVelZ(Object ent, double s) {call(C, "setVelZ", ent, s);}
	public static final void explode(double x, double y, double z, double r, boolean fire) {call(C, "explode", x, y, z, r, fire);}
	public static final void addItemInventory(int id, int amount, int damage) {call(C, "addItemInventory", id, amount, damage);}
	public static final void rideAnimal(Object rider, Object ani) {call(C, "rideAnimal", rider, ani);}
	public static final long spawnChicken(double x, double y, double z, String tex) {return call(C, "spawnChicken", x, y, z, tex);}
	public static final long spawnCow(double x, double y, double z, String tex) {return call(C, "spawnCow", x, y, z, tex);}
	public static final int getCarriedItem() {return call(C, "getCarriedItem");}
	public static final void preventDefault() {call(C, "preventDefault");}
	public static final void setTile(int x, int y, int z, int id, int damage) {call(C, "setTile", x, y, z, id, damage);}
	public static final void clientMessage(String text) {call(C, "clientMessage", text);}
	public static final void setNightMode(boolean night) {call(C, "setNightMode", night);}
	public static final int getTile(int x, int y, int z) {return call(C, "getTile", x, y, z);}
	public static final void setPositionRelative(Object ent, double x, double y, double z) {call(C, "setPositionRelative", ent, x, y, z);}
	public static final void setRot(Object ent, double yaw, double pitch) {call(C, "setRot", ent, yaw, pitch);}
	public static final double getPitch(Object ent) {return call(C, "getPitch", ent);}
	public static final double getYaw(Object ent) {return call(C, "getYaw", ent);}
	public static final long spawnPigZombie(double x, double y, double z, int item, String tex) {return call(C, "spawnPigZombie", x, y, z, item, tex);}
	public static final long bl_spawnMob(double x, double y, double z, int id, String tex) {return call(C, "bl_spawnMob", x, y, z, id, tex);}
	public static final void bl_setMobSkin(Object ent, String tex) {call(C, "bl_setMobSkin", ent, tex);}
}
