package com.jxs.cofmod.control;

public class GameObj extends Modable {
	public Object obj;

	public GameObj() {}
	public GameObj(Object obj) {this.obj = obj;}

	public Object invoke(String name, Object...args) {
		return callObj(obj, name, args); 
	}
}
