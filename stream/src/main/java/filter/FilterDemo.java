package filter;

import util.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author L J Q
 * @date 2019/07/15
 **/
public class FilterDemo {
  static   Person p1=new Person("zs",20);
  static   Person p2=new Person("ls",30);
   static Person p3=new Person("ww",40);
   static List<Person> list= Arrays.asList(p1,p2,p3);
    public static void main(String[] args) {

        List<Person> list = get("z1", FilterDemo.list);
        list.forEach(System.out::println);
        List<Person> list1 = getAge( FilterDemo.list);
        list1.forEach(System.out::println);

    }
    public static List<Person> get(String  name, List<Person> p){

        return list.stream().filter(person ->person.getName().equals(name)
            ).collect(Collectors.toList());
    }
    public static List<Person> getAge(List<Person> p){

        return list.stream().filter(person ->person.getAge()>21
        ).collect(Collectors.toList());
    }
}
