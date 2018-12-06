package cn.bdqn.gaobingfa.design.decorator;

public class De1 implements decorator {

    private decorator decorator;

    public De1(decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void prinnt() {
        System.out.println("****装修1前******");
        decorator.prinnt();
        System.out.println("****装修1后******");
    }
}
