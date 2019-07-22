package jsonToString;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LJQ
 * @date 2019/7/22 13:26
 **/
public class JsonToString {
    public static void main(String[] args) throws IOException {
        String s = FileUtils.readFileToString(new File("E:\\study\\Java\\socket\\src\\main\\resources\\1.json"), "UTF-8");

        InputStream inputStream = JsonToString.class.getClassLoader().getResourceAsStream("1.json");
        byte[] bytes = new byte[10];
        StringBuffer sb = new StringBuffer();
        while (inputStream.read(bytes) != -1) {
            String s1 = new String(bytes);
            sb.append(s1);
        }
        JSONObject jsonObject = new JSONObject(sb.toString());
        System.out.println(jsonObject);

        //System.out.println(s);


    }
}
