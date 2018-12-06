package cn.bdqn.gaobingfa.design.decorator;

public class De2 implements decorator {

    private decorator decorator;

    public De2(decorator decorator) {
        this.decorator = decorator;
    }

    @Override
    public void prinnt() {
        System.out.println("****装修2前******");
        decorator.prinnt();
        System.out.println("****装修2后******");
    }
}
