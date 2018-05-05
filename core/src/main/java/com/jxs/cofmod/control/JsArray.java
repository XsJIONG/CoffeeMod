package com.jxs.cofmod.control;

import java.util.ArrayList;

public class JsArray {
	private ArrayList<Object> objs=new ArrayList<Object>();
	
	public JsArray() {}
	
	public JsArray(Object...args) {
		for (Object one : args) {
			objs.add(one);
		}
	}
	
	public void add(Object obj) {
		objs.add(obj);
	}
	
	public void remove(int index) {
		objs.remove(index);
	}

	@Override
	public String toString() {
		StringBuffer b=new StringBuffer("[");
		for (int i=0;i<objs.size();i++) {
			b.append(Modable.String(objs.get(i))).append(",");
		}
		b.deleteCharAt(b.length()-1);
		b.append("]");
		return b.toString();
	}
}
