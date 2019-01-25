package cn.bdqn.gaobingfa;

import java.io.File;

public class InputLiu {
    public static void main(String[] args) throws Exception {
        File file=new File("F:\\zhihui\\github\\gaobingfa\\src\\main\\resources\\syj.txt");
        if(!file.exists()){
            file.createNewFile();
            System.out.println(file.getName()+"******"+file.getPath());
        }else {
            System.out.println(file.getName()+"******"+file.getPath());
            //file.delete();
        }

      
    }
}
