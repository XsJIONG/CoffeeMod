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
	public static final void setShape(int p1, double p2, double p3, double p4, double p5, double p6, double p7) {}
	public static final void defineBlock(int p1, String p2, Object p3, Object p4, Object p5, Object p6) {}
	public static final void defineBlockSpec(int p1, String p2, Object p3, Object p4, Object p5, Object p6) {}
	public static final int defineLiquidBlock(int p1, String p2, Object p3, Object p4) {return 0;}
	public static final int[] getAllBlockIds() {return null;}
	public static final double getDestroyTime(int p1, int p2) {return 0;}
	public static final double getFriction(int p1, int p2) {return 0;}
	public static final int getRenderType(int p1) {return 0;}
	public static final int[] getTextureCoords(int p1, int p2, int p3) {return null;}
	public static final void setColor(int p1, Object p2) {}
	public static final void setDestroyTime(int p1, double p2) {}
	public static final void setExplosionResistance(int p1, double p2) {}
	public static final void setFriction(int p1, double p2) {}
	public static final void setLightLevel(int p1, int p2) {}
	public static final void setLightOpacity(int p1, int p2) {}
	public static final void setRedstoneConsumer(int p1, boolean p2) {}
	public static final void setRenderLayer(int p1, int p2) {}
	public static final void setRenderType(int p1, int p2) {}
	public static final void setShape(int p1, double p2, double p3, double p4, double p5, double p6, double p7, int p8) {}
}
