package cn.bdqn.gaobingfa.design.strategy;

public class Test {
private static  Fruits fruits;
private static Fruits fruits1=new Apple();
    public static void main(String[] args) {

        Shopping suguo=new SuGuo();
        suguo.setFruits(new Apple());
        System.out.println(fruits);
        System.out.println(fruits1);
        System.out.println(suguo.sell(20));

        System.out.println("*********");

        Shopping xinbai=new XinBai();
        xinbai.setFruits(new Pear());
        System.out.println(xinbai.sell(100));
    }
}
