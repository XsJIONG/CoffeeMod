package com.mcbox.pesdkb.mcpelauncher.api.modpe;

public class RendererManager {
	public static native int nativeCreateHumanoidRenderer();

	public static native int nativeCreateItemSpriteRenderer(int i);

	public static native void nativeModelAddBox(int i, String str, float f, float f2, float f3, int i2, int i3, int i4, float f4, int i5, int i6, boolean z, float f5, float f6);

	public static native void nativeModelClear(int i, String str);

	public static native boolean nativeModelPartExists(int i, String str);

	public static native void nativeModelSetRotationPoint(int i, String str, float f, float f2, float f3);
}
