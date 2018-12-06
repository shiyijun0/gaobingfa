package cn.bdqn.gaobingfa.design.template;

public class TestTemplate {
    public static void main(String[] args) {

        template coffee=new Coffee();
        template tea=new Tea();

        coffee.prepareBeverageTemplate("糖","味精");
        System.out.println("**********");
        tea.prepareBeverageTemplate("糖","味精");

    }
}
