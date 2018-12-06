package cn.bdqn.gaobingfa.design.strategy;

public abstract class Shopping {
private Fruits fruits;

    public void setFruits(Fruits fruits) {
        this.fruits = fruits;
    }

    public String sell(int price){
        if(this.fruits==null)
            return "没有水果可以卖";
       return this.fruits.sell(price);
    }

    protected abstract void  eate();

    protected  void wan(){
        System.out.println("每个水果都可以玩");
    }

    public Shopping() {
    }

}
