package cn.bdqn.gaobingfa.Pattern;

import java.util.Observable;
import java.util.Observer;

public class TaoBao implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("淘宝发送新产品"+arg);
    }
}
