package com.jxs.cofmod.custome;

import com.jxs.cofmod.Item;
import com.jxs.cofmod.ModPE;

public class Food extends Item {
	@Override
	public void onCreate() {
		ModPE.setFoodItem(getItemId(), getTexture(), getTextureOffset(), getSupply(), getItemName(), getMaxStakeSize());
	}
	
	//待重写函数
	public int getSupply() {
		return 3;
	}

	@Override
	public String getTexture() {
		return "apple";
	}

	@Override
	public int getTextureOffset() {
		return 0;
	}
	
	//自定义钩子
	public void onEat() {}
}
