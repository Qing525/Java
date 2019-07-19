package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LJQ
 * @date 2019/7/16 10:16
 **/
public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> list1= Arrays.asList("hi ss","helo ss","ss hello");
        List<String> list2= Arrays.asList("zs","ls","ss");
    list1.stream().flatMap(item->list2.stream().map(value->item+" "+value)).collect(Collectors.toList()).forEach(System.out::println);

    list1.stream().map(item->item.split(" ")).flatMap(Arrays::stream).distinct() .collect(Collectors.toList()).forEach(System.out::println);
}
}
