package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import com.mcbox.pesdkb.mcpelauncher.api.modpe.*;
import java.util.*;

public class Renderer extends Modable {
	public static Map<Integer, NativeRenderer> renderersById = new HashMap<>();
	public static Map<String, NativeRenderer> renderersByName = new HashMap<>();

	public static NativeRenderer get(String name) {
		try {
			return new NativeRenderer(Integer.parseInt(name));
		} catch (NumberFormatException e) {
			return renderersByName.get(name);
		}
	}

	public static NativeRenderer getById(int id) {
		return renderersById.get(Integer.valueOf(id));
	}

	public static NativeRenderer getByName(String name) {
		return renderersByName.get(name);
	}

	public static NativeRenderer createHumanoidRenderer() {
		return new NativeRenderer(RendererManager.nativeCreateHumanoidRenderer());
	}

	public static void register(String name, NativeRenderer renderer) {
		renderersByName.put(name, renderer);
		renderersById.put(Integer.valueOf(renderer.getRenderType()), renderer);
	}
	public static class NativeModel {
		private final int rendererId;
		private NativeModel(int rendererId) {
			this.rendererId = rendererId;
		}
		public NativeModelPart getPart(String name) {
			if (RendererManager.nativeModelPartExists(this.rendererId, name))
				return new NativeModelPart(this.rendererId, name);
			throw new RuntimeException(S.join("模型部位", name, "不存在"));
		}
	}
	public static class NativeModelPart {
		private String modelPartName;
		private int rendererId;
		private float textureHeight;
		private float textureWidth;
		private int textureX;
		private int textureY;
		private boolean transparent;

		private NativeModelPart(int rendererId, String modelPartName) {
			this.textureWidth = 64.0f;
			this.textureHeight = 32.0f;
			this.rendererId = rendererId;
			this.modelPartName = modelPartName;
		}

		public NativeModelPart setTextureOffset(int textureX, int textureY) {
			return setTextureOffset(textureX, textureY, false);
		}

		public NativeModelPart setTextureOffset(int textureX, int textureY, boolean transparent) {
			this.textureX = textureX;
			this.textureY = textureY;
			this.transparent = transparent;
			return this;
		}

		public void addBox(float xOffset, float yOffset, float zOffset, int width, int height, int depth) {
			addBox(xOffset, yOffset, zOffset, width, height, depth, 0.0f);
		}

		public void addBox(float xOffset, float yOffset, float zOffset, int width, int height, int depth, float scale) {
			RendererManager.nativeModelAddBox(this.rendererId, this.modelPartName, xOffset, yOffset, zOffset, width, height, depth, scale, textureX, textureY, this.transparent, textureWidth, textureHeight);
		}

		public NativeModelPart clear() {
			RendererManager.nativeModelClear(this.rendererId, this.modelPartName);
			return this;
		}

		public NativeModelPart setTextureSize(float width, float height) {
			this.textureWidth = width;
			this.textureHeight = height;
			return this;
		}

		public NativeModelPart setRotationPoint(float x, float y, float z) {
			RendererManager.nativeModelSetRotationPoint(this.rendererId, this.modelPartName, x, y, z);
			return this;
		}
	}

	public static class NativeRenderer {
		private String name = null;
		private final int rendererId;

		public NativeRenderer(int var1) {
			this.rendererId = var1;
		}

		public NativeModel getModel() {
			return new NativeModel(this.rendererId);
		}

		public String getName() {
			return this.name;
		}

		public int getRenderType() {
			return this.rendererId;
		}

		public void setName(String var1) {
			if (var1.indexOf(".") == -1)
				throw new RuntimeException("模型的名字必须是\"作者.Mod名称.模型名\"的格式");
			else {
				this.name = var1;
				Renderer.register(var1, this);
			}
		}
	}
}
