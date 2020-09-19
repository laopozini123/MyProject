package com.why.FactoryPattern;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 15:32
 * @description：
 * @version:
 */
public class Pear extends Fruit implements FruitJuicer {
    @Override
    public void mkJuice() {
        System.out.println("我是梨");
        juice();
    }

    @Override
    public void juice() {
        System.out.println("一杯梨汁");
    }
}
