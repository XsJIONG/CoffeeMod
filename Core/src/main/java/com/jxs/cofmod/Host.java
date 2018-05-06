package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Host extends Modable {
	public static final void print(String text) {}
	public static final double getPlayerX() {return 0;}
	public static final double getPlayerY() {return 0;}
	public static final double getPlayerZ() {return 0;}
	public static final long getPlayerEnt() {return 0;}
	public static final Object getLevel() {return null;}
	public static final void setPosition(Object ent, double x, double y, double z) {}
	public static final void setVelX(Object ent, double s) {}
	public static final void setVelY(Object ent, double s) {}
	public static final void setVelZ(Object ent, double s) {}
	public static final void explode(double x, double y, double z, double r, boolean fire) {}
	public static final void addItemInventory(int id, int amount, int damage) {}
	public static final void rideAnimal(Object rider, Object ani) {}
	public static final long spawnChicken(double x, double y, double z, String tex) {return 0;}
	public static final long spawnCow(double x, double y, double z, String tex) {return 0;}
	public static final int getCarriedItem() {return 0;}
	public static final void preventDefault() {}
	public static final void setTile(int x, int y, int z, int id, int damage) {}
	public static final void clientMessage(String text) {}
	public static final void setNightMode(boolean night) {}
	public static final int getTile(int x, int y, int z) {return 0;}
	public static final void setPositionRelative(Object ent, double x, double y, double z) {}
	public static final void setRot(Object ent, double yaw, double pitch) {}
	public static final double getPitch(Object ent) {return 0;}
	public static final double getYaw(Object ent) {return 0;}
	public static final long spawnPigZombie(double x, double y, double z, int item, String tex) {return 0;}
	public static final long bl_spawnMob(double x, double y, double z, int id, String tex) {return 0;}
	public static final void bl_setMobSkin(Object ent, String tex) {}
}
