package com.enjoy.create.fatory.fatoryMethod;

import com.enjoy.entity.Fruit;
import com.enjoy.entity.fruit.Apple;

/**
 * 工厂方法模式
 */
public class AppleFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Apple();
    }
}
