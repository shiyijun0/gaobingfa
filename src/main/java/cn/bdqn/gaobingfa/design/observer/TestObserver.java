package cn.bdqn.gaobingfa.design.observer;

public class TestObserver {
    public static void main(String[] args) {
        Observed observed=new Observed();
     JingDong jingDong=   new JingDong(observed);
     TaoBao taoBao=new TaoBao(observed);
        observed.setData(20);
        System.out.println("***********");
        observed.deleteObserver(jingDong);
        observed.setData(10);

        beigualei beiguan=new beigualei();
        guancha guancha=new guachalei("dfgf");
        guancha guancha1=new guachalei("tghh");
        guancha guancha2=new guachalei("tgh56h");
        beiguan.registerObserver(guancha);
        beiguan.registerObserver(guancha1);
        beiguan.registerObserver(guancha2);
        beiguan.registerObserver(guancha1);
        beiguan.setInfomation("辅导费");
    }
}
