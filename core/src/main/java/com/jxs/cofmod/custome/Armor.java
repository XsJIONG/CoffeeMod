package com.jxs.cofmod.custome;

import com.jxs.cofmod.Item;
import com.jxs.cofmod.Player;

public class Armor extends Item {
	@Override
	public void onCreate() {
		Item.defineArmor(getItemId(), getTexture(), getTextureOffset(), getItemName(), getSkin(), getDefense(), getDurable(), getArmorType());
		if (inCreativeBag()) Player.addItemCreativeInv(getItemId(), 1);
	}
	
	//待重写函数
	public boolean inCreativeBag() {
		return true;
	}
	
	public int getArmorType() {
		return ArmorType.helmet;
	}
	
	public int getDefense() {
		return 5;
	}
	
	public String getSkin() {
		return "mob/char.png";
	}
	
	public int getDurable() {
		return 100;
	}
	
	@Override
	public String getTexture() {
		return "helmet";
	}
	
	@Override
	public int getTextureOffset() {
		return 4;
	}
}
