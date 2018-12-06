package cn.bdqn.gaobingfa.design.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class beigualei implements beiguan {
private String message;
    Set<guancha> set=new HashSet<>();
    private List<guancha> list;
    public beigualei() {
        list=new ArrayList<>();
    }

    @Override
    public void registerObserver(guancha o) {
        if(set.add(o)) {
            list.add(o);
        }
    }

    @Override
    public void removeObserver(guancha o) {
if(list.size()>0){
    list.remove(o);
}
    }

    @Override
    public void notifyObserver() {
     for (guancha guancha:list){
         guancha.update(message);
     }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }
}
