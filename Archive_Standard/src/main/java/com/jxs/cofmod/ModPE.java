package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import java.io.*;

import static com.jxs.cofmod.S.*;

public class ModPE extends Modable {
	public static final int C=4;

	@Override
	public void onCreate() {
		super.onCreate();
	}

	//固定函数
	public static final void dumpVtable(String p1, int p2) {call(C, "dumpVtable", p1, p2);}
	public static final byte[] getBytesFromTexturePack(String p1) {return (byte[]) call(C, "getBytesFromTexturePack", p1);}
	public static final String getI18n(String p1) {return (String) call(C, "getI18n", p1);}
	public static final String getLanguage() {return (String) call(C, "getLanguage");}
	public static final String getMinecraftVersion() {return (String) call(C, "getMinecraftVersion");}
	public static final void langEdit(String p1, String p2) {call(C, "langEdit", p1, p2);}
	public static final void leaveGame() {call(C, "leaveGame");}
	public static final void log(String p1) {call(C, "log", p1);}
	public static final InputStream openInputStreamFromTexturePack(String p1) {return (InputStream) call(C, "openInputStreamFromTexturePack", p1);}
	public static final void overrideTexture(String p1, String p2) {call(C, "overrideTexture", p1, p2);}
	public static final String readData(String p1) {return (String) call(C, "readData", p1);}
	public static final void removeData(String p1) {call(C, "removeData", p1);}
	public static final void resetFov() {call(C, "resetFov");}
	public static final void resetImages() {call(C, "resetImages");}
	public static final void saveData(String p1, String p2) {call(C, "saveData", p1, p2);}
	public static final void selectLevel(String p1) {call(C, "selectLevel", p1);}
	public static final void setCamera(Object p1) {call(C, "setCamera", p1);}
	public static final void setFoodItem(int p1, String p2, int p3, int p4, String p5, int p6) {call(C, "setFoodItem", p1, p2, p3, p4, p5, p6);}
	public static final void setFov(double p1) {call(C, "setFov", p1);}
	public static final void setGameSpeed(double p1) {call(C, "setGameSpeed", p1);}
	public static final void setGuiBlocks(String p1) {call(C, "setGuiBlocks", p1);}
	public static final void setItem(int p1, String p2, int p3, String p4, int p5) {call(C, "setItem", p1, p2, p3, p4, p5);}
	public static final void setItemSpec(int p1, String p2, int p3, String p4, int p5) {call(C, "setItemSpec", p1, p2, p3, p4, p5);}
	public static final void setItems(String p1) {call(C, "setItems", p1);}
	public static final void setTerrain(String p1) {call(C, "setTerrain", p1);}
	public static final void setUiRenderDebug(boolean p1) {call(C, "setUiRenderDebug", p1);}
	public static final void showTipMessage(String p1) {call(C, "showTipMessage", p1);}
	public static final void takeScreenshot(String p1) {call(C, "takeScreenshot", p1);}
}
