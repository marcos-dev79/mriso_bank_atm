package com.risolabs.domain;

/**
 * Created by @mriso_dev on 23/08/17.
 */
public enum Money {
    TEN(10), TWENTY(20), FIFTY(50), HUNDRED(100);

    private int value;

    Money(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
