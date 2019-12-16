package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import util.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lijq
 * @date : 2019/11/5 21:07
 */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p = new Person("zs", 11);
        Person p1 = new Person("ls", 12);
        list.add(p);
        list.add(p1);
        // {"age":11,"name":"zs"}
        String s = JSON.toJSONString(p);
        System.out.println(JSON.toJSONString(list));

        System.out.println(JSON.parseObject(s, Person.class));

        JSONObject j = (JSONObject) JSON.toJSON(p);
        System.out.println(j.getString("name"));

        Person person = JSON.toJavaObject(j, Person.class);
        System.out.println(JSON.toJSONString(j));
    }
}
