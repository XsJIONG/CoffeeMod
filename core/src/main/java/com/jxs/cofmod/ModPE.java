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
	public static final void dumpVtable(String par1String, Object par2int) {call(C, "dumpVtable", par1String, toInt(par2int));}
	public static final byte[] getBytesFromTexturePack(String name) {return (byte[]) call(C, "getBytesFromTexturePack", name);}
	public static final String getI18n(String par1String) {return (String) call(C, "getI18n", par1String);}
	public static final String getLanguage() {return (String) call(C, "getLanguage");}
	public static final String getMinecraftVersion() {return (String) call(C, "getMinecraftVersion");}
	public static final void langEdit(String name, String data) {call(C, "langEdit", name, data);}
	public static final void leaveGame() {call(C, "leaveGame");}
	public static final void log(String c) {call(C, "log", c);}
	public static final InputStream openInputStreamFromTexturePack(String name) {return (InputStream) call(C, "openInputStreamFromTexturePack", name);}
	public static final void overrideTexture(String name, String data) {call(C, "overrideTexture", name, data);}
	public static final String readData(String name) {return (String) call(C, "readData", name);}
	public static final void removeData(String name) {call(C, "removeData", name);}
	public static final void resetFov() {call(C, "resetFov");}
	public static final void resetImages() {call(C, "resetImages");}
	public static final void saveData(String name, String data) {call(C, "saveData", name, data);}
	public static final void selectLevel(String level) {call(C, "selectLevel", level);}
	public static final void setCamera(Object entity) {call(C, "setCamera", entity);}
	public static final void setFoodItem(Object id, String texture, Object textureofs, Object supply, String name, Object maxstack) {call(C, "setFoodItem", toInt(id), texture, toInt(textureofs), toInt(supply), name, toInt(maxstack));}
	public static final void setFov(Object par1double) {call(C, "setFov", toDouble(par1double));}
	public static final void setGameSpeed(Object speed) {call(C, "setGameSpeed", toDouble(speed));}
	public static final void setGuiBlocks(String gui) {call(C, "setGuiBlocks", gui);}
	public static final void setItem(Object id, String texture, Object pl, String name, Object max) {call(C, "setItem", toInt(id), texture, toInt(pl), name, toInt(max));}
	public static final void setItems(String par1String) {call(C, "setItems", par1String);}
	public static final void setTerrain(String par1String) {call(C, "setTerrain", par1String);}
	public static final void setUiRenderDebug(Object par1boolean) {call(C, "setUiRenderDebug", toDouble(par1boolean));}
	public static final void showTipMessage(String message) {call(C, "showTipMessage", message);}
	public static final void takeScreenshot(String path) {call(C, "takeScreenshot", path);}
}
