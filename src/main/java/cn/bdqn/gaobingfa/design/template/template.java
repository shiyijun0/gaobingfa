package cn.bdqn.gaobingfa.design.template;

/**
 * 烧茶和冲咖啡
 */
public abstract  class template {

    // 具体的模板方法， 要用final关键字进行修饰，避免子类进行修改
    public final void prepareBeverageTemplate(String tang,String weijing) {
        // 1, 烧开水
        shaoshui();

        // 2, 放到杯中
        daoru();

        // 加入开水
        bei();

        // 加入调味应有剂   钩子函数
        if (isCustomered()) {
            // 加入调味应有剂
            tang(tang,weijing);
        }

    }

    // 钩子函数，是否需要定置
    protected boolean isCustomered() {

        return true;
    }

    //烧水步骤一样
    private void shaoshui(){
        System.out.println("需要烧水");
    }
    //把茶或者咖啡倒入水杯，步骤不一样，去子类实现
    protected abstract void daoru();

    //把开水倒入杯中，步骤一样
    private void bei(){
        System.out.println("把开水倒入杯中");
    }
    //茶加糖，或者咖啡加入糖和味精
    protected abstract void tang(String tang,String weijing);
}
