package future1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author : lijq
 * @date : 2019/12/15 16:20
 */
public class Price {

    private List<Shop> shops = Arrays.asList(
            new Shop("shop1"),
            new Shop("shop2"),
            new Shop("shop3"),
            new Shop("shop4"),
            new Shop("shop5"),
            new Shop("shop6"),
            new Shop("shop7"),
            new Shop("shop8"),
            new Shop("shop9"),
            new Shop("shop11"),
            new Shop("shop12"),
            new Shop("shop13"),
            new Shop("shop14"),
            new Shop("shop15"),
            new Shop("shop16"),
            new Shop("shop17"),
            new Shop("shop18"),
            new Shop("shop19")
    );

    private ExecutorService executorService= Executors.newFixedThreadPool(Math.min(shops.size(),100));

    public static void main(String[] args) {
        Price price = new Price();
        long start = System.currentTimeMillis();

        System.out.println(price.findPrice("IphoneX"));

        System.out.println("耗时" + (System.currentTimeMillis() - start));

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    //
//    public List<String> findPrice(String name) {
//
//        return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(name))).collect(
//                Collectors.toList());
//
//    }
    public List<String> findPrice(String name) {

        List<CompletableFuture<String>> futures = shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(name)),executorService)).collect(
                Collectors.toList());

        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());

    }
}
