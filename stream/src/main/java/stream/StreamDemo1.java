package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("a","b","V");

        list.stream().map(String::toUpperCase).forEach(System.out::println);

Collections.sort(list,(o1,o2)->{
    return o2.compareTo(o1);
});

    }

}
