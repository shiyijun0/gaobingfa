package cn.bdqn.gaobingfa.rmi.rpc;

/**
 * 暴露服务
 */
public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcExport.export(service);
    }


}
