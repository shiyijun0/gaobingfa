package cn.bdqn.gaobingfa.design.observer;

import java.util.Observable;
import java.util.Observer;

public class JingDong implements Observer {

  public JingDong(Observed observed) {
        observed.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("**京东****"+((Observed)o).getData()+"*********"+arg);
    }
}
