package com.why.FactoryPattern;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 15:33
 * @description：
 * @version:
 */
public class WaterMellon extends Fruit implements FruitJuicer {
    @Override
    public void mkJuice() {
        System.out.println("我是西瓜:");
        juice();
    }

    @Override
    public void juice() {
        System.out.println("一杯西瓜汁");
    }
}
