package com.jxs.cofmod;

import com.jxs.cofmod.control.*;

public class Server extends Modable {
	public static final int C=7;

	@Override
	public void onCreate() {

	}

    //固定函数
	public static final String getAddress() {return null;}
	public static final String[] getAllPlayerNames() {return null;}
	public static final long[] getAllPlayers() {return null;}
	public static final int getPort() {return 0;}
	public static final void joinServer(String p1, int p2) {}
	public static final void sendChat(String p1) {}
}
