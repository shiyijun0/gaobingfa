package cn.bdqn.gaobingfa.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OrderImpl extends UnicastRemoteObject implements Iorder {
    protected OrderImpl() throws RemoteException{
        super();
    }

    @Override
    public String pay(String id) throws RemoteException {
        return "支付成功，返回："+id;
    }
}
