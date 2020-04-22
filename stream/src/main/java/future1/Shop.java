package future1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author : lijq
 * @date : 2019/12/15 14:49
 */
@Data
@AllArgsConstructor
public class Shop {

    String name;

    public static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getPrice(String name) {
        delay();
        Discount discount = Discount.values()[new Random().nextInt(Discount.values().length)];
        return String.format("%s:%.2f:%s", getName(), new Random().nextDouble() * 100, discount);
    }

    public Future<String> getPriceAsync(String name) {
        return CompletableFuture.supplyAsync(() -> getPrice(name));
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Shop shop = new Shop("Best");

        long start = System.currentTimeMillis();

        Future<String> mao = shop.getPriceAsync("毛巾");

        System.out.println("调用返回耗时" + (System.currentTimeMillis() - start));

        String s = mao.get();

        System.out.println("价格返回耗时" + (System.currentTimeMillis() - start));
    }


}
