package supplier;

import util.Person;

import java.util.function.Supplier;

/**
 * @author LJQ
 * @date 2019/7/15 15:00
 **/
public class SupplierDemo {
    public static void main(String[] args) {
        //1.不接收参数
        //2. 返回一个结果
        Supplier<Person> supplier=Person::new;

    }


}
