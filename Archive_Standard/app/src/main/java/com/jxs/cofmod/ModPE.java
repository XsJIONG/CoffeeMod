package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import java.io.*;

public class ModPE extends Modable {
	public static final int C=4;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	//固定函数
	public static final void dumpVtable(String p1, int p2) {}
	public static final byte[] getBytesFromTexturePack(String p1) {return null;}
	public static final String getI18n(String p1) {return null;}
	public static final String getLanguage() {return null;}
	public static final String getMinecraftVersion() {return null;}
	public static final void langEdit(String p1, String p2) {}
	public static final void leaveGame() {}
	public static final void log(String p1) {}
	public static final InputStream openInputStreamFromTexturePack(String p1) {return null;}
	public static final void overrideTexture(String p1, String p2) {}
	public static final String readData(String p1) {return null;}
	public static final void removeData(String p1) {}
	public static final void resetFov() {}
	public static final void resetImages() {}
	public static final void saveData(String p1, String p2) {}
	public static final void selectLevel(String p1) {}
	public static final void setCamera(Object p1) {}
	public static final void setFoodItem(int p1, String p2, int p3, int p4, String p5, int p6) {}
	public static final void setFov(double p1) {}
	public static final void setGameSpeed(double p1) {}
	public static final void setGuiBlocks(String p1) {}
	public static final void setItem(int p1, String p2, int p3, String p4, int p5) {}
	public static final void setItemSpec(int p1, String p2, int p3, String p4, int p5) {}
	public static final void setItems(String p1) {}
	public static final void setTerrain(String p1) {}
	public static final void setUiRenderDebug(boolean p1) {}
	public static final void showTipMessage(String p1) {}
	public static final void takeScreenshot(String p1) {}
	
}
