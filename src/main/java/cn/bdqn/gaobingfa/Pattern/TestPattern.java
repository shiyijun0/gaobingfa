package cn.bdqn.gaobingfa.Pattern;

public class TestPattern {

    public static void main(String[] args) {
        ProductList productList=ProductList.getInstance();
        JingDong jingDong=new JingDong();
        TaoBao taoBao=new TaoBao();
        YaMaXun yaMaXun=new YaMaXun();

        //绑定观察者和被观察者关系
        productList.addProductList(jingDong);
        productList.addProductList(taoBao);
        productList.addProductList(yaMaXun);

        productList.addProduct("开发了新电动车");
    }
}
