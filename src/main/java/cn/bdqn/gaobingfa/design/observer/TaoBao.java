package cn.bdqn.gaobingfa.design.observer;

import java.util.Observable;
import java.util.Observer;

public class TaoBao  implements Observer{

    public TaoBao(Observed observed) {
        observed.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("***淘宝***"+((Observed)o).getData()+"*********"+arg);
    }
}
