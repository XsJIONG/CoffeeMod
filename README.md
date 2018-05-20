![CoffeeMod](https://github.com/XsJIONG/CoffeeMod/raw/master/cofmod.png)
# CoffeeMod
![Version](https://img.shields.io/badge/Version-Reborn-2196F3.svg)
![Version Name](https://img.shields.io/badge/Version%20Name-V1.0.0-009688.svg)
![Version Code](https://img.shields.io/badge/Version%20Code-1-009688.svg)  
![Language](https://img.shields.io/badge/Language-Java-red.svg)
![Author](https://img.shields.io/badge/Author-Xs.JIONG-brightgreen.svg)
![Lisence](https://img.shields.io/badge/Lisence-GPL--3.0-lightgrey.svg)  
[中文版](https://github.com/XsJIONG/CoffeeMod/blob/master/README-zh.md)

## What's this?
 **CoffeeMod** is a ModPE engine which allows you to make ModPE with Java  
It provides a series of methods, so you can make ModPE in a similar way to Js (But it's faster than Js)  
Check out the sample code:

````java
@Override
public void procCmd(String cmd) { //Be called when player execute command
	String[] c=cmd.split(' ');
	if (c.length!=2) return;
	if (!c[0].equals("explode")) return;
	int e=0;
	try {
		e=Integer.parseInt(c[1]);
	} catch (Exception e) {return;}
	explode(Player.getX(), Player.getY(), Player.getZ(), e);
}
````

Previous code provides an explode command. For example, when player execute command "/explode 5", it will explode at player's position

## Why do I choose CoffeeMod?

- Fast, CoffeeMod is quicker than Js
- CoffeeMod has pertinent optimizition for BlockLauncher & Duowan
- CoffeeMod provides several API, such as Weapon, Food and so on
- You can enjoy auto-completion when using Java
- The modpkg of CoffeeMod is only about 100KB  
......

## How to use it?
I'm sorry to tell you that I didn't make a proper App for making CoffeeMod...  
But I promise I'll make it soon!
