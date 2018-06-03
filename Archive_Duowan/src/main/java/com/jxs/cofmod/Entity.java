package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import com.mcbox.pesdk.launcher.*;
import com.mcbox.pesdkb.mcpelauncher.*;
import com.mcbox.pesdkb.mcpelauncher.api.modpe.*;

public class Entity extends Modable {
	public static void setVelX(Object ent, double amount) {
		ScriptManager.nativeSetVel(ScriptManager.getEntityId(ent), (float) amount, 0);
	}

	public static void setVelY(Object ent, double amount) {
		ScriptManager.nativeSetVel(ScriptManager.getEntityId(ent), (float) amount, 1);
	}

	public static void setVelZ(Object ent, double amount) {
		ScriptManager.nativeSetVel(ScriptManager.getEntityId(ent), (float) amount, 2);
	}

	public static void setRot(Object ent, double yaw, double pitch) {
		ScriptManager.nativeSetRot(ScriptManager.getEntityId(ent), (float) yaw, (float) pitch);
	}

	public static void rideAnimal(Object rider, Object mount) {
		ScriptManager.nativeRideAnimal(ScriptManager.getEntityId(rider), ScriptManager.getEntityId(mount));
	}

	public static void setPosition(Object ent, double x, double y, double z) {
		ScriptManager.nativeSetPosition(ScriptManager.getEntityId(ent), (float) x, (float) y, (float) z);
	}

	public static void setPositionRelative(Object ent, double x, double y, double z) {
		ScriptManager.nativeSetPositionRelative(ScriptManager.getEntityId(ent), (float) x, (float) y, (float) z);
	}

	public static double getPitch(Object ent) {
		return (double) ScriptManager.nativeGetPitch(ScriptManager.getEntityId(ent));
	}

	public static double getYaw(Object ent) {
		return (double) ScriptManager.nativeGetYaw(ScriptManager.getEntityId(ent));
	}

	public static void setFireTicks(Object ent, int howLong) {
		ScriptManager.nativeSetOnFire(ScriptManager.getEntityId(ent), howLong);
	}

	public static double getX(Object ent) {
		return (double) ScriptManager.nativeGetEntityLoc(ScriptManager.getEntityId(ent), 0);
	}

	public static double getY(Object ent) {
		return (double) ScriptManager.nativeGetEntityLoc(ScriptManager.getEntityId(ent), 1);
	}

	public static double getZ(Object ent) {
		return (double) ScriptManager.nativeGetEntityLoc(ScriptManager.getEntityId(ent), 2);
	}

	public static void setCarriedItem(Object ent, int id, int count, int damage) {
		if (ScriptManager.nativeIsValidItem(id)) {
			ScriptManager.nativeSetCarriedItem(ScriptManager.getEntityId(ent), id, count, damage);
			return;
		}
		throw new IllegalArgumentException(S.join("物品", String.valueOf(id), "不可用"));
	}

	public static int getEntityTypeId(Object ent) {
		return ScriptManager.nativeGetEntityTypeId(ScriptManager.getEntityId(ent));
	}

	public static long spawnMob(double x, double y, double z, int typeId, String tex) {
		if (ScriptManager.invalidTexName(tex)) {
			tex = null;
		}
		return ScriptManager.nativeSpawnEntity((float) x, (float) y, (float) z, typeId, tex);
	}

	public static void setAnimalAge(Object animal, int age) {
		int type = getEntityTypeId(animal);
		if (type == 32 || type == 34 || type == 36)
			ScriptManager.nativeZombieSetBaby(ScriptManager.getEntityId(animal), age < 0);
		else if (type < 10 || type >= 32)
			throw new IllegalArgumentException("你只能给动物、僵尸、骷髅以及僵尸猪人设置年龄");
		else
			ScriptManager.nativeSetAnimalAge(ScriptManager.getEntityId(animal), age);
	}

	public static int getAnimalAge(Object animal) {
		int type = getEntityTypeId(animal);
		if (type == 32 || type == 34 || type == 36)
			return ScriptManager.nativeZombieIsBaby(ScriptManager.getEntityId(animal)) ? -24000 : 0;
		else {
			if (type >= 10 && type < 32)
				return ScriptManager.nativeGetAnimalAge(ScriptManager.getEntityId(animal));
			throw new IllegalArgumentException("你获取动物、僵尸、骷髅以及僵尸猪人的年龄");
		}
	}

	public static void setMobSkin(Object entity, String tex) {
		setMobSkinImpl(entity, tex, true);
	}

	public static void setMobSkinImpl(Object entity, String text, boolean persist) {
		String newSkinPath = OldEntityTextureFilenameMapping.m.get(text);
		if (newSkinPath != null) {
			text = newSkinPath;
		}
		ScriptManager.nativeSetMobSkin(ScriptManager.getEntityId(entity), text);
		if (!persist) {
			return;
		}
		if (LauncherManager.getInstance().getConfig().region == 1)
			setExtraData(entity, "mcpe.tool.s", text);
		else
			setExtraData(entity, "mcpe.master.s", text);
	}

	public static void remove(Object ent) {
		ScriptManager.nativeRemoveEntity(ScriptManager.getEntityId(ent));
	}

	public static int getHealth(Object ent) {
		int entityType = getEntityTypeId(ent);
		if (entityType >= 104) {
			return ScriptManager.nativeGetMobHealth(ScriptManager.getEntityId(ent));
		}
		if (entityType < 10 || entityType >= 64) {
			return 0;
		}
		return ScriptManager.nativeGetMobHealth(ScriptManager.getEntityId(ent));
	}

	public static void setHealth(Object ent, int halfhearts) {
		int entityType = getEntityTypeId(ent);
		if ((entityType >= 10 && entityType < 64) || entityType >= 104) {
			ScriptManager.nativeSetMobHealth(ScriptManager.getEntityId(ent), halfhearts);
		}
	}

	public static void setMaxHealth(Object ent, int halfhearts) {
		int entityType = getEntityTypeId(ent);
		if ((entityType >= 10 && entityType < 64) || entityType >= 104) {
			ScriptManager.nativeSetMobMaxHealth(ScriptManager.getEntityId(ent), halfhearts);
		}
	}

	public static void setRenderType(Object ent, Object rtObj) {
		Renderer.NativeRenderer theRenderer;
		boolean alreadySet = false;
		if (rtObj instanceof Number) {
			int rendererId = ((Number) rtObj).intValue();
			setRenderTypeImpl(ent, rendererId);
			alreadySet = true;
			theRenderer = Renderer.getById(rendererId);
			if (theRenderer == null)
				return;
		} else if (rtObj instanceof Renderer.NativeRenderer)
			theRenderer = (Renderer.NativeRenderer) rtObj;
		else
			theRenderer = Renderer.getByName(rtObj.toString());
		if (!alreadySet)
			setRenderTypeImpl(ent, theRenderer.getRenderType());
		if (1 == LauncherManager.getInstance().getConfig().region)
			setExtraData(ent, "mcpe.tool.rt", theRenderer.getName());
		else
			setExtraData(ent, "mcpe.master.rt", theRenderer.getName());
	}

	public static void setRenderTypeImpl(Object ent, int renderType) {
		if (renderType < MinecraftConstants.LIB_LOAD_OFFSET && !EntityRenderType.isValidRenderType(renderType))
			throw new IllegalArgumentException("无法找到模型类型" + renderType);
		else if (renderType == 12 && getEntityTypeId(ent) != 15)
			throw new IllegalArgumentException("村民的模型只能用在村民身上");
		else if (!ScriptManager.nativeSetEntityRenderType(ScriptManager.getEntityId(ent), renderType))
			throw new IllegalArgumentException("无法找到自定义模型" + renderType);
	}

	public static void setSneaking(Object ent, boolean doIt) {
		ScriptManager.nativeSetSneaking(ScriptManager.getEntityId(ent), doIt);
	}

	public static boolean isSneaking(Object ent) {
		return ScriptManager.nativeIsSneaking(ScriptManager.getEntityId(ent));
	}

	public static double getVelX(Object ent) {
		return (double) ScriptManager.nativeGetEntityVel(ScriptManager.getEntityId(ent), 0);
	}

	public static double getVelY(Object ent) {
		return (double) ScriptManager.nativeGetEntityVel(ScriptManager.getEntityId(ent), 1);
	}

	public static double getVelZ(Object ent) {
		return (double) ScriptManager.nativeGetEntityVel(ScriptManager.getEntityId(ent), 2);
	}

	public static void setNameTag(Object entity, String name) {
		if (ScriptManager.nativeGetEntityTypeId(ScriptManager.getEntityId(entity)) >= 64)
			throw new IllegalArgumentException("setNameTag只能用在动物或怪物身上");
		ScriptManager.nativeEntitySetNameTag(ScriptManager.getEntityId(entity), name);
	}

	public static long[] getAll() {
		long[] entities;
		synchronized (ScriptManager.allentities) {
			entities = new long[ScriptManager.allentities.size()];
			for (int n = 0; entities.length > n; n++)
				entities[n] = ScriptManager.allentities.get(n).longValue();
		}
		return entities;
	}

	public static String getNameTag(Object entity) {
		return ScriptManager.nativeEntityGetNameTag(ScriptManager.getEntityId(entity));
	}

	public static int getRiding(Object entity) {
		return ScriptManager.nativeEntityGetRiding(ScriptManager.getEntityId(entity));
	}

	public static int getRider(Object entity) {
		return ScriptManager.nativeEntityGetRider(ScriptManager.getEntityId(entity));
	}

	public static String getMobSkin(Object entity) {
		int entityType = getEntityTypeId(Long.valueOf(ScriptManager.getEntityId(entity)));
		if (entityType <= 0 || (entityType >= 64 && entityType < 104)) {
			return "";
		}
		return ScriptManager.nativeEntityGetMobSkin(ScriptManager.getEntityId(entity));
	}

	public static int getRenderType(Object entity) {
		return ScriptManager.nativeEntityGetRenderType(ScriptManager.getEntityId(entity));
	}

	public static String getUniqueId(Object entity) {
		return ScriptManager.getEntityUUID(ScriptManager.getEntityId(entity));
	}

	public static void setCollisionSize(Object entity, double a, double b) {
		ScriptManager.nativeEntitySetSize(ScriptManager.getEntityId(entity), (float) a, (float) b);
	}

	public static void setCape(Object entity, String location) {
		int typeId = ScriptManager.nativeGetEntityTypeId(ScriptManager.getEntityId(entity));
		if (typeId < 32 || (typeId >= 64 && typeId < 104))
			throw new IllegalArgumentException("setCape只能使用在人形生物上");
		ScriptManager.nativeSetCape(ScriptManager.getEntityId(entity), location);
	}

	public static void addEffect(Object entity, int potionId, int duration, int amplifier, boolean isAmbient, boolean showParticles) {
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if (typeId <= 0 || (typeId >= 64 && typeId < 104))
			throw new IllegalArgumentException("addEffect只能使用在类型id不在1,64范围之类的生物身上:" + typeId);
		else if (MobEffect.effectIds.get(Integer.valueOf(potionId)) == null)
			throw new IllegalArgumentException("无法找到指定药水效果:" + potionId);
		else
			ScriptManager.nativeMobAddEffect(entityId, potionId, duration, amplifier, isAmbient, showParticles);
	}

	public static void removeEffect(Object entity, int potionId) {
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if (typeId != 0) {
			if (typeId < 0 || (typeId >= 64 && typeId < 104))
				throw new IllegalArgumentException("removeEffect只能对生物或怪物使用");
			else if (MobEffect.effectIds.get(Integer.valueOf(potionId)) == null)
				throw new IllegalArgumentException("无法找到指定药水效果:" + potionId);
			else
				ScriptManager.nativeMobRemoveEffect(entityId, potionId);
		}
	}

	public static void removeAllEffects(Object entity) {
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if (typeId != 0) {
			if (typeId < 0 || (typeId >= 64 && typeId < 104)) {
				throw new RuntimeException("removeAllEffects only works for mobs");
			}
			ScriptManager.nativeMobRemoveAllEffects(entityId);
		}
	}

	public static int getItemEntityId(Object entity) {
		long entityId = ScriptManager.getEntityId(entity);
		if (ScriptManager.nativeGetEntityTypeId(entityId) == 64) {
			return ScriptManager.nativeGetItemEntityItem(entityId, 0);
		}
		return -1;
	}

	public static int getItemEntityData(Object entity) {
		long entityId = ScriptManager.getEntityId(entity);
		if (ScriptManager.nativeGetEntityTypeId(entityId) == 64)
			return ScriptManager.nativeGetItemEntityItem(entityId, 1);
		throw new IllegalArgumentException("getItemEntity只能使用在物品实体上");
	}

	public static int getItemEntityCount(Object entity) {
		long entityId = ScriptManager.getEntityId(entity);
		if (ScriptManager.nativeGetEntityTypeId(entityId) == 64)
			return ScriptManager.nativeGetItemEntityItem(entityId, 2);
		throw new IllegalArgumentException("getItemEntityCount只能使用在物品实体上");
	}

	public static int getArmor(Object entity, int slot) {
		if (slot < 0 || slot >= 4)
			throw new IllegalArgumentException(S.join("第",String.valueOf(slot),"格不是一个可用的盔甲格"));
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if ((typeId > 0 && typeId < 64) || typeId >= 104)
			return ScriptManager.nativeMobGetArmor(entityId, slot, 0);
		throw new IllegalArgumentException("getArmor只能使用在生物或怪物上");
	}

	public static int getArmorDamage(Object entity, int slot) {
		if (slot < 0 || slot >= 4)
			throw new IllegalArgumentException(S.join("第",String.valueOf(slot),"格不是一个可用的盔甲格"));
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if ((typeId > 0 && typeId < 64) || typeId >= 104)
			return ScriptManager.nativeMobGetArmor(entityId, slot, 1);
		throw new IllegalArgumentException("getArmorDamage只能使用在生物或怪物上");
	}

	public static void setArmor(Object entity, int slot, int id, int damage) {
		if (slot < 0 || slot >= 4)
			throw new IllegalArgumentException(S.join("第",String.valueOf(slot),"格不是一个可用的盔甲格"));
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if (typeId != 0) {
			if (typeId < 0 || (typeId >= 64 && typeId < 104))
				throw new IllegalArgumentException("setArmor只能使用在生物或怪物上");
			ScriptManager.nativeMobSetArmor(entityId, slot, id, damage);
		}
	}

	public static int getMaxHealth(Object entity) {
		return ScriptManager.nativeGetMobMaxHealth(ScriptManager.getEntityId(entity));
	}

	public static String getExtraData(Object entity, String key) {
		if (ScriptManager.worldData == null)
			return null;
		return ScriptManager.worldData.getEntityData(ScriptManager.getEntityId(entity), key);
	}

	public static boolean setExtraData(Object entity, String key, String value) {
		if (ScriptManager.worldData == null) {
			return false;
		}
		ScriptManager.worldData.setEntityData(ScriptManager.getEntityId(entity), key, value);
		return true;
	}

	public static String getArmorCustomName(Object entity, int slot) {
		if (slot < 0 || slot >= 4)
			throw new IllegalArgumentException(S.join("第",String.valueOf(slot),"格不是一个可用的盔甲格"));
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if ((typeId > 0 && typeId < 64) || typeId >= 104)
			return ScriptManager.nativeMobGetArmorCustomName(entityId, slot);
		throw new IllegalArgumentException("setArmor只能使用在生物或怪物上");
	}

	public static void setArmorCustomName(Object entity, int slot, String name) {
		if (slot < 0 || slot >= 4)
			throw new IllegalArgumentException(S.join("第",String.valueOf(slot),"格不是一个可用的盔甲格"));
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if (typeId != 0) {
			if (typeId < 0 || (typeId >= 64 && typeId < 104))
				throw new IllegalArgumentException("setArmor只能使用在生物或怪物上");
			ScriptManager.nativeMobSetArmorCustomName(entityId, slot, name);
		}
	}

	public static void setImmobile(Object entity, boolean immobile) {
		setImmobileImpl(entity, immobile);
		if (1 == LauncherManager.getInstance().getConfig().region)
			setExtraData(entity, "mcpe.tool.im", immobile ? "1" : "0");
		else
			setExtraData(entity, "mcpe.master.im", immobile ? "1" : "0");
	}

	public static void setImmobileImpl(Object entity, boolean immobile) {
		ScriptManager.nativeEntitySetImmobile(ScriptManager.getEntityId(entity), immobile);
	}

	public static long getTarget(Object entity) {
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if ((typeId > 0 && typeId < 64) || typeId >= 104)
			return ScriptManager.nativeEntityGetTarget(entityId);
		throw new IllegalArgumentException("getTarget只能使用在生物或怪物上");
	}

	public static void setTarget(Object entity, Object target) {
		long entityId = ScriptManager.getEntityId(entity);
		int typeId = ScriptManager.nativeGetEntityTypeId(entityId);
		if (typeId < 0 || (typeId >= 64 && typeId < 104)) {
			throw new IllegalArgumentException("setTarget只能使用在生物或怪物上");
		} else if (typeId != 0) {
			long targetId = target == null ? -1 : ScriptManager.getEntityId(target);
			if (targetId != -1) {
				int targetTypeId = ScriptManager.nativeGetEntityTypeId(targetId);
				if (targetTypeId < 0 || (targetTypeId >= 64 && targetTypeId < 104)) {
					throw new IllegalArgumentException("setTarget只能使用在生物或怪物上:" + targetTypeId);
				} else if (targetTypeId == 0) {
					return;
				}
			}
			ScriptManager.nativeEntitySetTarget(entityId, targetId);
		}
	}
}
