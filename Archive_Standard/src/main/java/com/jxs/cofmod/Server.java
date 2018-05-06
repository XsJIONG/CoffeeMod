package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

import static com.jxs.cofmod.S.*;

public class Server extends Modable {
	public static final int C=7;

	@Override
	public void onCreate() {}

    //固定函数
	public static final String getAddress() {return (String) call(C, "getAddress");}
	public static final String[] getAllPlayerNames() {return (String[]) call(C, "getAllPlayerNames");}
	public static final long[] getAllPlayers() {return (long[]) call(C, "getAllPlayers");}
	public static final int getPort() {return call(C, "getPort");}
	public static final void joinServer(String p1, int p2) {call(C, "joinServer", p1, p2);}
	public static final void sendChat(String p1) {call(C, "sendChat", p1);}
}
