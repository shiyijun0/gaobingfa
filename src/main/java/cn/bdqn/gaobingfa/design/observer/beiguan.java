package cn.bdqn.gaobingfa.design.observer;

public interface beiguan {
     void registerObserver(guancha o);
     void removeObserver(guancha o);
     void notifyObserver();
}
