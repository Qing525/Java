package ThreadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程名称-%s").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                threadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int finalI = i;

            new Thread(() -> executor.submit(() -> {

                System.out.println(Thread.currentThread().getName() + "------" + finalI);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            })).start();
        }
        executor.shutdown();

         /*   int finalI = i;

            executor.submit(() -> System.out.println(Thread.currentThread().getName() + "------" + finalI));*/
    }


}

