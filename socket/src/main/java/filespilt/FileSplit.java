package filespilt;

import java.io.*;
import java.util.UUID;

/**
 * @author LJQ
 * @date 2019/7/22 10:50
 * 文件拆分
 **/
public class FileSplit {

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
        while (in.read(bytes) != -1) {
            out = new FileOutputStream(new File(splitDir, UUID.randomUUID().toString() + ".part"));
            out.write(bytes);
            out.close();
        }
        in.close();
    }
}
