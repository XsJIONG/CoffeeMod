package com.jxs.cofmod.control;

import android.content.*;
import com.jxs.cofmod.*;
import com.jxs.cofmod.annotation.*;
import com.jxs.cofmod.util.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class Modable implements Const {
	private static final int CC=8;
	private static JsBridge bridge;
	public static Context ctx;
	public static UI ui;
	public static Manifest mod;
	public static int LauncherType;
	public static final int Launcher_ModMax=0,Launcher_DuoWan=1,Launcher_BlockLauncher=2,Launcher_Unknown=-1;
	public static Object SCOPE;
	private static Class[] CS=new Class[CC];
	private static Method[][] TMPS=new Method[CC][];

	public void onCreate() {}
	public static String getLauncherDescription() {
		switch (LauncherType) {
			case Launcher_ModMax:return "ModMax";
			case Launcher_DuoWan:return "多玩";
			case Launcher_BlockLauncher:return "BlockLauncher";
			case Launcher_Unknown:return "未知";
		}
		return null;
	}

	@Custome
	public static final CoffeeMod load(JsBridge b, InputStream xml, InputStream jar) throws Exception {
		bridge = b;
		ctx = (Context) eval("com.mojang.minecraftpe.MainActivity.currentMainActivity.get()");
		SCOPE = eval("Scope");
		ui = new UI(ctx);
		mod = Manifest.parse(xml, jar);
		if (!mod.mod.getAuthor().trim().equalsIgnoreCase(mod.author)) {
			ui.alert("警告", String.format("由于此Mod中Manifest声明的作者(Author)与类中所提供的作者不同，CoffeeMod怀疑此Mod已经被恶意修改，CoffeeMod拒绝加载此Mod，请支持正版！\nManifest中提供的作者：%s\n类中提供的作者：%s", mod.author, mod.mod.getAuthor()));
			return null;
		}
		if (!mod.mod.getModName().trim().equalsIgnoreCase(mod.name)) {
			ui.alert("警告", String.format("由于此Mod中Manifest声明的名字(Name)与类中所提供的名字不同，CoffeeMod怀疑此Mod已经被恶意修改，CoffeeMod拒绝加载此Mod，请支持正版！\nManifest中提供的名字：%s\n类中提供的名字：%s", mod.name, mod.mod.getModName()));
			return null;
		}
		String s=ctx.getPackageName();
		LauncherType = Launcher_Unknown;
		switch (s) {
			case "com.jxs.modmax":LauncherType = Launcher_ModMax;break;
			case "com.duowan.groundhog.mctools":LauncherType = Launcher_DuoWan;break;
			case "net.zhuoweizhang.mcpelauncher":LauncherType = Launcher_BlockLauncher;break;
		}
		Logs.println("启动器：" + getLauncherDescription());
		if (LauncherType != Launcher_Unknown)
			for (int i=0;i < CC;i++) CS[i] = Class.forName(LauncherAdapter[LauncherType][i]);
		if (LauncherType == Launcher_DuoWan) injectDuowanScriptTemplate();
		try {
			mod.mod.onCreate();
		} catch (Throwable e) {
			Logs.err("加载Mod - onCreate方法时发生错误:", e);
			print(String(e));
		}
		return mod.mod;
	}
	private static void injectDuowanScriptTemplate() {
		try {
			Class<?> Cofmod=CoffeeMod.class;
			HashSet<String> Fs=CoffeeMod.HOOK_FUNCTIONS;
			Class<?> FunctionClass=Class.forName("org.mozilla.javascript.Function");
			final Method[] ms=Cofmod.getMethods();
			Method m;
			for (String one : Fs) {
				m = null;
				for (int i=0;i < ms.length;i++) if (ms[i].getName().equals(one)) {m = ms[i];break;}
				if (m == null) throw new RuntimeException("无法找到方法：" + one);
				final Method q=m;
				HookFunctions.put(one, Proxy.newProxyInstance(ctx.getClassLoader(), new Class<?>[]{FunctionClass}, new InvocationHandler() {
										  @Override
										  public Object invoke(Object obj, Method m, Object[] args) throws Throwable {
											  try {
												  Object[] real=(Object[]) args[3];
												  if (real.length == 0 || q.getName().equals("newLevel")) q.invoke(mod.mod); else q.invoke(mod.mod, (Object[]) args[3]);
											  } catch (Throwable t) {
												  Logs.println("调用钩子函数" + q.getName() + "时发生错误" + ets(t));
											  }
											  return null;
										  }
									  }));
			}
			Class<?> ScriptManager=Class.forName("com.mcbox.pesdkb.mcpelauncher.ScriptManager");
			Class<?> ScriptState=Class.forName("com.mcbox.pesdkb.mcpelauncher.jsapi.ScriptState");
			Class<?> Scriptable = Class.forName("org.mozilla.javascript.Scriptable");
			List scripts=(List) ScriptManager.getField("scripts").get(null);
			Object MSS=ScriptState.getConstructors()[0].newInstance(null, Proxy.newProxyInstance(ctx.getClassLoader(), new Class<?>[]{Scriptable}, new InvocationHandler() {
																			@Override
																			public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
																				if (CoffeeMod.HOOK_FUNCTIONS.contains(args[0])) return HookFunctions.get(args[0]);
																				Logs.println("未定义的钩子函数：" + args[0]);
																				return null;
																			}
																		}), "CoffeeMod_" + mod.name);
			scripts.add(MSS);

			Logs.println("已注入多玩ScriptTemplate");
		} catch (Throwable t) {
			Logs.print("注入多玩ScriptTemplate时出现错误：");
			Logs.println(ets(t));
		}
	}
	private static HashMap<String,Object> HookFunctions=new HashMap<>();

	public static final Object eval(String code) {
		Object o=bridge.eval(code);
		try {
			Class<?> h=o.getClass();
			Method m=h.getMethod("unwrap");
			return m.invoke(o);
		} catch (Exception e) {
			return o;
		}
	}

	@Custome
	public static void err(String describe, Throwable err) {
		print(describe);
		Logs.println(describe + ": " + ets(err));
	}

	public static String String(Object o) {
		Class c=o.getClass();
		if (c.isArray()) {
			StringBuffer b=new StringBuffer();
			for (int i=0;i < Array.getLength(o);i++) b.append(String(Array.get(o, i)));
			return b.toString();
		}
		if (c == int.class || c == Integer.class) {
			return Integer.toString(o);
		} else if (c == byte.class || c == Byte.class) {
			return Byte.toString(o);
		} else if (c == short.class || c == Short.class) {
			return Short.toString(o);
		} else if (c == long.class || c == Long.class) {
			return Long.toString(o);
		} else if (c == double.class || c == Double.class) {
			return Double.toString(o);
		} else if (c == float.class || c == Float.class) {
			return Float.toString(o);
		} else if (c == boolean.class || c == Boolean.class) {
			return Boolean.toString(o);
		} else if (c == char.class || c == Character.class) {
			return Character.toString(o);
		} else {
			return o.toString();
		}
	}
	@Custome
	public static final String ets(java.lang.Throwable e) {
		StringWriter w=new StringWriter();
		PrintWriter wr=new PrintWriter(w);
		e.printStackTrace(wr);
		return w.toString();
	}

	public static final void print(String text) {Host.print(text);}
	public static final double getPlayerX() {return Host.getPlayerX();}
	public static final double getPlayerY() {return Host.getPlayerY();}
	public static final double getPlayerZ() {return Host.getPlayerZ();}
	public static final long getPlayerEnt() {return Host.getPlayerEnt();}
	public static final Object getLevel() {return Host.getLevel();}
	public static final void setPosition(Object ent, double x, double y, double z) {Host.setPosition(ent, x, y, z);}
	public static final void setVelX(Object ent, double s) {Host.setVelX(ent, s);}
	public static final void setVelY(Object ent, double s) {Host.setVelY(ent, s);}
	public static final void setVelZ(Object ent, double s) {Host.setVelZ(ent, s);}
	public static final void explode(double x, double y, double z, double r, boolean fire) {Host.explode(x, y, z, r, fire);}
	public static final void addItemInventory(int id, int amount, int damage) {Host.addItemInventory(id, amount, damage);}
	public static final void rideAnimal(Object rider, Object ani) {Host.rideAnimal(rider, ani);}
	public static final long spawnChicken(double x, double y, double z, String tex) {return Host.spawnChicken(x, y, z, tex);}
	public static final long spawnCow(double x, double y, double z, String tex) {return Host.spawnCow(x, y, z, tex);}
	public static final int getCarriedItem() {return Host.getCarriedItem();}
	public static final void preventDefault() {Host.preventDefault();}
	public static final void setTile(int x, int y, int z, int id, int damage) {Host.setTile(x, y, z, id, damage);}
	public static final void clientMessage(String text) {Host.clientMessage(text);}
	public static final void setNightMode(boolean night) {Host.setNightMode(night);}
	public static final int getTile(int x, int y, int z) {return Host.getTile(x, y, z);}
	public static final void setPositionRelative(Object ent, double x, double y, double z) {Host.setPositionRelative(ent, x, y, z);}
	public static final void setRot(Object ent, double yaw, double pitch) {Host.setRot(ent, yaw, pitch);}
	public static final double getPitch(Object ent) {return Host.getPitch(ent);}
	public static final double getYaw(Object ent) {return Host.getYaw(ent);}
	public static final long spawnPigZombie(double x, double y, double z, int item, String tex) {return Host.spawnPigZombie(x, y, z, item, tex);}
	public static final long bl_spawnMob(double x, double y, double z, int id, String tex) {return Host.bl_spawnMob(x, y, z, id, tex);}
	public static final void bl_setMobSkin(Object ent, String tex) {Host.bl_setMobSkin(ent, tex);}
	public static final void setTile(int x, int y, int z, int id) {setTile(x, y, z, id, 0);}
	public static final void explode(double x, double y, double z, double r) {explode(x, y, z, r, false);}
}
