package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Block extends Modable {
	public static final int C=0;

	private static int Max_Id=1;
	private String BlockName=null;
	private int BlockId=-1;

	@Override
	public void onCreate() {
		defineBlock(getBlockId(), getBlockName(), getTexture(), getExtendBlockId(), isAlpha(), getBlockModel());
		setDestroyTime(getBlockId(), getDestroyTime());
		setFriction(getBlockId(), getFriction());
		setExplosionResistance(getBlockId(), getExplosionResistance());
		setLightLevel(getBlockId(), getLightLevel());
		if (getLightOpacity() != -1) setLightOpacity(getBlockId(), getLightOpacity());
		setRedstoneConsumer(getBlockId(), isRedstoneChargable());
		setRenderLayer(getBlockId(), getRenderLayer());
		double[] d=getShape();
		setShape(getBlockId(), d[0], d[1], d[2], d[3], d[4], d[5]);
	}

	//待重写函数
	public boolean inCreativeBag() {
		return true;
	}

	public double[] getShape() {
		return new double[] {0,0,0,1,1,1};
	}

	public int getRenderLayer() {
		return 0;
	}

	public boolean isRedstoneChargable() {
		return false;
	}

	public int getLightOpacity() {
		return -1;
	}

	public int getLightLevel() {
		return 1;
	}

	public double getExplosionResistance() {
		return 5;
	}

	public double getFriction() {
		return 1;
	}

	public double getDestroyTime() {
		return 1.0;
	}

	public Object getTexture() {
		return "stone";
	}

	public boolean isAlpha() {
		return false;
	}

	public int getExtendBlockId() {
		return 1;
	}

	public String getBlockName() {
		if (BlockName == null)
			BlockName = this.getClass().getSimpleName();
		return BlockName;
	}

	public int getBlockId() {
		if (BlockId == -1) {
			int i=Max_Id;
			while (Item.isValidItem(i)) i++;
			BlockId = i;
			Max_Id = i;
		}
		return BlockId;
	}

	public int getBlockModel() {
		return 0;
	}


	//自定义钩子
	public void onClick(int x, int y, int z, int id, int idt, int side, int bidt) {}
	public void onCharge(int x, int y, int z, int indensity, int bidt) {}
	public void onDestory(int x, int y, int z, int side) {}
	public void onContinueDestroy(int x, int y, int z, int side, double progress) {}
	public void onStartDestroy(int x, int y, int z, int side) {}
	public void onPlace(int x, int y, int z, int special, int bid, int bidt, int side) {}

	//固定函数
	public static final void defineBlock(Object id, String name, Object texture, Object extend, boolean alpha, Object model) {call(C, "defineBlock", id , name, texture, toInt(extend), alpha, toInt(model));}
	public static final void defineLiquidBlock(Object id, String name, Object czname, Object jc) {call(C, "defineLiquidBlock", toInt(id), name, czname, jc);}
	public static final Integer[] getAllBlockIds() {return (Integer[]) call(C, "getAllBlockIds");}
	public static final double getDestroyTime(Object id) {return call(C, "getDestroyTime", toInt(id));}
	public static final double getFriction(Object id) {return call(C, "getFriction", toInt(id));}
	public static final int getRenderType(Object id) {return call(C, "getRenderType", toInt(id));}
	public static final void getTextureCoords(Object var0, Object var1, Object var2) {call(C, "getTextureCoords", toInt(var0), toInt(var1), toInt(var2));}
	public static final void setColor(Object id, Object color) {call(C, "setColor", toInt(id), toInt(color));}
	public static final void setDestroyTime(Object id, Object time) {call(C, "setDestroyTime", toInt(id), toDouble(time));}
	public static final void setExplosionResistance(Object id, Object n) {call(C, "setExplosionResistance", toInt(id), toDouble(n));}
	public static final void setFriction(Object id, Object d) {call(C, "setFriction", toInt(id), toDouble(d));}
	public static final void setLightLevel(Object id, Object light) {call(C, "setLightLevel", toInt(id), toInt(light));}
	public static final void setLightOpacity(Object id, Object du) {call(C, "setLightOpacity", toInt(id), toInt(du));}
	public static final void setRedstoneConsumer(Object id, boolean accept) {call(C, "setRedstoneConsumer", toInt(id), accept);}
	public static final void setRenderLayer(Object id, Object mode) {call(C, "setRenderLayer", toInt(id), toInt(mode));}
	public static final void setRenderType(Object id, Object type) {call(C, "setRenderType", toInt(id), toInt(type));}
	public static final void setShape(Object id, Object xs, Object ys, Object zs, Object xj, Object yj, Object zj) {call(C, "setShape", toInt(id), toDouble(xs), toDouble(ys), zs , xj , yj , toDouble(zj));}
	public static final void setShape(Object id, Object xs, Object ys, Object zs, Object xj, Object yj, Object zj, Object damage) {call(C, "setShape", toInt(id), toDouble(xs), toDouble(ys), zs , xj , yj , toDouble(zj), toInt(damage));}
}
