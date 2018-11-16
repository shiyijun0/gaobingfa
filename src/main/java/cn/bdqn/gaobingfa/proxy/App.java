package cn.bdqn.gaobingfa.proxy;

public class App {

    public static void main( String[] args )
    {
        Business businessImp=new BusinessImp();
        BusinessInvocationHandler businessInvocationHandler=new BusinessInvocationHandler(businessImp);
        Business businessProxy=(Business)businessInvocationHandler.getProxy();
        businessProxy.execute();



    }

}
