package com.jxs.cofmod;

public class S {
	public static String join(String...all) {
		StringBuffer b=new StringBuffer();
		for (int i=0;i < all.length;i++) b.append(all[i]);
		return b.toString();
	}
}
