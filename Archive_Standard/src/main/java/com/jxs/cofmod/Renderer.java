package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

import static com.jxs.cofmod.S.*;

public class Renderer extends GameObj {
	public static final int C=6;

	private Renderer(Object obj) {
		super(obj);
	}

	public void setBody(Part body) {
		invoke("setBody", body.obj);
	}

	public Part getBody() {
		return new Part(invoke("getBody"));
	}

	public void setHead(Part head) {
		invoke("setHead", head.obj);
	}

	public Part getHead() {
		return new Part(invoke("getHead"));
	}

	public void setLeftArm(Part leftArm) {
		invoke("setLeftArm", leftArm.obj);
	}

	public Part getLeftArm() {
		return new Part(invoke("getLeftArm"));
	}

	public void setLeftLeg(Part leftLeg) {
		invoke("setLeftLeg", leftLeg.obj);
	}

	public Part getLeftLeg() {
		return new Part(invoke("getLeftLeg"));
	}

	public void setRightArm(Part rightArm) {
		invoke("setRightArm", rightArm.obj);
	}

	public Part getRightArm() {
		return new Part(invoke("getRightArm"));
	}

	public void setRightLeg(Part rightLeg) {
		invoke("setRightLeg", rightLeg.obj);
	}

	public Part getRightLeg() {
		return new Part(invoke("getRightLeg"));
	}

	public Model getModel() {
		return new Model(invoke("getModel"));
	}

	public static Renderer createHumanoidRenderer() {
		return new Renderer(call(C, "createHumanoidRenderer"));
	}

	public static final Renderer get(String i) {
		return new Renderer(call(C, "get", i));
	}

	public static final Renderer getById(int i) {
		return new Renderer(call(C, "getById", i));
	}

	public static final Renderer getByName(String n) {
		return new Renderer(call(C, "getByName", n));
	}
	public static final void register(String name, Renderer renderer) {
		call(C, "register", name, renderer);
	}

	public static class Model extends GameObj {
		public Part getPart(String str) {
			return new Part(invoke("getPart", str));
		}

		public Model(Object obj) {
			super(obj);
		}
	}

	public static class Part extends GameObj {
		public Part(Object obj) {
			super(obj);
		}

		public void clear() {
			invoke("clear");
		}

		public void setTextureOffset(int x, int y) {
			setTextureOffset(x, y, false);
		}

		public void setTextureOffset(int x, int y, boolean transparent) {
			invoke("setTextureOffset", x, y, transparent);
		}

		public void setRotationPoint(float px, float py, float pz) {
			invoke("setRotationPoint", px, py, pz);
		}

		public void setTextureSize(float s, float f2) {
			invoke("setTextureSize", s, f2);
		}

		public void addBox(float x, float y, float z, int width, int height, int length) {
			addBox(x, y, z, width, height, length, 0);
		}

		public void addBox(float x, float y, float z, int width, int height, int length, float bs) {
			invoke("addBox", x, y, z, width, height, length, bs);
		}
	}
}

