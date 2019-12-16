package groupby;

import util.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : lijq
 * @date : 2019/12/16 12:08
 */
public class GroupBy {
    static Person p1 = new Person("zs", 20);
    static Person p2 = new Person("ls", 30);
    static Person p3 = new Person("ww", 40);
    static List<Person> list = Arrays.asList(p1, p2, p3);

    public static void main(String[] args) {

        Map<Integer, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getAge));

        collect.forEach((k, v) -> {

            System.out.println(k + ":" + v);
        });
        Map<Boolean, List<Person>> collect1 = list.stream().collect(Collectors.partitioningBy(i -> i.getAge() > 50));
        collect1.forEach((k, v) -> {

            System.out.println(k + ":" + v);
        });
    }

}
