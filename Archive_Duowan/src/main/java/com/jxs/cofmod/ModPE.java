package com.jxs.cofmod;

import android.content.*;
import android.os.*;
import com.jxs.cofmod.control.*;
import com.mcbox.pesdk.launcher.impl.*;
import com.mcbox.pesdk.mcfloat.model.*;
import com.mcbox.pesdkb.mcpelauncher.*;
import com.mojang.minecraftpe.*;
import java.io.*;

public class ModPE extends Modable {
	public static void setTerrain(String url) {
		overrideTexture("images/terrain-atlas.tga", url);
	}

	public static void setItems(String url) {
		overrideTexture("images/items-opaque.png", url);
	}

	public static void setGuiBlocks(String url) {
		overrideTexture("gui/gui_blocks.png", url);
	}

	public static void overrideTexture(String theOverridden, String url) {
		ScriptManager.overrideTexture(url, theOverridden);
	}

	public static void resetImages() {
		ScriptManager.clearTextureOverrides();
	}

	public static void setItem(int id, String iconName, int iconSubindex, String name, int maxStackSize) {
		try {
			Integer.parseInt(iconName);
			throw new IllegalArgumentException(name.trim() + "的物品图标已经升级到了0.8.0，请联系插件作者更新");
		} catch (NumberFormatException e) {
			if (id < 0 || id >= ScriptManager.ITEM_ID_COUNT)
				throw new IllegalArgumentException("物品ID必须大于等于0并且小于" + ScriptManager.ITEM_ID_COUNT);
			else if (ScriptManager.itemsMeta != null || ScriptManager.itemsMeta.hasIcon(iconName, iconSubindex)) {
				ScriptManager.nativeDefineItem(id, iconName, iconSubindex, name, maxStackSize);
				DtPluginImpl.getInstance().addPluginList(new PluginItem(id, iconName, name, iconSubindex, null, 1));
			} else
				throw new IllegalArgumentException(S.join("物品图标", String.valueOf(iconName), ":", String.valueOf(iconSubindex), "不存在"));
		}
	}

	public static void setItemSpec(int id, String iconName, int iconSubindex, String name, int maxStackSize) {
		try {
			Integer.parseInt(iconName);
			throw new IllegalArgumentException(name.trim() + "的物品图标已经升级到了0.8.0，请联系插件作者更新");
		} catch (NumberFormatException e) {
			if (id < 0 || id >= ScriptManager.ITEM_ID_COUNT)
				throw new IllegalArgumentException("物品ID必须大于等于0并且小于" + ScriptManager.ITEM_ID_COUNT);
				else if (ScriptManager.itemsMeta == null || ScriptManager.itemsMeta.hasIcon(iconName, iconSubindex)) {
				ScriptManager.nativeDefineItem(id, iconName, iconSubindex, name, maxStackSize);
			} else
				throw new IllegalArgumentException(S.join("物品图标", String.valueOf(iconName), ":", String.valueOf(iconSubindex), "不存在"));
		}
	}

	public static void setFoodItem(int id, String iconName, int iconSubindex, int halfhearts, String name, int maxStackSize) {
		setItem(id, iconName, iconSubindex, name, maxStackSize);
		Item.setProperties(id, "{\"use_animation\":\"eat\",\"use_duration\": 32,\"food\":{\"nutrition\":" + halfhearts + ",\"saturation_modifier\": \"normal\",\"is_meat\": false}}");
	}

	private static String getLevelName(File worldDir) throws IOException {
		File nameFile = new File(worldDir, "levelname.txt");
		if (!nameFile.exists()) {
			return null;
		}
		FileInputStream fis = new FileInputStream(nameFile);
		byte[] buf = new byte[((int) nameFile.length())];
		fis.read(buf);
		fis.close();
		return new String(buf, "UTF-8");
	}

	public static void selectLevel(String levelDir) {
		String levelDirName = levelDir;
		File worldsDir = new File(Environment.getExternalStorageDirectory() + "/games/com.mojang/minecraftWorlds");
		File theDir = new File(worldsDir, levelDirName);
		if (!theDir.exists()) {
			for (File worldDir : worldsDir.listFiles()) {
				try {
					String worldName = getLevelName(worldDir);
					if (worldName != null && worldName.equals(levelDir)) {
						levelDirName = worldDir.getName();
						theDir = worldDir;
						break;
					}
				} catch (IOException ie) {
					ie.printStackTrace();
				}
			}
		}
		if (!theDir.exists())
			throw new IllegalArgumentException(levelDir+"存档不存在");
		else if (levelDirName.equals(ScriptManager.worldDir))
			throw new IllegalArgumentException("尝试加载一个已经打开的存档:"+levelDirName);
		else {
			String levelFullName = null;
			try {
				levelFullName = getLevelName(theDir);
			} catch (IOException ie2) {
				ie2.printStackTrace();
			}
			ScriptManager.setRequestLeaveGame();
			ScriptManager.requestSelectLevel = new ScriptManager.SelectLevelRequest();
			ScriptManager.requestSelectLevel.dir = levelDirName;
			if (levelFullName != null)
				levelDirName = levelFullName;
			ScriptManager.requestSelectLevel.name = levelDirName;
		}
	}

	public static String readData(String prefName) {
		return ScriptManager.androidContext.getSharedPreferences("mctoolModPEScript" + ScriptManager.currentScript, 0).getString(prefName, "");
	}

	public static void saveData(String prefName, String prefValue) {
		SharedPreferences.Editor prefsEditor = ScriptManager.androidContext.getSharedPreferences("mctoolModPEScript" + ScriptManager.currentScript, 0).edit();
		prefsEditor.putString(prefName, prefValue);
		prefsEditor.commit();
	}

	public static void removeData(String prefName) {
		SharedPreferences.Editor prefsEditor = ScriptManager.androidContext.getSharedPreferences("mctoolModPEScript" + ScriptManager.currentScript, 0).edit();
		prefsEditor.remove(prefName);
		prefsEditor.commit();
	}

	public static void leaveGame() {
		ScriptManager.setRequestLeaveGame();
	}

	public static void setGameSpeed(double ticksPerSecond) {
		ScriptManager.nativeSetGameSpeed((float) ticksPerSecond);
	}

	public static void takeScreenshot(String fileName) {
		ScriptManager.screenshotFileName = fileName.replace("/", "").replace("\\", "");
		ScriptManager.nativeRequestFrameCallback();
	}

	public static void langEdit(String key, String value) {
		ScriptManager.nativeSetI18NString(key, value);
	}

	public static void showTipMessage(String msg) {
		ScriptManager.nativeShowTipMessage(msg);
	}

	public static void setCamera(Object entityId) {
		ScriptManager.nativeSetCameraEntity(ScriptManager.getEntityId(entityId));
	}

	public static void setFov(double fov) {
		ScriptManager.nativeSetFov((float) fov, true);
	}

	public static void resetFov() {
		ScriptManager.nativeSetFov(0.0f, false);
	}

	public static String getMinecraftVersion() {
		try {
			return ScriptManager.androidContext.getPackageManager().getPackageInfo("com.mojang.minecraftpe", 0).versionName;
		} catch (Exception e) {
			e.printStackTrace();
			return "Unknown";
		}
	}

	public static byte[] getBytesFromTexturePack(String name) {
		if (MainActivity.currentMainActivity != null) {
			MainActivity main = (MainActivity) MainActivity.currentMainActivity.get();
			if (main != null) {
				byte[] bytes = main.getFileDataBytes(name);
				if (bytes != null) {
					return bytes;
				}
				StringBuilder append = new StringBuilder().append("resourcepacks/vanilla/client/");
				if (name.startsWith("images/")) {
					name = "textures/" + name.substring("images/".length());
				}
				return main.getFileDataBytes(append.append(name).toString());
			}
		}
		return null;
	}

	public static InputStream openInputStreamFromTexturePack(String name) {
		if (MainActivity.currentMainActivity != null) {
			MainActivity main = (MainActivity) MainActivity.currentMainActivity.get();
			if (main != null) {
				InputStream is = main.getInputStreamForAsset(name);
				if (is != null) {
					return is;
				}
				StringBuilder append = new StringBuilder().append("resource_packs/vanilla/");
				if (name.startsWith("images/")) {
					name = "textures/" + name.substring("images/".length());
				}
				return main.getInputStreamForAsset(append.append(name).toString());
			}
		}
		return null;
	}

	public static void dumpVtable(String className, int size) {
		ScriptManager.nativeDumpVtable("_ZTV" + className.length() + className, size);
	}

	public static String getI18n(String key) {
		return ScriptManager.nativeGetI18NString(key);
	}

	public static String getLanguage() {
		return ScriptManager.nativeGetLanguageName();
	}

	public static void setUiRenderDebug(boolean render) {
		ScriptManager.nativeModPESetRenderDebug(render);
	}
}
