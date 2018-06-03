package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Renderer {
	public static final int C=6;
	
	public static final NativeRenderer createHumanoidRenderer() {return null;}
	public static final NativeRenderer get(String i) {return null;}
	public static final NativeRenderer getById(int i) {return null;}
	public static final NativeRenderer getByName(String n) {return null;}
	public static final void register(String name, Renderer renderer) {}
	public static class NativeRenderer {
		public void setBody(NativeModelPart body) {}
		public NativeModelPart getBody() {return null;}
		public void setHead(NativeModelPart head) {}
		public NativeModelPart getHead() {return null;}
		public void setLeftArm(NativeModelPart leftArm) {}
		public NativeModelPart getLeftArm() {return null;}
		public void setLeftLeg(NativeModelPart leftLeg) {}
		public NativeModelPart getLeftLeg() {return null;}
		public void setRightArm(NativeModelPart rightArm) {}
		public NativeModelPart getRightArm() {return null;}
		public void setRightLeg(NativeModelPart rightLeg) {}
		public NativeModelPart getRightLeg() {return null;}
		public NativeModel getModel() {return null;}
	}
	public static class NativeModel {
		public NativeModelPart getPart(String str) {return null;}
	}
	public static class NativeModelPart {
		public void clear() {}
		public void setTextureOffset(int x, int y) {}
		public void setTextureOffset(int x, int y, boolean transparent) {}
		public void setRotationPoint(float px, float py, float pz) {}
		public void setTextureSize(float width, float height) {}
		public void addBox(float x, float y, float z, int width, int height, int length) {}
		public void addBox(float x, float y, float z, int width, int height, int length, float bs) {}
	}
}

