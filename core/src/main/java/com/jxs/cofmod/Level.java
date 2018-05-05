package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Level extends Modable {
	public static final int C=3;

	@Override
	public void onCreate() {}

    //固定函数
	public static final void addParticle(Object type, Object x, Object y, Object z, Object speedx, Object speedy, Object speedz, Object size) {call(C, "addParticle", toInt(type), toDouble(x), toDouble(y), toDouble(z), toDouble(speedx), toDouble(speedy), toDouble(speedz), toInt(size));}
	public static final String biomeIdToName(Object par) {return (String) call(C, "biomeIdToName", toInt(par));}
	public static final boolean canSeeSky(Object x, Object y, Object z) {return call(C, "canSeeSky", toInt(x), toInt(y), toInt(z));}
	public static final void destroyBlock(Object x, Object y, Object z, boolean dl) {call(C, "destroyBlock", toInt(x), toInt(y), toInt(z), dl);}
	public static final void dropItem(Object x, Object y, Object z, Object yarea, Object id, Object count, Object damage) {call(C, "dropItem", toDouble(x), toDouble(y), toDouble(z), toDouble(yarea), toInt(id), toInt(count), toInt(damage));}
	public static final void explode(Object x, Object y, Object z, Object radiu, boolean fire) {call(C, "explode", toDouble(x), toDouble(y), toDouble(z), toDouble(radiu), fire);}
	public static final String getAddress() {return (String) call(C, "getAddress");}
	public static final int getBiome(Object x, Object y) {return call(C, "getBiome", toInt(x), toInt(y));}
	public static final String getBiomeName(Object x, Object y) {return (String) call(C, "getBiomeName", toInt(x), toInt(y));}
	public static final int getBrightness(Object x, Object y, Object z) {return call(C, "getBrightness", toInt(x), toInt(y), toInt(z));}
	public static final int getChestSlot(Object x, Object y, Object z, Object num) {return call(C, "getChestSlot", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getChestSlotCount(Object x, Object y, Object z, Object num) {return call(C, "getChestSlotCount", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final String getChestSlotCustomName(Object x, Object y, Object z, Object num) {return (String) call(C, "getChestSlotCustomName", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getChestSlotData(Object x, Object y, Object z, Object num) {return call(C, "getChestSlotData", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getData(Object x, Object y, Object z) {return call(C, "getData", toInt(x), toInt(y), toInt(z));}
	public static final int getDifficulty() {return call(C, "getDifficulty");}
	public static final int getFurnaceSlot(Object x, Object y, Object z, Object num) {return call(C, "getFurnaceSlot", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getFurnaceSlotCount(Object x, Object y, Object z, Object num) {return call(C, "getFurnaceSlotCount", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getFurnaceSlotData(Object x, Object y, Object z, Object num) {return call(C, "getFurnaceSlotData", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getGameMode() {return call(C, "getGameMode");}
	public static final int getGrassColor(Object x, Object z) {return call(C, "getGrassColor", toInt(x), toInt(z));}
	public static final int getLightningLevel() {return call(C, "getLightningLevel");}
	public static final boolean getRainLevel() {return call(C, "getRainLevel");}
	public static final String getSignText(Object x, Object y, Object z, Object num) {return (String) call(C, "getSignText", toInt(x), toInt(y), toInt(z), toInt(num));}
	public static final int getTile(Object x, Object y, Object z) {return call(C, "getTile", toInt(x), toInt(y), toInt(z));}
	public static final long getTime() {return call(C, "getTime");}
	public static final String getWorldDir() {return (String) call(C, "getWorldDir");}
	public static final String getWorldName() {return (String) call(C, "getWorldName");}
	public static final void playSound(Object x, Object y, Object z, String name, Object vool, Object yd) {call(C, "playSound", toDouble(x), toDouble(y), toDouble(z), name, toDouble(vool), toDouble(yd));}
	public static final void playSoundEnt(Object obj, String name, Object vool, Object yd) {call(C, "playSoundEnt", obj, name, toDouble(vool), toDouble(yd));}
	public static final void setChestSlot(Object x, Object y, Object z, Object slot, Object id, Object data, Object num) {call(C, "setChestSlot", toInt(x), toInt(y), toInt(z), toInt(slot), toInt(id), toInt(data), toInt(num));}
	public static final void setChestSlotCustomName(Object x, Object y, Object z, Object clot, String name) {call(C, "setChestSlotCustomName", toInt(x), toInt(y), toInt(z), toInt(clot), name);}
	public static final void setDifficulty(Object difficulty) {call(C, "setDifficulty", toInt(difficulty));}
	public static final void setFurnaceSlot(Object x, Object y, Object z, Object slot, Object id, Object data, Object num) {call(C, "setFurnaceSlot", toInt(x), toInt(y), toInt(z), toInt(slot), toInt(id), toInt(data), toInt(num));}
	public static final void setGameMode(Object mode) {call(C, "setGameMode", toInt(mode));}
	public static final void setGrassColor(Object x, Object z, Object color) {call(C, "setGrassColor", toInt(x), toInt(z), toLong(color));}
	public static final void setLightningLevel(Object par) {call(C, "setLightningLevel", toDouble(par));}
	public static final void setNightMode(boolean par) {call(C, "setNightMode", par);}
	public static final void setRainLevel(Object par) {call(C, "setRainLevel", toDouble(par));}
	public static final void setSignText(Object x, Object y, Object z, Object lan, String string) {call(C, "setSignText", toInt(x), toInt(y), toInt(z), toInt(lan), string);}
	public static final void setSpawn(Object x, Object y, Object z) {call(C, "setSpawn", toInt(x), toInt(y), toInt(z));}
	public static final void setSpawnerEntityType(Object x, Object y, Object z, Object id) {call(C, "setSpawnerEntityType", toInt(x), toInt(y), toInt(z), toInt(id));}
	public static final void setTile(Object x, Object y, Object z, Object id, Object data) {call(C, "setTile", toInt(x), toInt(y), toInt(z), toInt(id), toInt(data));}
	public static final void setTile(Object x, Object y, Object z, Object id) {call(C, "setTile", toInt(x), toInt(y), toInt(z), toInt(id));}
	public static final void setTime(Object time) {call(C, "setTime", toInt(time));}
	@Deprecated public static final long spawnChicken(Object x, Object y, Object z, String name) {return call(C, "spawnChicken", toDouble(x), toDouble(y), toDouble(z), name);}
	@Deprecated public static final long spawnCow(Object x, Object y, Object z, String name) {return call(C, "spawnCow", toDouble(x), toDouble(y), toDouble(z), name);}
	public static final long spawnMob(Object x, Object y, Object z, Object id) {return call(C, "spawnMob", toDouble(x), toDouble(y), toDouble(z), toInt(id));}
	public static final long spawnMob(Object x, Object y, Object z, Object id, String name) {return call(C, "spawnMob", toDouble(x), toDouble(y), toDouble(z), toInt(id), name);}
}
