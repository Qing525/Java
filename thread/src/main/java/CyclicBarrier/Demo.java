package CyclicBarrier;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Random;
import java.util.concurrent.*;

public class Demo {

    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程-%s").build();

        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 6, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());

        /**
         *   达到最大线程数时，停止进入
         *
         */
        for (int i = 1; i < 10; i++) {

            int finalI = i;
            int finalI1 = i;
            pool.submit(() -> {
                try {
                    System.out.println("进入线程" + finalI);
                    TimeUnit.SECONDS.sleep(2);
                    cyclicBarrier.await();
                    System.out.println("线程" + finalI1 + "结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();


    }


}
