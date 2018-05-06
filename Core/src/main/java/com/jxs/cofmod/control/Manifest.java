package com.jxs.cofmod.control;

import android.text.*;
import com.jxs.cofmod.util.*;
import dalvik.system.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Manifest extends Modable {
	public interface Const {
		String Manifest="manifest";
		String Icon="icon";
		String Author="author";
		String Describe="desc";
		String Name="name";
		String Package="package";
		String ShowLoading="showLoading";
	}

	public String name;
	public String author;
	public String icon;
	public String desc;
	public String pkg;
	public boolean showLoading;
	public CoffeeMod mod;
	public DexClassLoader clzloader;

	public static Manifest parse(InputStream xml, InputStream jar) {
		Manifest m=new Manifest();
		try {
			Document d=DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xml);
			Element root=d.getDocumentElement();
			if (!root.getTagName().equals(Const.Manifest)) ee("无法找到" + Const.Manifest + "标签");
			m.name = root.getAttribute(Const.Name);
			if (m.name == null) ee("你没有为你的CoffeeMod项目配置\"" + Const.Name + "\"属性");
			m.icon = root.getAttribute(Const.Icon);
			m.desc = root.getAttribute(Const.Name);
			m.pkg = root.getAttribute(Const.Package);
			m.author = root.getAttribute(Const.Author);
			String s=root.getAttribute(Const.ShowLoading);
			if (TextUtils.isEmpty(s)) m.showLoading = false; else m.showLoading = Boolean.parseBoolean(s);
			s = null;
			try {
				File path=new File("/sdcard/games/CoffeeMod/mods/" + m.name + "/main.dex");
				path.getParentFile().mkdirs();
				IOUtil.copy(jar, new FileOutputStream(path));
				m.clzloader = new DexClassLoader(path.getPath() + ":/sdcard/games/CoffeeMod/public/CoffeeMod.dex", ctx.getDir("CoffeeMod", 0).getAbsolutePath(), null, Manifest.class.getClassLoader());
				Class<?> c = m.clzloader.loadClass(m.pkg.trim());
				m.mod = (CoffeeMod) c.newInstance();
			} catch (ClassNotFoundException e) {
				Logs.err("加载Mod时发生错误", e);
				ee("无法找到指定类\"" + m.pkg + "\"或此类不继承自com.jxs.cofmod.control.CoffeeMod");
			}
		} catch (Exception e) {
			Logs.err("加载Manifest时发生错误", e);
		}
		return m;
	}

	private static void ee(String w) throws Exception {
		throw new Exception(w);
	}

	private Manifest() {}
}
