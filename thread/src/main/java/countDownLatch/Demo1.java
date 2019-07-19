package countDownLatch;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Demo1 {

   static   CountDownLatch latch=new CountDownLatch(2);

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("线程-%s").build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 6, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3),
                threadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i <2 ; i++) {
            int finalI = i;
            pool.submit(()->{
                try {
                    System.out.println("进入线程");
                    try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
                    latch.await();
                    System.out.println("Done!!"+ finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        }


        pool.submit(()->{
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            latch.countDown();
        });

        pool.submit(()-> System.out.println(4));

        pool.submit(()->{
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            latch.countDown();
        });


        pool.shutdown();
    }


}
