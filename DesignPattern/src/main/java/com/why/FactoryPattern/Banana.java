package com.why.FactoryPattern;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 15:30
 * @description：
 * @version:
 */
public class Banana extends Fruit implements FruitJuicer {
    @Override
    public void mkJuice(){
        System.out.println("我是香蕉:");
        juice();
    }
    @Override
    public void juice() {
        System.out.println("一杯香蕉汁");
    }
}
