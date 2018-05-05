package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Server extends Modable {
	public static final int C=7;

	@Override
	public void onCreate() {

	}

    //固定函数
	public static final String getAddress() {return (String) call(C, "getAddress");}
	public static final String[] getAllPlayerNames() {return (String[]) call(C, "getAllPlayerNames");}
	public static final long[] getAllPlayers() {return (long[]) call(C, "getAllPlayers");}
	public static final int getPort() {return call(C, "getPort");}
	public static final void joinServer(String ip, Object port) {call(C, "joinServer", ip, toInt(port));}
	public static final void sendChat(String msg) {call(C, "sendChat", msg);}
}
