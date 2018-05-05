package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Level extends Modable {
	public static final int C=3;

	@Override
	public void onCreate() {}

    //固定函数
	public static final void addParticle(Object p1, double p2, double p3, double p4, double p5, double p6, double p7, int p8) {}
	public static final String biomeIdToName(int p1) {return null;}
	public static final boolean canSeeSky(int p1, int p2, int p3) {return false;}
	public static final void destroyBlock(int p1, int p2, int p3, boolean p4) {}
	public static final long dropItem(double p1, double p2, double p3, double p4, int p5, int p6, int p7) {return 0;}
	public static final void explode(double p1, double p2, double p3, double p4, boolean p5, boolean p6, double p7) {}
	public static final Object getAddress() {return null;}
	public static final int getBiome(int p1, int p2) {return 0;}
	public static final String getBiomeName(int p1, int p2) {return null;}
	public static final int getBrightness(int p1, int p2, int p3) {return 0;}
	public static final int getChestSlot(int p1, int p2, int p3, int p4) {return 0;}
	public static final int getChestSlotCount(int p1, int p2, int p3, int p4) {return 0;}
	public static final String getChestSlotCustomName(int p1, int p2, int p3, int p4) {return null;}
	public static final int getChestSlotData(int p1, int p2, int p3, int p4) {return 0;}
	public static final int getData(int p1, int p2, int p3) {return 0;}
	public static final int getDifficulty() {return 0;}
	public static final int getFurnaceSlot(int p1, int p2, int p3, int p4) {return 0;}
	public static final int getFurnaceSlotCount(int p1, int p2, int p3, int p4) {return 0;}
	public static final int getFurnaceSlotData(int p1, int p2, int p3, int p4) {return 0;}
	public static final int getGameMode() {return 0;}
	public static final int getGrassColor(int p1, int p2) {return 0;}
	public static final double getLightningLevel() {return 0;}
	public static final double getRainLevel() {return 0;}
	public static final String getSignText(int p1, int p2, int p3, int p4) {return null;}
	public static final int getSpawnerEntityType(int p1, int p2, int p3) {return 0;}
	public static final int getTile(int p1, int p2, int p3) {return 0;}
	public static final int getTime() {return 0;}
	public static final String getWorldDir() {return null;}
	public static final String getWorldName() {return null;}
	public static final void playSound(double p1, double p2, double p3, String p4, double p5, double p6) {}
	public static final void playSoundEnt(Object p1, String p2, double p3, double p4) {}
	public static final void setChestSlot(int p1, int p2, int p3, int p4, int p5, int p6, int p7) {}
	public static final void setChestSlotCustomName(int p1, int p2, int p3, int p4, String p5) {}
	public static final void setDifficulty(int p1) {}
	public static final void setFurnaceSlot(int p1, int p2, int p3, int p4, int p5, int p6, int p7) {}
	public static final void setGameMode(int p1) {}
	public static final void setGrassColor(int p1, int p2, int p3) {}
	public static final void setLightningLevel(double p1) {}
	public static final void setNightMode(boolean p1) {}
	public static final void setRainLevel(double p1) {}
	public static final void setSignText(int p1, int p2, int p3, int p4, String p5) {}
	public static final void setSpawn(int p1, int p2, int p3) {}
	public static final void setSpawnerEntityType(int p1, int p2, int p3, int p4) {}
	public static final void setTile(int p1, int p2, int p3, int p4, int p5) {}
	public static final void setTime(int p1) {}
	public static final long spawnChicken(double p1, double p2, double p3, String p4) {return 0;}
	public static final long spawnCow(double p1, double p2, double p3, String p4) {return 0;}
	public static final long spawnMob(double p1, double p2, double p3, int p4, String p5) {return 0;}
}
