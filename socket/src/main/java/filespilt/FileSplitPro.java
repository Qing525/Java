package filespilt;

import java.io.*;
import java.util.Properties;
import java.util.UUID;

/**
 * @author LJQ
 * @date 2019/7/22 11:14
 * 加入配置文件
 **/
public class FileSplitPro {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\Downloads\\BANDIZIP-SETUP_6.24.0.1.EXE");
        File splitDir = new File("D:\\test");
        spilt(file, splitDir);
    }

    private static void spilt(File file, File splitDir) throws IOException {
        InputStream in = new FileInputStream(file);
        if (!splitDir.exists()) {
            splitDir.mkdirs();
        }
        byte[] bytes = new byte[1024 * 1024];
        OutputStream out = null;
        int count=1;
        while (in.read(bytes) != -1) {
            out = new FileOutputStream(new File(splitDir,count++  +".part"));
            out.write(bytes);
            out.close();
        }
        out=new FileOutputStream(new File(splitDir,"c.conf"));
        Properties prop = new Properties();
        prop.setProperty("fileName",file.getName());
        prop.setProperty("count",count+"");
        prop.store(out,"---------------");
        out.close();
        in.close();
    }

}
