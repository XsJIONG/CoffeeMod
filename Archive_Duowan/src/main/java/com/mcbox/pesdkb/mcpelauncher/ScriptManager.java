package com.mcbox.pesdkb.mcpelauncher;

import android.content.*;
import android.renderscript.*;
import com.mcbox.pesdkb.mcpelauncher.jsapi.*;
import com.mcbox.pesdkb.mcpelauncher.texture.*;
import com.mojang.minecraftpe.*;
import java.io.*;
import java.util.*;
import org.json.*;
import org.mozilla.javascript.*;

public class ScriptManager {
	public static int serverPort;
	public static boolean isRemote;
	public static String screenshotFileName,serverAddress;
	public static String currentScript;
	public static Context androidContext;
	public static SelectLevelRequest requestSelectLevel;
	public static String worldName,worldDir;
	public static AtlasProvider itemsMeta;
	public static WorldData worldData;
	public static List<Long> allentities,allplayers;
	public static ClientBlocksJsonProvider blocksJson;
	public static int ITEM_ID_COUNT=512;
	public static void OnBoxEventNotify(int p1, int p2) {}
	public static void OnMinecraftQuit() {}
	public static void attackCallback(long p1, long p2) {}
	public static void blockEventCallback(int p1, int p2, int p3, int p4, int p5) {}
	public static void callScriptMethod(String p1, Object[] p2) {}
	public static void chatCallback(String p1) {}
	public static ScriptableObject classConstantsToJSObject(Class p1) {return null;}
	public static void clearAllEnableScripts() {}
	public static void clearTextureOverride(String p1) {}
	public static void clearTextureOverrides() {}
	public static void commandBlockPlaceCallBack() {}
	public static void continueDestroyBlockCallback(int p1, int p2, int p3, int p4, float p5) {}
	public static void destroy() {}
	public static void destroyBlockCallback(int p1, int p2, int p3, int p4) {}
	public static void doUseItemOurselves(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {}
	public static void dummyThrowableHitEntityCallback() {}
	public static void eatCallback(int p1, float p2) {}
	public static void entityAddedCallback(long p1) {}
	public static void entityHurtCallback(long p1, long p2, int p3) {}
	public static void entityRemovedCallback(long p1) {}
	public static int[] expandColorsArray(Scriptable p1) {return null;}
	public static int[] expandShapelessRecipe(Scriptable p1) {return null;}
	public static TextureRequests expandTexturesArray(Object p1) {return null;}
	public static void explodeCallback(long p1, float p2, float p3, float p4, float p5, boolean p6) {}
	public static void frameCallback() {}
	public static String getAllApiMethodsDescriptions() {return null;}
	public static Set getEnabledScripts() {return null;}
	public static long getEntityId(Object p1) {return 0;}
	public static String getEntityUUID(long p1) {return null;}
	public static File getOriginalFile(File p1) {return null;}
	public static JSONObject getOriginalLocations() {return null;}
	public static String getPlayerNameFromConfs() {return null;}
	public static File getScriptFile(String p1) {return null;}
	public static String getSkinURL(String p1) {return null;}
	public static byte[] getSoundBytes(String p1) {return null;}
	public static InputStream getSoundInputStream(String p1, long[] p2) {return null;}
	public static File getTextureOverrideFile(String p1) {return null;}
	public static String getWorldPath() {return null;}
	public static void handleChatPacketCallback(String p1) {}
	public static void handleMessagePacketCallback(String p1, String p2) {}
	public static void init(Context p1) {}
	public static void init(Context p1, boolean p2) {}
	public static void initJustLoadedScript(Context p1, Script p2, String p3) {}
	public static boolean invalidTexName(String p1) {return false;}
	public static void invokeScriptMethod(String p1, String p2, Object[] p3) {}
	public static boolean isEnabled(File p1) {return false;}
	public static boolean isLocalAddress(String p1) {return false;}
	public static boolean isRealLocalAddress(String p1) {return false;}
	public static boolean isSkinNameNormalized() {return false;}
	public static boolean isValidStringParameter(String p1) {return false;}
	public static void leaveGameCallback(boolean p1) {}
	public static void levelEventCallback(int p1, int p2, int p3, int p4, int p5, int p6) {}
	public static void loadEnabledScripts() {}
	public static void loadEnabledScriptsNames(Context p1) {}
	public static void loadModPkgScripts() {}
	public static void loadScript(File p1) {}
	public static void loadScript(Reader p1, String p2, String p3) {}
	public static TextureRequests mapTextureNames(TextureRequests p1) {return null;}
	public static void mobDieCallback(long p1, long p2) {}
	public static native void nativeAddFurnaceRecipe(int p1, int p2, int p3);
	public static native void nativeAddItemChest(int p1, int p2, int p3, int p4, int p5, int p6, int p7);
	public static native void nativeAddItemCreativeInv(int p1, int p2, int p3);
	public static native void nativeAddItemFurnace(int p1, int p2, int p3, int p4, int p5, int p6, int p7);
	public static native void nativeAddItemInventory(int p1, int p2, int p3);
	public static native void nativeAddShapedRecipe(int p1, int p2, int p3, String[] p4, int[] p5);
	public static native void nativeArmorAddQueuedTextures();
	public static native String nativeBiomeIdToName(int p1);
	public static native float nativeBlockGetDestroyTime(int p1, int p2);
	public static native float nativeBlockGetFriction(int p1);
	public static native int nativeBlockGetSecondPart(int p1, int p2, int p3, int p4);
	public static native void nativeBlockSetCollisionEnabled(int p1, boolean p2);
	public static native void nativeBlockSetColor(int p1, int[] p2);
	public static native void nativeBlockSetDestroyTime(int p1, float p2);
	public static native void nativeBlockSetExplosionResistance(int p1, float p2);
	public static native void nativeBlockSetFriction(int p1, float p2);
	public static native void nativeBlockSetLightLevel(int p1, int p2);
	public static native void nativeBlockSetLightOpacity(int p1, int p2);
	public static native void nativeBlockSetRedstoneConsumer(int p1, boolean p2);
	public static native void nativeBlockSetRenderLayer(int p1, int p2);
	public static native void nativeBlockSetShape(int p1, float p2, float p3, float p4, float p5, float p6, float p7, int p8);
	public static native void nativeBlockSetStepSound(int p1, int p2);
	public static native void nativeClearCapes();
	public static native void nativeClearSlotInventory(int p1);
	public static native void nativeClientMessage(String p1);
	public static native void nativeCloseScreen();
	public static native void nativeDefineArmor(int p1, String p2, int p3, String p4, String p5, int p6, int p7, int p8);
	public static native void nativeDefineBlock(int p1, String p2, String[] p3, int[] p4, int p5, boolean p6, int p7);
	public static native void nativeDefineBlock(int p1, String p2, String[] p3, int[] p4, int p5, boolean p6, int p7, int p8);
	public static native void nativeDefineFoodItem(int p1, String p2, int p3, int p4, String p5, int p6);
	public static native void nativeDefineItem(int p1, String p2, int p3, String p4, int p5);
	public static native void nativeDefinePlaceholderBlocks();
	public static native void nativeDefineSnowballItem(int p1, String p2, int p3, String p4, int p5);
	public static native void nativeDestroyBlock(int p1, int p2, int p3);
	public static native long nativeDropItem(float p1, float p2, float p3, float p4, int p5, int p6, int p7);
	public static native void nativeDumpVtable(String p1, int p2);
	public static native int nativeEntityGetCarriedItem(long p1, int p2);
	public static native String nativeEntityGetMobSkin(long p1);
	public static native String nativeEntityGetNameTag(long p1);
	public static native int nativeEntityGetRenderType(long p1);
	public static native int nativeEntityGetRider(long p1);
	public static native int nativeEntityGetRiding(long p1);
	public static native long nativeEntityGetTarget(long p1);
	public static native long[] nativeEntityGetUUID(long p1);
	public static native boolean nativeEntityHasCustomSkin(long p1);
	public static native void nativeEntitySetImmobile(long p1, boolean p2);
	public static native void nativeEntitySetNameTag(long p1, String p2);
	public static native void nativeEntitySetSize(long p1, float p2, float p3);
	public static native void nativeEntitySetTarget(long p1, long p2);
	public static native void nativeExplode(float p1, float p2, float p3, float p4, boolean p5);
	public static native void nativeExtinguishFire(int p1, int p2, int p3, int p4);
	public static native void nativeForceCrash();
	public static native void nativeGetAllEntities();
	public static native int nativeGetAnimalAge(long p1);
	public static native int nativeGetArch();
	public static native int nativeGetBlockRenderShape(int p1);
	public static native int nativeGetBrightness(int p1, int p2, int p3);
	public static native int nativeGetCarriedItem(int p1);
	public static native int nativeGetData(int p1, int p2, int p3);
	public static native float nativeGetEntityLoc(long p1, int p2);
	public static native int nativeGetEntityTypeId(long p1);
	public static native float nativeGetEntityVel(long p1, int p2);
	public static native int nativeGetGameType();
	public static native String nativeGetI18NString(String p1);
	public static native int nativeGetItemChest(int p1, int p2, int p3, int p4);
	public static native int nativeGetItemCountChest(int p1, int p2, int p3, int p4);
	public static native int nativeGetItemCountFurnace(int p1, int p2, int p3, int p4);
	public static native int nativeGetItemDataChest(int p1, int p2, int p3, int p4);
	public static native int nativeGetItemDataFurnace(int p1, int p2, int p3, int p4);
	public static native int nativeGetItemEntityItem(long p1, int p2);
	public static native int nativeGetItemFurnace(int p1, int p2, int p3, int p4);
	public static native int nativeGetItemIdCount();
	public static native int nativeGetItemMaxDamage(int p1);
	public static native String nativeGetItemName(int p1, int p2, boolean p3);
	public static native String nativeGetItemNameChest(int p1, int p2, int p3, int p4);
	public static native String nativeGetLanguageName();
	public static native long nativeGetLevel();
	public static native int nativeGetMobHealth(long p1);
	public static native int nativeGetMobMaxHealth(long p1);
	public static native float nativeGetPitch(long p1);
	public static native long nativeGetPlayerEnt();
	public static native float nativeGetPlayerLoc(int p1);
	public static native String nativeGetPlayerName(long p1);
	public static native int nativeGetSelectedSlotId();
	public static native String nativeGetSignText(int p1, int p2, int p3, int p4);
	public static native int nativeGetSlotArmor(int p1, int p2);
	public static native int nativeGetSlotInventory(int p1, int p2);
	public static native boolean nativeGetTextureCoordinatesForBlock(int p1, int p2, int p3, float[] p4);
	public static native boolean nativeGetTextureCoordinatesForItem(int p1, int p2, float[] p3);
	public static native int nativeGetTile(int p1, int p2, int p3);
	public static int nativeGetTileWrap(int p1, int p2, int p3) {return 0;}
	public static native long nativeGetTime();
	public static native float nativeGetYaw(long p1);
	public static native boolean nativeHasPreventedDefault();
	public static native void nativeHurtTo(int p1);
	public static native boolean nativeIsSneaking(long p1);
	public static native boolean nativeIsValidCommand(String p1);
	public static native boolean nativeIsValidItem(int p1);
	public static native int nativeItemGetMaxStackSize(int p1);
	public static native int nativeItemGetUseAnimation(int p1);
	public static native boolean nativeItemIsExtendedBlock(int p1);
	public static native boolean nativeItemSetProperties(int p1, String p2);
	public static native void nativeItemSetStackedByData(int p1, boolean p2);
	public static native void nativeItemSetUseAnimation(int p1, int p2);
	public static native void nativeJoinServer(String p1, int p2);
	public static native void nativeLeaveGame(boolean p1);
	public static native void nativeLevelAddParticle(int p1, float p2, float p3, float p4, float p5, float p6, float p7, int p8);
	public static native void nativeLevelAddParticle(String p1, float p2, float p3, float p4, float p5, float p6, float p7, int p8);
	public static native boolean nativeLevelCanSeeSky(int p1, int p2, int p3);
	public static native int nativeLevelGetBiome(int p1, int p2);
	public static native String nativeLevelGetBiomeName(int p1, int p2);
	public static native int nativeLevelGetDifficulty();
	public static native int nativeLevelGetExtraData(int p1, int p2, int p3);
	public static native int nativeLevelGetGrassColor(int p1, int p2);
	public static native float nativeLevelGetLightningLevel();
	public static native float nativeLevelGetRainLevel();
	public static native boolean nativeLevelIsRemote();
	public static native void nativeLevelSetBiome(int p1, int p2, int p3);
	public static native void nativeLevelSetDifficulty(int p1);
	public static native void nativeLevelSetExtraData(int p1, int p2, int p3, int p4);
	public static native void nativeLevelSetGrassColor(int p1, int p2, int p3);
	public static native void nativeLevelSetLightningLevel(float p1);
	public static native void nativeLevelSetRainLevel(float p1);
	public static native void nativeMobAddEffect(long p1, int p2, int p3, int p4, boolean p5, boolean p6);
	public static native int nativeMobGetArmor(long p1, int p2, int p3);
	public static native String nativeMobGetArmorCustomName(long p1, int p2);
	public static native void nativeMobRemoveAllEffects(long p1);
	public static native void nativeMobRemoveEffect(long p1, int p2);
	public static native void nativeMobSetArmor(long p1, int p2, int p3, int p4);
	public static native void nativeMobSetArmorCustomName(long p1, int p2, String p3);
	public static native void nativeModPESetDesktopGui(boolean p1);
	public static native void nativeModPESetRenderDebug(boolean p1);
	public static native void nativeOnGraphicsReset();
	public static native void nativePlaySound(float p1, float p2, float p3, String p4, float p5, float p6);
	public static native void nativePlayerAddExperience(int p1);
	public static native boolean nativePlayerCanFly();
	public static native boolean nativePlayerEnchant(int p1, int p2, int p3);
	public static native int nativePlayerGetDimension();
	public static native int[] nativePlayerGetEnchantments(int p1);
	public static native float nativePlayerGetExhaustion();
	public static native float nativePlayerGetExperience();
	public static native float nativePlayerGetHunger(long p1);
	public static native String nativePlayerGetItemCustomName(int p1);
	public static native int nativePlayerGetLevel();
	public static native int nativePlayerGetPointedBlock(int p1);
	public static native long nativePlayerGetPointedEntity();
	public static native float nativePlayerGetPointedVec(int p1);
	public static native float nativePlayerGetSaturation();
	public static native int nativePlayerGetScore();
	public static native boolean nativePlayerIsFlying();
	public static native void nativePlayerSetCanFly(boolean p1);
	public static native void nativePlayerSetExhaustion(float p1);
	public static native void nativePlayerSetExperience(float p1);
	public static native void nativePlayerSetFlying(boolean p1);
	public static native void nativePlayerSetHunger(long p1, float p2);
	public static native void nativePlayerSetItemCustomName(int p1, String p2);
	public static native void nativePlayerSetLevel(int p1);
	public static native void nativePlayerSetSaturation(float p1);
	public static native void nativePrePatch(boolean p1, MainActivity p2, boolean p3);
	public static native void nativePreventDefault();
	public static native void nativeRecipeSetAnyAuxValue(int p1, boolean p2);
	public static native void nativeRemoveEntity(long p1);
	public static native void nativeRemoveItemBackground();
	public static native void nativeRequestFrameCallback();
	public static native void nativeRideAnimal(long p1, long p2);
	public static native void nativeScreenChooserSetScreen(int p1);
	public static native void nativeSelectLevel(String p1, String p2);
	public static native void nativeSendChat(String p1);
	public static native void nativeSetAllowEnchantments(int p1, int p2, int p3);
	public static native void nativeSetAnimalAge(long p1, int p2);
	public static native void nativeSetArmorSlot(int p1, int p2, int p3);
	public static native void nativeSetBlockRenderShape(int p1, int p2);
	public static native void nativeSetCameraEntity(long p1);
	public static native void nativeSetCape(long p1, String p2);
	public static native void nativeSetCarriedItem(long p1, int p2, int p3, int p4);
	public static native boolean nativeSetEntityRenderType(long p1, int p2);
	public static native void nativeSetExitEnabled(boolean p1);
	public static native void nativeSetFov(float p1, boolean p2);
	public static native void nativeSetGameSpeed(float p1);
	public static native void nativeSetGameType(int p1);
	public static native void nativeSetHandEquipped(int p1, boolean p2);
	public static native void nativeSetI18NString(String p1, String p2);
	public static native void nativeSetInventorySlot(int p1, int p2, int p3, int p4);
	public static native void nativeSetIsRecording(boolean p1);
	public static native void nativeSetItemCategory(int p1, int p2, int p3);
	public static native void nativeSetItemMaxDamage(int p1, int p2);
	public static native void nativeSetItemNameChest(int p1, int p2, int p3, int p4, String p5);
	public static native void nativeSetMobHealth(long p1, int p2);
	public static native void nativeSetMobMaxHealth(long p1, int p2);
	public static native void nativeSetMobSkin(long p1, String p2);
	public static native void nativeSetNightMode(boolean p1);
	public static native void nativeSetOnFire(long p1, int p2);
	public static native void nativeSetPosition(long p1, float p2, float p3, float p4);
	public static native void nativeSetPositionRelative(long p1, float p2, float p3, float p4);
	public static native void nativeSetRot(long p1, float p2, float p3);
	public static native void nativeSetSelectedSlotId(int p1);
	public static native void nativeSetSignText(int p1, int p2, int p3, int p4, String p5);
	public static native void nativeSetSneaking(long p1, boolean p2);
	public static native void nativeSetSpawn(int p1, int p2, int p3);
	public static native void nativeSetStonecutterItem(int p1, int p2);
	public static native void nativeSetTextParseColorCodes(boolean p1);
	public static native void nativeSetTile(int p1, int p2, int p3, int p4, int p5);
	public static native void nativeSetTime(long p1);
	public static native void nativeSetUseController(boolean p1);
	public static native void nativeSetVel(long p1, float p2, int p3);
	public static native void nativeSetupHooks(int p1);
	public static native void nativeShowProgressScreen();
	public static native void nativeShowTipMessage(String p1);
	public static native long nativeSpawnEntity(float p1, float p2, float p3, int p4, String p5);
	public static native int nativeSpawnerGetEntityType(int p1, int p2, int p3);
	public static native void nativeSpawnerSetEntityType(int p1, int p2, int p3, int p4);
	public static native boolean nativeZombieIsBaby(long p1);
	public static native void nativeZombieSetBaby(long p1, boolean p2);
	public static void onGameAesDecodeReport(int p1) {}
	public static void overrideTexture(String p1, String p2) {}
	public static void playerAddExperienceCallback(long p1, int p2) {}
	public static void playerAddLevelsCallback(long p1, int p2) {}
	public static void processDebugCommand(String p1) {}
	public static void rakNetConnectCallback(String p1, int p2) {}
	public static void redstoneUpdateCallback(int p1, int p2, int p3, int p4, boolean p5, int p6, int p7) {}
	public static boolean reimportIfPossible(File p1) {return false;}
	public static void reloadScript(File p1) {}
	public static void removeDeadEntries(Collection p1) {}
	public static void removeScript(String p1) {}
	public static void reportScriptError(ScriptState p1, Throwable p2) {}
	public static void requestGraphicsReset() {}
	public static void runOnMainThread(Runnable p1) {}
	public static void saveEnabledScripts(Set p1) {}
	public static void screenChangeCallback(String p1, String p2, String p3) {}
	public static void scriptPrint(String p1) {}
	public static void selectLevelCallback(String p1, String p2) {}
	public static void setCustomedSkinPack(boolean p1, String p2) {}
	public static void setEnabled(File p1, boolean p2) {}
	public static void setEnabled(String p1, boolean p2) {}
	public static void setEnabled(File[] p1, boolean p2) {}
	public static void setEnabledWithoutLoad(File p1, boolean p2) {}
	public static void setLevelCallback(boolean p1, boolean p2) {}
	public static void setLevelFakeCallback(boolean p1, boolean p2) {}
	public static void setOriginalLocation(File p1, File p2) {}
	public static void setRequestLeaveGame() {}
	public static void setupContext(Context p1) {}
	public static void startDestroyBlockCallback(int p1, int p2, int p3, int p4) {}
	public static void takeScreenshot(String p1) {}
	public static void takeScreenshotWithCallBack(String p1, boolean p2) {}
	public static void takeScreenshotWithWM(String p1, boolean p2, boolean p3) {}
	public static void throwableHitCallback(long p1, int p2, int p3, int p4, int p5, int p6, float p7, float p8, float p9, long p10) {}
	public static void tickCallback() {}
	public static void useItemOnCallback(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {}
	public static void verifyBlockTextures(TextureRequests p1) {}
	public static void wordWrapClientMessage(String p1) {}
	public static class TextureRequests {
		public int[] coords;
		public String[] names;
	}
	public static class SelectLevelRequest {
		public String dir;
		public int gameMode = 0;
		public String name;
		public String seed;
	}
}
