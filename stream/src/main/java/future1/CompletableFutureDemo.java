package future1;

import java.util.concurrent.CompletableFuture;

/**
 * @author : lijq
 * @date : 2019/12/15 14:45
 */
public class CompletableFutureDemo {

    public static void main(String[] args) {

        CompletableFuture<String> completableFuture =new CompletableFuture<>();


        CompletableFuture.supplyAsync(()->1)
                .thenApply(i->i+1) //同步执行
                .thenCombine(CompletableFuture.supplyAsync(()->2), Integer::sum)//异步执行结合返回
                .thenCompose(i->CompletableFuture.supplyAsync(()->i+3))//异步执行第二个方法
                .thenAccept(System.out::println);

    }

}
