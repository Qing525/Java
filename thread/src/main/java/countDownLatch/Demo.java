package countDownLatch;

import java.util.Random;
import java.util.concurrent.*;

public class Demo implements Runnable {

    static CountDownLatch latch = new CountDownLatch(5);
    static Demo demo = new Demo();

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(10) * 1000);
            System.out.println("check complete");

            //计数减一

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 4; i++) {

            threadPool.submit(demo);

        }
        System.out.println(1);

        latch.await();


        System.out.println("Done!!");

        threadPool.shutdown();

    }


}