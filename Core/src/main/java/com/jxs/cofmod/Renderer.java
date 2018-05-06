package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Renderer {
	public static final int C=6;
	
	public void setBody(Part body) {}
	public Part getBody() {return null;}
	public void setHead(Part head) {}
	public Part getHead() {return null;}
	public void setLeftArm(Part leftArm) {}
	public Part getLeftArm() {return null;}
	public void setLeftLeg(Part leftLeg) {}
	public Part getLeftLeg() {return null;}
	public void setRightArm(Part rightArm) {}
	public Part getRightArm() {return null;}
	public void setRightLeg(Part rightLeg) {}
	public Part getRightLeg() {return null;}
	public Model getModel() {return null;}
	public static final Renderer createHumanoidRenderer() {return null;}
	public static final Renderer get(String i) {return null;}
	public static final Renderer getById(int i) {return null;}
	public static final Renderer getByName(String n) {return null;}
	public static final void register(String name, Renderer renderer) {}
	public static class Model {
		public Part getPart(String str) {return null;}
	}
	public static class Part {
		public void clear() {}
		public void setTextureOffset(int x, int y) {}
		public void setTextureOffset(int x, int y, boolean transparent) {}
		public void setRotationPoint(float px, float py, float pz) {}
		public void setTextureSize(float width, float height) {}
		public void addBox(float x, float y, float z, int width, int height, int length) {}
		public void addBox(float x, float y, float z, int width, int height, int length, float bs) {}
	}
}

