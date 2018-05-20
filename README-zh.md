# CoffeeMod
![版本](https://img.shields.io/badge/%E7%89%88%E6%9C%AC-Reborn-2196F3.svg)
![版本名](https://img.shields.io/badge/%E7%89%88%E6%9C%AC%E5%90%8D-V1.0.0-009688.svg)
![版本号](https://img.shields.io/badge/%E7%89%88%E6%9C%AC%E5%8F%B7-1-009688.svg)  
![语言](https://img.shields.io/badge/%E8%AF%AD%E8%A8%80-Java-red.svg)
![作者](https://img.shields.io/badge/%E4%BD%9C%E8%80%85-Xs.JIONG-brightgreen.svg)
![许可证](https://img.shields.io/badge/%E8%AE%B8%E5%8F%AF%E8%AF%81-GPL--3.0-lightgray.svg)  
[English Version](https://github.com/XsJIONG/CoffeeMod/blob/master/README.md)

## 这是什么？
 **CoffeeMod**是一个能使你使用Java来编写ModPE的引擎  
它提供了一系列的方法与函数，使得你能够像在Js中一样编写ModPE（不过这会比Js更快）  
让我们来看看下面这段示例代码

````java
@Override
public void procCmd(String cmd) { //当输入命令时调用
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

上面的代码模拟了爆炸命令的功能，当玩家在消息框中输入"/explode 5"时，就会在玩家坐标发生一次强度为5的爆炸

## 为什么我要选择CoffeeMod？

- 快速，高效，速度远大于Js
- 针对BlockLauncher，多玩启动器都有优化
- 提供丰富的API（Weapon,Food等）
- 在编辑阶段提供了Js所没有的自动补全功能
- 精简，打包modpkg只有不到100Kb  
......

## 如何使用CoffeeMod？
目前我还没有设计出合适的App来建立CoffeeMod项目...实在抱歉！  
这可能会花费几个月时间...
