package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import static com.jxs.cofmod.S.*;

public class Level extends Modable {
	public static final int C=3;

	@Override
	public void onCreate() {}

    //固定函数
	public static final void addParticle(Object p1, double p2, double p3, double p4, double p5, double p6, double p7, int p8) {call(C, "addParticle", p1, p2, p3, p4, p5, p6, p7, p8);}
	public static final String biomeIdToName(int p1) {return (String) call(C, "biomeIdToName", p1);}
	public static final boolean canSeeSky(int p1, int p2, int p3) {return call(C, "canSeeSky", p1, p2, p3);}
	public static final void destroyBlock(int p1, int p2, int p3, boolean p4) {call(C, "destroyBlock", p1, p2, p3, p4);}
	public static final long dropItem(double p1, double p2, double p3, double p4, int p5, int p6, int p7) {return call(C, "dropItem", p1, p2, p3, p4, p5, p6, p7);}
	public static final void explode(double p1, double p2, double p3, double p4, boolean p5, boolean p6, double p7) {call(C, "explode", p1, p2, p3, p4, p5, p6, p7);}
	public static final NativePointer getAddress() {
		Object obj=call(C, "getAddress");
		if (obj==null) return null;
		try {
			return new NativePointer(obj.getClass().getField("value").getLong(obj));
		} catch (Throwable t) {return null;}
	}
	public static final int getBiome(int p1, int p2) {return call(C, "getBiome", p1, p2);}
	public static final String getBiomeName(int p1, int p2) {return (String) call(C, "getBiomeName", p1, p2);}
	public static final int getBrightness(int p1, int p2, int p3) {return call(C, "getBrightness", p1, p2, p3);}
	public static final int getChestSlot(int p1, int p2, int p3, int p4) {return call(C, "getChestSlot", p1, p2, p3, p4);}
	public static final int getChestSlotCount(int p1, int p2, int p3, int p4) {return call(C, "getChestSlotCount", p1, p2, p3, p4);}
	public static final String getChestSlotCustomName(int p1, int p2, int p3, int p4) {return (String) call(C, "getChestSlotCustomName", p1, p2, p3, p4);}
	public static final int getChestSlotData(int p1, int p2, int p3, int p4) {return call(C, "getChestSlotData", p1, p2, p3, p4);}
	public static final int getData(int p1, int p2, int p3) {return call(C, "getData", p1, p2, p3);}
	public static final int getDifficulty() {return call(C, "getDifficulty");}
	public static final int getFurnaceSlot(int p1, int p2, int p3, int p4) {return call(C, "getFurnaceSlot", p1, p2, p3, p4);}
	public static final int getFurnaceSlotCount(int p1, int p2, int p3, int p4) {return call(C, "getFurnaceSlotCount", p1, p2, p3, p4);}
	public static final int getFurnaceSlotData(int p1, int p2, int p3, int p4) {return call(C, "getFurnaceSlotData", p1, p2, p3, p4);}
	public static final int getGameMode() {return call(C, "getGameMode");}
	public static final int getGrassColor(int p1, int p2) {return call(C, "getGrassColor", p1, p2);}
	public static final double getLightningLevel() {return call(C, "getLightningLevel");}
	public static final double getRainLevel() {return call(C, "getRainLevel");}
	public static final String getSignText(int p1, int p2, int p3, int p4) {return (String) call(C, "getSignText", p1, p2, p3, p4);}
	public static final int getSpawnerEntityType(int p1, int p2, int p3) {return call(C, "getSpawnerEntityType", p1, p2, p3);}
	public static final int getTile(int p1, int p2, int p3) {return call(C, "getTile", p1, p2, p3);}
	public static final int getTime() {return call(C, "getTime");}
	public static final String getWorldDir() {return (String) call(C, "getWorldDir");}
	public static final String getWorldName() {return (String) call(C, "getWorldName");}
	public static final void playSound(double p1, double p2, double p3, String p4, double p5, double p6) {call(C, "playSound", p1, p2, p3, p4, p5, p6);}
	public static final void playSoundEnt(Object p1, String p2, double p3, double p4) {call(C, "playSoundEnt", p1, p2, p3, p4);}
	public static final void setChestSlot(int p1, int p2, int p3, int p4, int p5, int p6, int p7) {call(C, "setChestSlot", p1, p2, p3, p4, p5, p6, p7);}
	public static final void setChestSlotCustomName(int p1, int p2, int p3, int p4, String p5) {call(C, "setChestSlotCustomName", p1, p2, p3, p4, p5);}
	public static final void setDifficulty(int p1) {call(C, "setDifficulty", p1);}
	public static final void setFurnaceSlot(int p1, int p2, int p3, int p4, int p5, int p6, int p7) {call(C, "setFurnaceSlot", p1, p2, p3, p4, p5, p6, p7);}
	public static final void setGameMode(int p1) {call(C, "setGameMode", p1);}
	public static final void setGrassColor(int p1, int p2, int p3) {call(C, "setGrassColor", p1, p2, p3);}
	public static final void setLightningLevel(double p1) {call(C, "setLightningLevel", p1);}
	public static final void setNightMode(boolean p1) {call(C, "setNightMode", p1);}
	public static final void setRainLevel(double p1) {call(C, "setRainLevel", p1);}
	public static final void setSignText(int p1, int p2, int p3, int p4, String p5) {call(C, "setSignText", p1, p2, p3, p4, p5);}
	public static final void setSpawn(int p1, int p2, int p3) {call(C, "setSpawn", p1, p2, p3);}
	public static final void setSpawnerEntityType(int p1, int p2, int p3, int p4) {call(C, "setSpawnerEntityType", p1, p2, p3, p4);}
	public static final void setTile(int p1, int p2, int p3, int p4, int p5) {call(C, "setTile", p1, p2, p3, p4, p5);}
	public static final void setTime(int p1) {call(C, "setTime", p1);}
	public static final long spawnChicken(double p1, double p2, double p3, String p4) {return call(C, "spawnChicken", p1, p2, p3, p4);}
	public static final long spawnCow(double p1, double p2, double p3, String p4) {return call(C, "spawnCow", p1, p2, p3, p4);}
	public static final long spawnMob(double p1, double p2, double p3, int p4, String p5) {return call(C, "spawnMob", p1, p2, p3, p4, p5);}
}
