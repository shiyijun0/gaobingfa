package cn.bdqn.gaobingfa.Pattern;

import java.util.Observable;
import java.util.Observer;

public class YaMaXun implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("亚马逊发送新产品"+arg);
    }
}
