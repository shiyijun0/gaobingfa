package cn.bdqn.gaobingfa.pagePark;

/**
 * @program: gaobingfa
 * @description: 排序
 * @author: shiyijun
 * @create: 2019-01-26 22:29
 **/
public class Pank {

    public static void arr(int[] arr){
        int len=arr.length;
        for (int i=1;i<len;i++){
            for (int j=0;j<len-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void xuanze(int[] arr){
        int len=arr.length;
        int index;
        for (int i=1;i<len;i++){
             index=0;
            for (int j=1;j<=len-i;j++){
                if(arr[j]>arr[index]){
                    index=j;
                }


            }

            int tem=arr[len-i];
            arr[len-i]=arr[index];
            arr[index]=tem;
        }
    }


    public static void main(String[] args) {
        int[] arr={3,6,2,34,23};
        int[] arr1=new int[]{5,2,56,34,12};
        //arr(arr1);
        xuanze(arr1);

        for (int a:arr1){
            System.out.print(a+"\t");
        }
    }
}
