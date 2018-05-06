package com.jxs.cofmod;

import com.mcbox.pesdkb.mcpelauncher.*;

public class Server {
	public static void joinServer(String serverAddress, int port) {
		throw new RuntimeException("Unsupported");
	}

	public static void sendChat(String message) {
		if (ScriptManager.isRemote) {
			ScriptManager.nativeSendChat(message);
		}
	}

	public static String getAddress() {
		return ScriptManager.serverAddress;
	}

	public static int getPort() {
		return ScriptManager.serverPort;
	}

	public static long[] getAllPlayers() {
		long[] players = new long[ScriptManager.allplayers.size()];
		for (int n = 0; players.length > n; n++) {
			players[n] = ((Long) ScriptManager.allplayers.get(n)).longValue();
		}
		return players;
	}

	public static String[] getAllPlayerNames() {
		String[] players = new String[ScriptManager.allplayers.size()];
		for (int n = 0; players.length > n; n++) {
			players[n] = ScriptManager.nativeGetPlayerName(((Long) ScriptManager.allplayers.get(n)).longValue());
		}
		return players;
	}
}
