package com.expldfsh.appnineone;

import java.util.Observable;

public class mainModel extends Observable {

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int n) {
        value = n;
    }

    public void plusOne() {
        value++;
        this.setChanged();
        this.notifyObservers();
    }

    public void minusOne() {
        value--;
        this.setChanged();
        this.notifyObservers();
    }
}
