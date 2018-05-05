package com.jxs.cofmod.custome;

import com.jxs.cofmod.Entity;
import com.jxs.cofmod.control.Modable;

public class AEntity extends Modable {
	public long obj;

	@Override
	public void onCreate() {}

	//构造方法
	//根据Entity.spawn构造
	public AEntity(long en) {
		this.obj = en;
	}

	//自定义函数
	public long getEntity() {return obj;}
	public void setMaxHealth(int max) {Entity.setMaxHealth(obj, max);}
	public void setHealth(int h) {Entity.setHealth(obj, h);}
	public void setAge(int age) {Entity.setAnimalAge(obj, age);}
	public void setArmor(int where, int id, int damage) {Entity.setArmor(obj, where, id, damage);}
	public void setArmorName(int where, String name) {Entity.setArmorCustomName(obj, where, name);}
	public void setCarriedItem(int id, int count, int damage) {Entity.setCarriedItem(obj, id, count, damage);}
	public void setCape(String path) {Entity.setCape(obj, path);}
	public void setCollisionSize(double lobjgth, double height) {Entity.setCollisionSize(obj, lobjgth, height);}
	public void setExtraData(String name, String data) {Entity.setExtraData(obj, name, data);}
	public void setFireTicks(int time) {Entity.setFireTicks(obj, time);}
	public void setImmobile(boolean limit) {Entity.setImmobile(obj, limit);}
	public void setModSkin(String skin) {Entity.setMobSkin(obj, skin);}
	public void setNameTag(String name) {Entity.setNameTag(obj, name);}
	public void setPosition(double x, double y, double z) {Entity.setPosition(obj, x, y, z);}
	public void setPositionRelative(double x, double y, double z) {Entity.setPositionRelative(obj, x, y, z);}
	public void setRobjderType(int id) {Entity.setRenderType(obj, id);}
	public void setRot(double xs, double zs) {Entity.setRot(obj, xs, zs);}
	public void setSneaking(boolean is) {Entity.setSneaking(obj, is);}
	public void setTarget(Object target) {if (target instanceof AEntity) Entity.setTarget(obj, ((AEntity) target).getEntity()); else Entity.setTarget(obj, target);}
	public void setVelX(double speed) {Entity.setVelX(obj, speed);}
	public void setVelY(double speed) {Entity.setVelY(obj, speed);}
	public void setVelZ(double speed) {Entity.setVelZ(obj, speed);}
	public int getMaxHealth() {return Entity.getMaxHealth(obj);}
	public int getHealth() {return Entity.getHealth(obj);}
	public int getAge() {return Entity.getAnimalAge(obj);}
	public int getArmor(int where) {return Entity.getArmor(obj, where);}
	public int getArmorDamage(int where) {return Entity.getArmorDamage(obj, where);}
	public String getArmorName(int where) {return Entity.getArmorCustomName(obj, where);}
	public Object getExtraData(String name) {return Entity.getExtraData(obj, name);}
	public String getModSkin() {return Entity.getMobSkin(obj);}
	public String getNameTag() {return Entity.getNameTag(obj);}
	public double getX() {return Entity.getX(obj);}
	public double getY() {return Entity.getY(obj);}
	public double getZ() {return Entity.getZ(obj);}
	public int getRobjderType() {return Entity.getRenderType(obj);}
	public double getPitch() {return Entity.getPitch(obj);}
	public double getYaw() {return Entity.getYaw(obj);}
	public boolean isSneaking() {return Entity.isSneaking(obj);}
	public long getTarget() {return Entity.getTarget(obj);}
	public double getVelX() {return Entity.getVelX(obj);}
	public double getVelY() {return Entity.getVelY(obj);}
	public double getVelZ() {return Entity.getVelZ(obj);}
	@Override
	public boolean equals(Object obj) {
		try {
			if (toLong(obj) == toLong(this.obj)) return true;
		} catch (Exception e) {}
		if (obj instanceof AEntity) {
			AEntity q=(AEntity) obj;
			return toLong(q.obj) == toLong(this.obj);
		} else return false;
	}
	@Override
	public int hashCode() {
		return ((Number) obj).intValue();
	}
}
