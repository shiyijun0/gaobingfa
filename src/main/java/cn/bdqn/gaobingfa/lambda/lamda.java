package cn.bdqn.gaobingfa.lambda;

import java.util.Arrays;
import java.util.List;

public class lamda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("电饭锅")).start();

        List<String> languages = Arrays.asList("java","scala","python");
        //before java8
        for(String each:languages) {
            System.out.println(each);
        }
        languages.forEach(s -> System.out.println(s));
        languages.forEach(System.out::println);

        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
        cost.stream().map(x -> x + x*0.05).forEach(x -> System.out.println(x));

    }
}
