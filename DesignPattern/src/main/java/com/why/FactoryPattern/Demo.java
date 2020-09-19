package com.why.FactoryPattern;

import java.util.ResourceBundle;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 15:35
 * @description：
 * @version:
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("property");
            String name = resourceBundle.getString("name");
            FruitJuicerFactory.getFuitJuicer(name).mkJuice();
            Thread.sleep(5000);
        }
    }
}
