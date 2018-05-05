package com.jxs.cofmod.control;

public interface Const {
	public static interface ArmorType {
		int boots = 0;
		int chestplate = 1;
		int helmet = 2;
		int leggings = 3;
	}

	public static interface BlockFace {
		int DOWN = 0;
		int EAST = 1;
		int NORTH = 2;
		int SOUTH = 3;
		int UP = 4;
		int WEST = 5;
	}

	/*static interface BlockRenderLayer {
		int alpha = 1100007;
		int alpha_seasons = 1100008;
		int alpha_single_side = 1100009;
		int blend = 1100010;
		int doubleside = 1100011;
		int far = 1100012;
		int opaque = 1100013;
		int opaque_seasons = 1100014;
		int seasons_far = 1100015;
		int seasons_far_alpha = 1100016;
		int water = 1100017;
	}*/

	public static interface ChatColor {
		String AQUA = "§b";
		String BEGIN = "§";
		String BLACK = "§0";
		String BLUE = "§9";
		String BOLD = "§l";
		String DARK_AQUA = "§3";
		String DARK_BLUE = "§1";
		String DARK_GRAY = "§8";
		String DARK_GREEN = "§2";
		String DARK_PURPLE = "§5";
		String DARK_RED = "§4";
		String GOLD = "§6";
		String GRAY = "§7";
		String GREEN = "§a";
		String LIGHT_PURPLE = "§d";
		String RED = "§c";
		String RESET = "§r";
		String WHITE = "§f";
		String YELLOW = "§e";
	}

	public static interface DimensionId {
		int NETHER = 1;
		int NORMAL = 0;
		int END=2;
	}

	public static interface EnchantType {
		int all = 16383;
		int axe = 512;
		int book = 16383;
		int bow = 32;
		int fishingRod = 4096;
		int flintAndSteel = 256;
		int hoe = 64;
		int pickaxe = 1024;
		int shears = 128;
		int shovel = 2048;
		int weapon = 16;
	}

	public static interface Enchantment {
		int AQUA_AFFINITY = 7;
		int BANE_OF_ARTHROPODS = 11;
		int BLAST_PROTECTION = 3;
		int DEPTH_STRIDER = 8;
		int EFFICIENCY = 15;
		int FEATHER_FALLING = 2;
		int FIRE_ASPECT = 13;
		int FIRE_PROTECTION = 1;
		int FLAME = 21;
		int FORTUNE = 18;
		int INFINITY = 22;
		int KNOCKBACK = 12;
		int LOOTING = 14;
		int LUCK_OF_THE_SEA = 23;
		int LURE = 24;
		int POWER = 19;
		int PROJECTILE_PROTECTION = 4;
		int PROTECTION = 0;
		int PUNCH = 20;
		int RESPIRATION = 6;
		int SHARPNESS = 9;
		int SILK_TOUCH = 16;
		int SMITE = 10;
		int THORNS = 15;
		int UNBREAKING = 17;
	}

	public static interface EntityRenderType {
		int tnt = 2;
		int human = 3;
		int item = 4;
		int chicken = 5;
		int cow = 6;
		int mushroomCow = 7;
		int pig = 8;
		int sheep = 9;
		int bat = 10;
		int wolf = 11;
		int villager = 12;
		int zombie = 14;
		int zombiePigman = 15;
		int lavaSlime = 16;
		int ghast = 17;
		int blaze = 18;
		int skeleton = 19;
		int spider = 20;
		int silverfish = 21;
		int creeper = 22;
		int slime = 23;
		int enderman = 24;
		int arrow = 25;
		int fishHook = 26;
		int player = 27;
		int snowball = 28;
		int egg = 29;
		int unknownItem = 30;
		int thrownPotion = 31;
		int painting = 32;
		int fallingTile = 33;
		int minecart = 34;
		int boat = 35;
		int squid = 36;
		int fireball = 37;
		int smallFireball = 38;
		int villagerZombie = 39;
		int experienceOrb = 40;
		int lightningBolt = 41;
		int ironGolem = 42;
		int ocelot = 43;
		int snowGolem = 44;
		int expPotion = 45;
		int rabbit = 46;
		int witch = 47;
		int camera = 49;
		int map = 50;
	}

	public static interface EntityType {
		int CHICKEN = 10;
		int COW = 11;
		int PIG = 12;
		int SHEEP = 13;
		int WOLF = 14;
		int VILLAGER = 15;
		int MUSHROOM_COW = 16;
		int SQUID = 17;
		int RABBIT = 18;
		int BAT = 19;
		int IRON_GOLEM = 20;
		int SNOW_GOLEM = 21;
		int OCELOT = 22;
		int ZOMBIE = 32;
		int CREEPER = 33;
		int SKELETON = 34;
		int SPIDER = 35;
		int PIG_ZOMBIE = 36;
		int SLIME = 37;
		int ENDERMAN = 38;
		int SILVERFISH = 39;
		int CAVE_SPIDER = 40;
		int GHAST = 41;
		int LAVA_SLIME = 42;
		int BLAZE = 43;
		int ZOMBIE_VILLAGER = 44;
		int PLAYER = 63;
		int ITEM = 64;
		int PRIMED_TNT = 65;
		int FALLING_BLOCK = 66;
		int EXPERIENCE_POTION = 68;
		int EXPERIENCE_ORB = 69;
		int FISHING_HOOK = 77;
		int ARROW = 80;
		int SNOWBALL = 81;
		int EGG = 82;
		int PAINTING = 83;
		int MINECART = 84;
		int FIREBALL = 85;
		int THROWN_POTION = 86;
		int BOAT = 13;
		int LIGHTNING_BOLT = 93;
		int SMALL_FIREBALL = 94;
	}

	public static interface ItemCategory {
		int DECORATION = 0;
		int FOOD = 1;
		int INTERNAL = 2;
		int MATERIAL = 3;
		int TOOL = 4;
	}

	public static interface MobEffect {
		int movementSpeed = 1;
		int movementSlowdown = 2;
		int digSpeed = 3;
		int digSlowdown = 4;
		int damageBoost = 5;
		int heal = 6;
		int harm = 7;
		int jump = 8;
		int confusion = 9;
		int regeneration = 10;
		int damageResistance = 11;
		int fireResistance = 12;
		int waterBreathing = 13;
		int invisibility = 14;
		int blindness = 15;
		int nightVision = 16;
		int hunger = 17;
		int weakness = 18;
		int poison = 19;
		int wither = 20;
		int healthBoost = 21;
		int absorption = 22;
	}

	public static interface ParticleType {
		int angryVillager = 30;
		int bubble = 1;
		int cloud = 4;
		int crit = 2;
		int dripLava = 22;
		int dripWater = 21;
		int enchantmenttable = 32;
		int fallingDust = 23;
		int flame = 6;
		int happyVillager = 31;
		int heart = 15;
		int hugeexplosion = 13;
		int hugeexplosionSeed = 12;
		int ink = 27;
		int itemBreak = 10;
		int largeexplode = 5;
		int lava = 7;
		int mobFlame = 14;
		int note = 34;
		int portal = 18;
		int rainSplash = 29;
		int redstone = 9;
		int slime = 28;
		int smoke = 3;
		int smoke2 = 8;
		int snowballpoof = 11;
		int spell = 24;
		int spell2 = 25;
		int spell3 = 26;
		int splash = 19;
		int suspendedTown = 17;
		int terrain = 16;
		int waterWake = 20;
	}

	public static interface UseAnimation {
		int bow = 4;
		int normal = 0;
	}
	
	public static final String[][] LauncherAdapter={
		{"com.mojang.minecraftpe.archive.Block","com.mojang.minecraftpe.archive.Entity","com.mojang.minecraftpe.archive.Item","com.mojang.minecraftpe.archive.Level","com.mojang.minecraftpe.archive.ModPE","com.mojang.minecraftpe.archive.Player","com.mojang.minecraftpe.archive.Renderer","com.mojang.minecraftpe.archive.Server"},
		{"com.mcbox.pesdkb.mcpelauncher.jsapi.NativeBlockApi","com.mcbox.pesdkb.mcpelauncher.jsapi.NativeEntityApi","com.mcbox.pesdkb.mcpelauncher.jsapi.NativeItemApi","com.mcbox.pesdkb.mcpelauncher.jsapi.NativeLevelApi","com.mcbox.pesdkb.mcpelauncher.jsapi.NativeModPEApi","com.mcbox.pesdkb.mcpelauncher.jsapi.NativePlayerApi","com.mcbox.pesdkb.mcpelauncher.api.modpe.RendererManager$NativeRendererApi","com.mcbox.pesdkb.mcpelauncher.jsapi.NativeServerApi"},
		{"net.zhuoweizhang.mcpelauncher.ScriptManager$NativeBlockApi","net.zhuoweizhang.mcpelauncher.ScriptManager$NativeEntityApi","net.zhuoweizhang.mcpelauncher.ScriptManager$NativeItemApi","net.zhuoweizhang.mcpelauncher.ScriptManager$NativeLevelApi","net.zhuoweizhang.mcpelauncher.ScriptManager$NativeModPEApi","net.zhuoweizhang.mcpelauncher.ScriptManager$NativePlayerApi","net.zhuoweizhang.mcpelauncher.api.modpe.RendererManager$NativeRendererApi","net.zhuoweizhang.mcpelauncher.ScriptManager$NativeServerApi"}
	};
}
