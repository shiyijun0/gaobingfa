package cn.bdqn.gaobingfa.Pattern;
//目标对象
public class JdkDaoImpl implements JdkDao {
    @Override
    public void jdk() {
        System.out.println("目标对象方法");
    }

    @Override
    public void jdk(String name) {
        System.out.println("目标对象方法"+name);
    }
}
