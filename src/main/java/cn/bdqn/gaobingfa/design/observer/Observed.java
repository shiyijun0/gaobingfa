package cn.bdqn.gaobingfa.design.observer;

import java.util.Observable;

//被观察者
public class Observed extends Observable{
    private int data=0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        if(this.data!=data){
            this.data = data;
            setChanged();
            this.notifyObservers();//只有改变，然后通知所有的观察者
        }

    }


}
