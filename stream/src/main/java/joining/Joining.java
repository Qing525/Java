package joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lijq
 * @date : 2019/12/16 12:08
 */
public class Joining {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3", "");

        long count = list.stream().filter(String::isEmpty).count();

        System.out.println(count);

        String collect = list.stream().filter(i -> !i.isEmpty()).collect(Collectors.joining(","));

        System.out.println(collect);
    }
}
