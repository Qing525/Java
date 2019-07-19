package test;
import	java.util.Iterator;
import	java.util.SortedMap;

import	java.util.ArrayList;
import	java.util.List;

import java.util.Arrays;
import java.util.List;

/**
 * @author LJQ
 * @date 2019/7/16 9:27
 **/
public class Test2 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("hewo","world");
    list.stream().mapToInt(item->{
        int length = item.length();
        System.out.println(item);
        return length;
    }).filter(length->length==5).findFirst().ifPresent(System.out::println);

    }
}
