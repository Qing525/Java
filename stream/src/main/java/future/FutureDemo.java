package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author : lijq
 * @date : 2019/12/16 12:50
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        Future<Integer> future = threadPool.submit(FutureDemo::doSomething, 1);
//        doSomethingElse();
//        Future<String> submit = threadPool.submit(FutureDemo::doSomethingReturn);
//        String s = submit.get();
//        System.out.println(s);
//        threadPool.shutdown();
        CompletableFuture.supplyAsync(FutureDemo::doSomethingReturn).
                thenCombine(CompletableFuture.supplyAsync(FutureDemo::doSomethingReturn1), (s1, s2) -> {
                    return Integer.parseInt(s1) + Integer.parseInt(s2);
                }).
                thenAccept(System.out::println);
    }


    public static void doSomething() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSomething");
    }

    public static void doSomethingElse() {
        System.out.println("doSomethingElse");
    }

    public static String doSomethingReturn() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "1";
    }

    public static String doSomethingReturn1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "2";
    }
}
