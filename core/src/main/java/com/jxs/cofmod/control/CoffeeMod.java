package com.jxs.cofmod.control;

import com.jxs.cofmod.*;
import com.jxs.cofmod.custome.*;
import java.util.*;

public class CoffeeMod extends Modable implements Const {
	public static final String Version="Reborn",VersionName="1.0.0";
	public static final int VersionCode=1;

	private static HashMap<Integer,Block> Blocks=new HashMap<>();
	private static HashMap<Integer,Item> Items=new HashMap<>();

	@Override
	public void onCreate() {
		defineBlocks();
		defineItems();
	}
	public static final String getVersion() {
		return Version;
	}
	public static final String getVersionName() {
		return VersionName;
	}
	public static final int getVersionCode() {
		return VersionCode;
	}
	public static boolean needJsHookFunction() {
		return LauncherType != Launcher_DuoWan;
	}

	//自定义函数
	public void defineBlocks() {
		Block[] all=getBlocks();
		for (Block one : all) {
			one.onCreate();
			Blocks.put(one.getBlockId(), one);
		}
	}

	public void defineItems() {
		Item[] all=getItems();
		for (Item one : all) {
			one.onCreate();
			Items.put(one.getItemId(), one);
		}
	}

	public Item[] getItems() {
		return new Item[] {};
	}

	public Block getBlockById(int id) {
		return Blocks.get(id);
	}

	public Item getItemById(int id) {
		return Items.get(id);
	}

	public String getModName() {
		return this.getClass().getSimpleName();
	}

	public String getAuthor() {
		return "ModMax用户";
	}

	public Block[] getBlocks() {
		return new Block[] {};
	}
	public static HashSet<String> HOOK_FUNCTIONS;
	static {
		HOOK_FUNCTIONS = new HashSet<>();
		String[] ss={
			"attackHook","chatHook","continueDestroyBlock","destroyBlock","projectileHitEntityHook","eatHook","entityAddedHook",
			"entityHurtHook","entityRemovedHook","explodeHook","serverMessageReceiveHook","chatReceiveHook","leaveGame","deathHook",
			"playerAddExpHook","playerExpLevelChangeHook","redstoneUpdateHook","selectLevelHook","screenChangeHook","newLevel",
			"startDestroyBlock","modTick","useItem"
		};
		for (String one : ss) HOOK_FUNCTIONS.add(one);
	}
	public CoffeeMod() {}

	//钩子函数
	public void attackHook(long attacker, long victim) {
		if (attacker == getPlayerEnt()) {
			int id = Player.getCarriedItem();
			Item i=getItemById(id);
			if (i != null || i instanceof Weapon) {
				((Weapon) i).onAttack(new AEntity(victim));
			}
		}
	}

	public void chatHook(String chat) {

	}

	public void continueDestroyBlock(int x, int y, int z, int side, double progress) {
		Block b=getBlockById(getTile(x, y, z));
		if (b != null) b.onContinueDestroy(x, y, z, side, progress);
	}

	public void destroyBlock(int x, int y, int z, int side) {
		Block b=getBlockById(getTile(x, y, z));
		if (b != null) b.onDestory(x, y, z, side);
	}

	public void projectileHitEntityHook(long projectile, long entity) {

	}

	public void eatHook(int add, int now) {
		Item i=getItemById(Player.getCarriedItem());
		if (i != null && i instanceof Food) ((Food) i).onEat();
	}

	public void entityAddedHook(long entity) {

	}

	public void entityHurtHook(long hurter, long victim) {

	}

	public void entityRemovedHook(long entity) {

	}

	public void explodeHook(long entity, double x, double y, double z, int power, boolean fire) {

	}

	public void serverMessageReceiveHook(String chat) {

	}

	public void chatReceiveHook(String chat) {

	}

	public void leaveGame() {

	}

	public void deathHook(long killer, long victim) {

	}

	public void playerAddExpHook(long player, int count) {

	}

	public void playerExpLevelChangeHook(long player, int level) {

	}

	public void redstoneUpdateHook(int x, int y, int z, int indensity, boolean loaded, int bid, int bidt) {
		Block b=getBlockById(bid);
		if ((b != null) && (indensity != 0) && (!loaded)) b.onCharge(x, y, z, indensity, bidt);
	}

	public void selectLevelHook() {

	}

	public void screenChangeHook(String name) {

	}

	public void newLevel() {

	}

	public void startDestroyBlock(int x, int y, int z, int side) {
		Block b=getBlockById(getTile(x, y, z));
		if (b != null) b.onStartDestroy(x, y, z, side);
	}

	public void modTick() {

	}

	public void useItem(int x, int y, int z, int id, int idt, int side, int bid, int bidt) {
		Block b=getBlockById(bid);
		if (b != null) b.onClick(x, y, x, id, idt, side, bidt);
		b = getBlockById(id);
		if (b != null) b.onPlace(x, y, z, idt, bid, bidt, side);
		b = null;
		Item i=getItemById(id);
		if (i != null) i.onUse(x, y, z, idt, bid, bidt, side);
	}
}
