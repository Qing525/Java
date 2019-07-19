package predicate;
import java.util.Arrays;
import	java.util.Iterator;
import	java.util.List;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author LJQ
 * @date 2019/7/15 14:26
 **/
public class PredicateDemo {
    public static void main(String[] args) {
        List<Integer>list= Arrays.asList(1,2,3,4,5,6,7,8,9);
        PredicateDemo.condition(list,value->value>5);

    }
    public static void condition(List<Integer>list, Predicate<Integer>predicate ){
        for (Integer integer : list) {
            if (predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }
}
