package cn.bdqn.gaobingfa.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ProductList extends Observable {

    //被观察者 单例

    private static ProductList  instance;//类的唯一实例

    private List<String> productListList;//产品列表


    public static ProductList getInstance(){
        if(instance==null){
            instance=new ProductList();
            instance.productListList=new ArrayList<>();
        }

        return instance;
    }

    //增加观察者，把观察者放入被观察者中
    public void addProductList(Observer observer){
        this.addObserver(observer);
    }

    //新增产品
    public void addProduct(String product){
        productListList.add(product);
        System.out.println("产品新增了产品："+product);
        this.setChanged();//设置被观察者对象发生变化
        this.notifyObservers(product);//通知观察者，并传递新产品
    }

}
