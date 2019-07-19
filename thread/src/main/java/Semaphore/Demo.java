package Semaphore;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程名称-%s").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
        Semaphore semaphore = new Semaphore(15);

        for (int i = 0; i < 30; i++) {

            int finalI = i;
            executor.submit(() -> {

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                semaphore.acquire(1);

                    System.out.println("-----------" + finalI);

                    semaphore.release(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        executor.shutdown();

    }

}
