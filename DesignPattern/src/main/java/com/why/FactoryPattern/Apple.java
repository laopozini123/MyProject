package com.why.FactoryPattern;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 15:28
 * @description：
 * @version:
 */
public class Apple extends Fruit implements FruitJuicer {

    @Override
    public void mkJuice(){
        System.out.println("我是苹果:");
        juice();
    }

    @Override
    public void juice() {
        System.out.println("一杯苹果汁");
    }
}
