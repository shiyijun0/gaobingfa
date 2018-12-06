package cn.bdqn.gaobingfa.design.decorator;

public class TestDe {
    decorator decorator=new decorator() { //匿名类
        @Override
        public void prinnt() {
            System.out.println("***************778");
        }
    };

    decorator decorator1=() -> System.out.println("lamdfd表达式");
    public static void main(String[] args) {
        TestDe testDe=new TestDe();
        testDe.decorator.prinnt();
        System.out.println("***********");
testDe.decorator1.prinnt();

Target target=new Target();
        cn.bdqn.gaobingfa.design.decorator.decorator s=new De1(new De2(target));
        s.prinnt();
    }
}
