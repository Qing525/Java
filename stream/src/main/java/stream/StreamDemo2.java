package stream;
import java.util.ArrayList;
import	java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author LJQ
 * @date 2019/7/15 16:16
 **/
public class StreamDemo2 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,5,9);
        System.out.println(list.stream().map(value->value*2).reduce(0,Integer::sum));

        Stream<String> stream = Stream.of("s", "h", "A");

        //stream.collect(()->new ArrayList<String>(),(list0, s) ->list0.add(s),(list1,list2)->list1.addAll(list2) ).forEach(System.out::println);

        stream.collect(ArrayList::new,ArrayList::add,ArrayList::addAll).forEach(System.out::println);
    }
}
