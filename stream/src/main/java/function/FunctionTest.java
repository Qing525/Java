package function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.append(2, value -> String.valueOf(value + "------")));

        System.out.println(test.compute(3,value->value*2,value->value*value));
        System.out.println(test.compute2(3,value->value*2,value->value*value));
        System.out.println(test.compute3(2,3,(a,b)->a+b));
        System.out.println(test.compute4(2,3,(a,b)->a+b,value-> value*3));

    }

    private String append(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    private int compute(int a, Function<Integer, Integer> f1, Function<Integer, Integer> before) {
        // 先执行 compose 后的
        return f1.compose(before).apply(a);
    }

    private int compute2(int a, Function<Integer, Integer> f1, Function<Integer, Integer> after) {
        // 先执行 andThen 前的
        return f1.andThen(after).apply(a);
    }
    private int compute3(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        //可以传两个参数
        return biFunction.apply(a,b);
    }
    private int compute4(int a,int b,BiFunction<Integer,Integer,Integer>biFunction,Function<Integer,Integer>function){

        return  biFunction.andThen(function).apply(a,b);
    }

}