package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import com.mcbox.pesdk.launcher.impl.*;
import com.mcbox.pesdk.mcfloat.model.*;
import com.mcbox.pesdkb.mcpelauncher.*;
import java.util.*;
import org.mozilla.javascript.*;

public class Block extends Modable {
	private static final int BATTERY_USAGE_UNRESTRICTED = 256;

	public static void defineBlock(int blockId, String name, Object textures, Object materialSourceIdSrc, Object opaqueSrc, Object renderTypeSrc) {
		defineBlockImpl(blockId, name, textures, materialSourceIdSrc, opaqueSrc, renderTypeSrc, 0, true);
	}

	public static int defineLiquidBlock(int blockId, String name, Object textures, int materialSourceIdSrc) {
		defineBlockImpl(blockId, name, textures, materialSourceIdSrc, true, Integer.valueOf(8), 1, true);
		defineBlockImpl(blockId + 1, "Still " + name, textures, materialSourceIdSrc, true, Integer.valueOf(8), 2, true);
		return blockId + 1;
	}

	public static void defineBlockSpec(int blockId, String name, Object textures, Object materialSourceIdSrc, boolean opaqueSrc, int renderTypeSrc) {
		defineBlockImpl(blockId, name, textures, materialSourceIdSrc, opaqueSrc, renderTypeSrc, 0, false);
	}
	private static ScriptManager.TextureRequests expandTexturesArray(Object textures) {
		int[] ids=new int[96];
		String[] ns=new String[96];
		ScriptManager.TextureRequests r=new ScriptManager.TextureRequests();
		r.names = ns; r.coords = ids;
		if (textures instanceof String) Arrays.fill(ns, (String) textures); else {
			Object[] objs=(Object[]) textures;
			int w=objs.length % 6 == 0 ?6: 1;
			if ((objs.length == 1 || objs.length == 2) && (objs[0] instanceof String)) {
				Arrays.fill(ns, (String) objs[0]);
				if (objs.length == 2) Arrays.fill(ids, ((Number) objs[1]).intValue());
			} else {
				Object[] obj;
				for (int i=0;i < ids.length;i++) {
					if (i < objs.length) obj = (Object[]) objs[i]; else obj = (Object[]) objs[i % w];
					if (obj.length > 1) ids[i] = ((Number) obj[1]).intValue();
					ns[i] = (String) obj[0];
				}
			}
		}
		return r;
	}
	private static void defineBlockImpl(int blockId, String name, Object textures, int materialSourceIdSrc, boolean opaque, int renderTypeSrc, int customBlockType, boolean showInMcFloat) {
		if (blockId < 0 || blockId >= ScriptManager.ITEM_ID_COUNT)
			throw new IllegalArgumentException("方块ID必须大于等于0并且小于" + ScriptManager.ITEM_ID_COUNT);
		int materialSourceId = 17;
		int renderType = 0;
		ScriptManager.TextureRequests finalTextures = ScriptManager.mapTextureNames(expandTexturesArray(textures));
		ScriptManager.verifyBlockTextures(finalTextures);
		try {ScriptManager.blocksJson.setBlockTextures(name, blockId, finalTextures.names, finalTextures.coords);} catch (Throwable t) {}
		ScriptManager.nativeDefineBlock(blockId, name, finalTextures.names, finalTextures.coords, materialSourceId, opaque, renderType, customBlockType);
		if (showInMcFloat) {
			String iconName = null;
			if (finalTextures.names.length > 0)
				iconName = finalTextures.names[0];
			DtPluginImpl.getInstance().addPluginList(new PluginItem(blockId, iconName, name, 0, null, 1));
		}
	}

	public static void setDestroyTime(int blockId, double time) {
		ScriptManager.nativeBlockSetDestroyTime(blockId, (float) time);
	}

	public static int getRenderType(int blockId) {
		return ScriptManager.nativeGetBlockRenderShape(blockId);
	}

	public static void setRenderType(int blockId, int renderType) {
		ScriptManager.nativeSetBlockRenderShape(blockId, renderType);
	}

	public static void setExplosionResistance(int blockId, double resist) {
		ScriptManager.nativeBlockSetExplosionResistance(blockId, (float) resist);
	}

	public static void setShape(int blockId, double v1, double v2, double v3, double v4, double v5, double v6, int damage) {
		ScriptManager.nativeBlockSetShape(blockId, (float) v1, (float) v2, (float) v3, (float) v4, (float) v5, (float) v6, damage);
	}

	public static void setLightLevel(int blockId, int lightLevel) {
		ScriptManager.nativeBlockSetLightLevel(blockId, lightLevel);
	}

	public static void setColor(int blockId, Scriptable colorArray) {
		ScriptManager.nativeBlockSetColor(blockId, ScriptManager.expandColorsArray(colorArray));
	}

	public static void setRenderLayer(int blockId, int layer) {
		if (layer == 4099 || layer == 4)
			layer = 3;
		ScriptManager.nativeBlockSetRenderLayer(blockId, layer);
	}

	public static void setLightOpacity(int blockId, int lightLevel) {
		ScriptManager.nativeBlockSetLightOpacity(blockId, lightLevel);
	}

	public static int[] getAllBlockIds() {
		int i;
		boolean[] validIds = new boolean[BATTERY_USAGE_UNRESTRICTED];
		int theCount = 0;
		for (i = 0; i < BATTERY_USAGE_UNRESTRICTED; i++) {
			if (ScriptManager.nativeIsValidItem(i)) {
				validIds[i] = true;
				theCount++;
			}
		}
		int[] retval = new int[theCount];
		i = 0;
		int b = 0;
		while (i < BATTERY_USAGE_UNRESTRICTED) {
			int b2;
			if (validIds[i]) {
				b2 = b + 1;
				retval[b] = i;
			} else {
				b2 = b;
			}
			i++;
			b = b2;
		}
		return retval;
	}

	public static double getDestroyTime(int id, int damage) {
		return (double) ScriptManager.nativeBlockGetDestroyTime(id, damage);
	}

	public static double getFriction(int id, int damage) {
		return (double) ScriptManager.nativeBlockGetFriction(id);
	}

	public static void setFriction(int id, double friction) {
		ScriptManager.nativeBlockSetFriction(id, (float) friction);
	}

	public static void setRedstoneConsumer(int id, boolean enabled) {
		ScriptManager.nativeBlockSetRedstoneConsumer(id, enabled);
	}

	public static int[] getTextureCoords(int id, int damage, int side) {
		float[] rs = new float[6];
		if (ScriptManager.nativeGetTextureCoordinatesForBlock(id, damage, side, new float[6]))
			return new int[]{(int) (((double) (rs[0] * rs[4])) + 0.5d), (int) (((double) (rs[1] * rs[5])) + 0.5d), (int) (((double) (rs[2] * rs[4])) + 0.5d), (int) (((double) (rs[3] * rs[5])) + 0.5d), (int) (((double) rs[4]) + 0.5d), (int) (((double) rs[5]) + 0.5d)};
		throw new RuntimeException(S.join("无法获取ID为", String.valueOf(id), "，特殊值为", String.valueOf(damage), "方块的材质"));
	}
}
