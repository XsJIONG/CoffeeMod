package com.jxs.cofmod.util;

import com.jxs.cofmod.control.Modable;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Logs extends Modable {
	public static boolean LOG=true;
	public static String PATH="/sdcard/games/CoffeeMod_log";
	public static String TAG="CoffeeMod";
	public static PrintWriter out;

	static {
		try {
			out = new PrintWriter(new FileOutputStream(PATH), true);
		} catch (Exception e) {
			Modable.print("初始化Logs时发生错误！"+ets(e));
		}
	}

	public static void flush() {out.flush();}
	public static void print(Object s) {out.print(s);out.flush();}
	public static void println(Object s) {out.println(s);out.flush();}
}
