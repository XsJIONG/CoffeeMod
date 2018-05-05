package com.jxs.cofmod.custome;

import com.jxs.cofmod.Item;
import com.jxs.cofmod.custome.AEntity;

public class Weapon extends Item {
	@Override
	public void onCreate() {
		super.onCreate();
	}
	
	public int getAttack() {
		return 5;
	}
	
	public void onAttack(AEntity target) {
		target.setHealth(target.getHealth()-getAttack());
	}
}
