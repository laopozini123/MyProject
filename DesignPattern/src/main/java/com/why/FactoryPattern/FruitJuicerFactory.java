package com.why.FactoryPattern;

/**
 * @author ：why
 * @date ：Created in 2020/5/9 14:32
 * @description：
 * @version:
 */
public class FruitJuicerFactory {

    public static Fruit getFuitJuicer(String name) {
        Fruit juicer ;
        switch (name) {
            case "Apple":
                juicer = new Apple();
                break;
            case "Banana":
                juicer = new Banana();
                break;
            case "Pear":
                juicer = new Pear();
                break;
            case "WaterMellon":
                juicer = new WaterMellon();
                break;
            default:
                return null;
        }
        return juicer;
    }
}
