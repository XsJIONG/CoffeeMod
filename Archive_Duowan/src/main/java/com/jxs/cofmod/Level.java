package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import com.mcbox.pesdkb.mcpelauncher.*;
import com.mcbox.pesdkb.mcpelauncher.api.modpe.*;

public class Level extends Modable {
	public static void setNightMode(boolean isNight) {
		ScriptManager.nativeSetNightMode(isNight);
	}

	public static int getTile(int x, int y, int z) {
		return ScriptManager.nativeGetTileWrap(x, y, z);
	}

	public static void explode(double x, double y, double z, double radius, boolean onfire, boolean smoke, double somethingelse) {
		ScriptManager.nativeExplode((float) x, (float) y, (float) z, (float) radius, onfire, smoke, (float) somethingelse);
	}

	public static void setTile(int x, int y, int z, int id, int damage) {
		if (id >= 256) {
			ScriptManager.nativeSetTile(x, y, z, 0, 0);
			ScriptManager.nativeSetTile(x, y, z, 245, damage);
			ScriptManager.nativeLevelSetExtraData(x, y, z, id);
			return;
		}
		ScriptManager.nativeSetTile(x, y, z, id, damage);
	}

	public static NativePointer getAddress() {
		return new NativePointer(ScriptManager.nativeGetLevel());
	}

	public static long spawnChicken(double x, double y, double z, String tex) {
		if (ScriptManager.invalidTexName(tex))
			tex = "textures/entity/chicken";
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, 10, tex);
	}

	public static long spawnCow(double x, double y, double z, String tex) {
		if (ScriptManager.invalidTexName(tex))
			tex = "textures/entity/cow/cow";
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, 11, tex);
	}

	public static long spawnMob(double x, double y, double z, int typeId, String tex) {
		if (ScriptManager.invalidTexName(tex)) {
			tex = null;
		}
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, typeId, tex);
	}

	public static String getSignText(int x, int y, int z, int line) {
		if (line >= 0 && line < 4) {
			return ScriptManager.nativeGetSignText(x, y, z, line);
		}
		throw new IllegalArgumentException("告示牌的文字行数必须介于0和3之间");
	}

	public static void setSignText(int x, int y, int z, int line, String newText) {
		if (line < 0 || line >= 4)
			throw new IllegalArgumentException("告示牌的文字行数必须介于0和3之间");
		ScriptManager.nativeSetSignText(x, y, z, line, newText);
	}

	public static int getData(int x, int y, int z) {
		return ScriptManager.nativeGetData(x, y, z);
	}

	public static String getWorldName() {
		return ScriptManager.worldName;
	}

	public static String getWorldDir() {
		return ScriptManager.worldDir;
	}

	public static long dropItem(double x, double y, double z, double range, int id, int count, int damage) {
		return ScriptManager.nativeDropItem((float) x, (float) y, (float) z, (float) range, id, count, damage);
	}

	public static void setGameMode(int type) {
		ScriptManager.nativeSetGameType(type);
	}

	public static int getGameMode() {
		return ScriptManager.nativeGetGameType();
	}

	public static int getTime() {
		return (int) ScriptManager.nativeGetTime();
	}

	public static void setTime(int time) {
		ScriptManager.nativeSetTime((long) time);
	}

	public static void setSpawn(int x, int y, int z) {
		ScriptManager.nativeSetSpawn(x, y, z);
	}

	public static void destroyBlock(int x, int y, int z, boolean shouldDrop) {
		int itmId = getTile(x, y, z);
		int itmDmg = getData(x, y, z);
		ScriptManager.nativeDestroyBlock(x, y, z);
		if (shouldDrop) {
			dropItem(((double) x) + 0.5d, (double) y, ((double) z) + 0.5d, 1.0d, itmId, 1, itmDmg);
		}
	}

	public static void setChestSlot(int x, int y, int z, int slot, int id, int damage, int amount) {
		ScriptManager.nativeAddItemChest(x, y, z, slot, id, damage, amount);
	}

	public static int getChestSlot(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemChest(x, y, z, slot);
	}

	public static int getChestSlotData(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemDataChest(x, y, z, slot);
	}

	public static int getChestSlotCount(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemCountChest(x, y, z, slot);
	}

	public static void playSound(double x, double y, double z, String sound, double volume, double pitch) {
		ScriptManager.nativePlaySound((float) x, (float) y, (float) z, sound, volume <= 0.0d ? 1.0f : (float) volume, pitch <= 0.0d ? 1.0f : (float) pitch);
	}

	public static void playSoundEnt(Object ent, String sound, double volume, double pitch) {
		float f = 1.0f;
		float x = ScriptManager.nativeGetEntityLoc(ScriptManager.getEntityId(ent), 0);
		float y = ScriptManager.nativeGetEntityLoc(ScriptManager.getEntityId(ent), 1);
		float z = ScriptManager.nativeGetEntityLoc(ScriptManager.getEntityId(ent), 2);
		float f2 = volume <= 0.0d ? 1.0f : (float) volume;
		if (pitch > 0.0d) {
			f = (float) pitch;
		}
		ScriptManager.nativePlaySound(x, y, z, sound, f2, f);
	}

	public static int getBrightness(int x, int y, int z) {
		return ScriptManager.nativeGetBrightness(x, y, z);
	}

	public static void setFurnaceSlot(int x, int y, int z, int slot, int id, int damage, int amount) {
		ScriptManager.nativeAddItemFurnace(x, y, z, slot, id, damage, amount);
	}

	public static int getFurnaceSlot(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemFurnace(x, y, z, slot);
	}

	public static int getFurnaceSlotData(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemDataFurnace(x, y, z, slot);
	}

	public static int getFurnaceSlotCount(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemCountFurnace(x, y, z, slot);
	}

	public static void addParticle(Object typeRaw, double x, double y, double z, double xVel, double yVel, double zVel, int size) {
		String type = ParticleType.getTypeFromRaw(typeRaw);
		if (ParticleType.checkValid(type, size))
			ScriptManager.nativeLevelAddParticle(type, (float) x, (float) y, (float) z, (float) xVel, (float) yVel, (float) zVel, size);
	}

	public static int getBiome(int x, int z) {
		return ScriptManager.nativeLevelGetBiome(x, z);
	}

	public static String getBiomeName(int x, int z) {
		return ScriptManager.nativeLevelGetBiomeName(x, z);
	}

	public static String biomeIdToName(int id) {
		return ScriptManager.nativeBiomeIdToName(id);
	}

	public static int getGrassColor(int x, int z) {
		return ScriptManager.nativeLevelGetGrassColor(x, z);
	}

	public static void setGrassColor(int x, int z, int color) {
		ScriptManager.nativeLevelSetGrassColor(x, z, color);
	}

	public static void setSpawnerEntityType(int x, int y, int z, int type) {
		if (getTile(x, y, z) != 52)
			throw new IllegalArgumentException(S.join("位于(", String.valueOf(x), ",", String.valueOf(y), ",", String.valueOf(z), ")的方块不是一个刷怪箱"));
		ScriptManager.nativeSpawnerSetEntityType(x, y, z, type);
	}

	public static int getSpawnerEntityType(int x, int y, int z) {
		if (getTile(x, y, z) == 52)
			return ScriptManager.nativeSpawnerGetEntityType(x, y, z);
		throw new IllegalArgumentException(S.join("位于(", String.valueOf(x), ",", String.valueOf(y), ",", String.valueOf(z), ")的方块不是一个刷怪箱"));
	}

	public static double getLightningLevel() {
		return (double) ScriptManager.nativeLevelGetLightningLevel();
	}

	public static void setLightningLevel(double val) {
		ScriptManager.nativeLevelSetLightningLevel((float) val);
	}

	public static double getRainLevel() {
		return (double) ScriptManager.nativeLevelGetRainLevel();
	}

	public static void setRainLevel(double val) {
		ScriptManager.nativeLevelSetRainLevel((float) val);
	}

	public static boolean canSeeSky(int x, int y, int z) {
		return ScriptManager.nativeLevelCanSeeSky(x, y, z);
	}

	public static int getDifficulty() {
		return ScriptManager.nativeLevelGetDifficulty();
	}

	public static void setDifficulty(int difficulty) {
		ScriptManager.nativeLevelSetDifficulty(difficulty);
	}

	public static void setChestSlotCustomName(int x, int y, int z, int slot, String name) {
		ScriptManager.nativeSetItemNameChest(x, y, z, slot, name);
	}

	public static String getChestSlotCustomName(int x, int y, int z, int slot) {
		return ScriptManager.nativeGetItemNameChest(x, y, z, slot);
	}
}
