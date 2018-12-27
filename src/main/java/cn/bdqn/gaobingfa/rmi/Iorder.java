package cn.bdqn.gaobingfa.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Iorder extends Remote {
    public String pay(String id) throws RemoteException;
}
