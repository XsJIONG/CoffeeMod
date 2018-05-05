package com.jxs.cofmod;

import com.jxs.cofmod.control.*;
import java.lang.reflect.*;

public class S extends Modable {
	public static final int CC=8;
	public static String[] CS={"Block","Entity","Item","Level","ModPE","Player","Renderer","Server"};
	private static Object Scope;
	private static Object cx;

	public static final Object callObj(Object obj, String mname, Object...args) {
		try {
			if (obj == null) return null;
			Class<?> cl=obj.getClass();
			Class[] ac=new Class[args.length];
			int i=0;
			for (Object arg : args)
				ac[i++] = arg instanceof Number ?((Class) arg.getClass().getDeclaredField("TYPE").get(null)): arg.getClass();
			Method m=cl.getMethod(mname, ac);
			Object o=m.invoke(obj, args);
			try {
				Method un=o.getClass().getMethod("unwrap");
				return un.invoke(o);
			} catch (Exception e) {
				return o;
			}
		} catch (Exception e) {
			err("调用函数时发生错误", e);
		}
		return null;
	}
	public static final Object call(int index, String name, Object...args) {
		try {
			Class<?> sc=Class.forName("org.mozilla.javascript.Scriptable");
			String f=CS[index] + '.' + name;
			if (Scope == null) Scope = eval("Scope");
			Object func=eval(f);
			if (cx == null) cx = eval("org.mozilla.javascript.Context.getCurrentContext()");
			Method m=func.getClass().getMethod("call", new Class[] {cx.getClass(), sc, sc, Array.newInstance(Object.class, 0).getClass()});
			Object o=m.invoke(func, cx, Scope, Scope, args);
			try {
				Method me=o.getClass().getMethod("unwrap");
				return me.invoke(o);
			} catch (Exception e) {
				return o;
			}
		} catch (Exception e) {
			if (e instanceof InvocationTargetException)
				err("调用静态函数时发生错误", ((InvocationTargetException) e).getTargetException());
			else
				err("调用静态函数时发生错误", e);
			return null;
		}
	}
}
