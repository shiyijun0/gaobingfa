package cn.bdqn.gaobingfa.design.AbstrctFactory;

public class TestAbreact {
    public static void main(String[] args) {
        AbstrctFactory abstrctFactory=new AoDechouxiang();
        abstrctFactory.factory().produce();
        abstrctFactory.bag().pack();

    }
}
