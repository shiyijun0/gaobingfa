package cn.bdqn.gaobingfa.Pattern;

import java.util.Observable;
import java.util.Observer;

public class JingDong implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("京东发送新产品到库存"+arg);
    }
}
