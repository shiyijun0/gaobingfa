package cn.bdqn.gaobingfa;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class PaiXu {
    static void aVoid(int[] arr){
        int len=arr.length;
        for (int i=1;i<len;i++){
            for (int j=0;j<len-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }

    static void b(int[] arr){
        int len=arr.length;
        for (int i=1;i<len;i++){
            int index=0;
            for (int j=1;j<=len-i;j++){
                if(arr[j]>arr[index]){
                    index=j;
                }
            }
             int tmp=arr[len-i];
            arr[len-i]=arr[index];
            arr[index]=tmp;

        }
    }
    public static void main(String[] args) {
        int[] arr={3,7,34,3,65,45};
       // aVoid(arr);
       b(arr);
        for (int a:arr){
            System.out.print(a+"\t");
        }

        Collections.synchronizedList(Arrays.asList(arr));
        CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(3);
        int d=9;
        copyOnWriteArrayList.add(d);

    }
}
