package com.jxs.cofmod;

import com.jxs.cofmod.control.Modable;
import com.jxs.cofmod.custome.AEntity;

public class Entity extends Modable {
	public static final int C=1;
	
	@Override
	public void onCreate() {}

	//自定义函数
	public AEntity spawn(double x, double y, double z) {
		return spawn(x, y, z, getSkin(), "");
	}
	public AEntity spawn(double x, double y, double z, String skin, String name) {
		AEntity e=new AEntity(Level.spawnMob(x, y, z, getExtendEntityId(), skin));
		e.setMaxHealth(getMaxHealth());

		return e;
	}

	//待重写函数
	public int getExtendEntityId() {
		return EntityType.PIG_ZOMBIE;
	}
	public String getSkin() {
		return "mob/char.png";
	}
	public int getMaxHealth() {
		return 10;
	}

    //固定函数
	public static final void addEffect(long e, Object id, Object time, Object level, boolean shadow, boolean pra) {call(C, "addEffect", e, toInt(id), toInt(time), toInt(level), shadow, pra);}
	public static final long[] getAll() {return (long[]) call(C, "getAll");}
	public static final int getAnimalAge(long e) {return call(C, "getAnimalAge", e);}
	public static final int getArmor(long e, Object g) {return call(C, "getArmor", e, toInt(g));}
	public static final String getArmorCustomName(long e, Object g) {return (String) call(C, "getArmorCustomName", e, toInt(g));}
	public static final int getArmorDamage(long e, Object g) {return call(C, "getArmorDamage", e, toInt(g));}
	public static final int getEntityTypeId(long e) {return call(C, "getEntityTypeId", e);}
	public static final long getExtraData(long e, String name) {return call(C, "getExtraData", e, name);}
	public static final int getHealth(long e) {return call(C, "getHealth", e);}
	public static final int getItemEntityCount(long e) {return call(C, "getItemEntityCount", e);}
	public static final int getItemEntityData(long e) {return call(C, "getItemEntityData", e);}
	public static final int getItemEntityId(long e) {return call(C, "getItemEntityId", e);}
	public static final int getMaxHealth(long e) {return call(C, "getMaxHealth", e);}
	public static final String getMobSkin(long e) {return (String) call(C, "getMobSkin", e);}
	public static final String getNameTag(long e) {return (String) call(C, "getNameTag", e);}
	public static final double getPitch(long e) {return call(C, "getPitch", e);}
	public static final int getRenderType(long e) {return call(C, "getRenderType", e);}
	public static final long getRider(long e) {return call(C, "getRider", e);}
	public static final long getRiding(long e) {return call(C, "getRiding", e);}
	public static final long getTarget(long e) {return call(C, "getTarget", e);}
	public static final void getUniqueId(long e) {call(C, "getUniqueId", e);}
	public static final double getVelX(long e) {return call(C, "getVelX", e);}
	public static final double getVelY(long e) {return call(C, "getVelY", e);}
	public static final double getVelZ(long e) {return call(C, "getVelZ", e);}
	public static final double getX(long e) {return call(C, "getX", e);}
	public static final double getY(long e) {return call(C, "getY", e);}
	public static final double getYaw(long e) {return call(C, "getYaw", e);}
	public static final double getZ(long e) {return call(C, "getZ", e);}
	public static final boolean isSneaking(long e) {return call(C, "isSneaking", e);}
	public static final void remove(long e) {call(C, "remove", e);}
	public static final void removeAllEffects(long e) {call(C, "removeAllEffects", e);}
	public static final void removeEffect(long e, Object var1) {call(C, "removeEffect", e, toInt(var1));}
	public static final void rideAnimal(long e, Object tar) {call(C, "rideAnimal", e, tar);}
	public static final void setAnimalAge(long e, Object age) {call(C, "setAnimalAge", e, toInt(age));}
	public static final void setArmor(long e, Object num, Object id, Object damage) {call(C, "setArmor", e, toInt(num), toInt(id), toInt(damage));}
	public static final void setArmorCustomName(long e, Object num, String name) {call(C, "setArmorCustomName", e, toInt(num), name);}
	public static final void setCape(long e, String path) {call(C, "setCape", e, path);}
	public static final void setCarriedItem(long e, Object id, Object count, Object damage) {call(C, "setCarriedItem", e, toInt(id), toInt(count), toInt(damage));}
	public static final void setCollisionSize(long e, Object length, Object height) {call(C, "setCollisionSize", e, toDouble(length), toDouble(height));}
	public static final void setExtraData(long e, String name, String data) {call(C, "setExtraData", e, name, data);}
	public static final void setFireTicks(long e, Object time) {call(C, "setFireTicks", e, toInt(time));}
	public static final void setHealth(long e, Object health) {call(C, "setHealth", e, toInt(health));}
	public static final void setImmobile(long e, boolean limit) {call(C, "setImmobile", e, limit);}
	public static final void setMaxHealth(long e, Object max) {call(C, "setMaxHealth", e, toInt(max));}
	public static final void setMobSkin(long e, String skin) {call(C, "setMobSkin", e, skin);}
	public static final void setNameTag(long e, String name) {call(C, "setNameTag", e, name);}
	public static final void setPosition(long e, Object x, Object y, Object z) {call(C, "setPosition", e, toDouble(x), toDouble(y), toDouble(z));}
	public static final void setPositionRelative(long e, Object x, Object y, Object z) {call(C, "setPositionRelative", e, toDouble(x), toDouble(y), toDouble(z));}
	public static final void setRenderType(long e, Object id) {call(C, "setRenderType", e, id);}
	public static final void setRot(long e, Object xs, Object zs) {call(C, "setRot", e, toDouble(xs), toDouble(zs));}
	public static final void setSneaking(long e, boolean sneak) {call(C, "setSneaking", e, sneak);}
	public static final void setTarget(long e, Object target) {call(C, "setTarget", e, target);}
	public static final void setVelX(long e, Object speed) {call(C, "setVelX", e, toDouble(speed));}
	public static final void setVelY(long e, Object speed) {call(C, "setVelY", e, toDouble(speed));}
	public static final void setVelZ(long e, Object speed) {call(C, "setVelZ", e, toDouble(speed));}
	@Deprecated public static final void spawnMob(Object x, Object y, Object z, Object id, String skin) {call(C, "spawnMob", toDouble(x), toDouble(y), toDouble(z), toInt(id), skin);}
}
