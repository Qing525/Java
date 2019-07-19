package stream;


import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author LJQ
 * @date 2019/7/15 17:16
 **/
public class Demo {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.iterate(1, integer -> integer + 2).limit(6);

        System.out.println(
                stream.filter(value -> value > 2)
                        .mapToInt(value -> value * 2)
                        .skip(2)
                        .limit(2)
                        .summaryStatistics().getMax()
                        );
    }




}
