package stream;

import java.util.stream.IntStream;

/**
 * @author : sin97.cn
 * @date : 2019/11/5 21:33
 */
public class Demo2 {
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 5).mapToObj(index -> "机器" + index).map(Test::new).map(Test -> (Runnable) Test::go).map(Thread::new).forEach(Thread::start);
    }
}
