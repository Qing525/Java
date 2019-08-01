import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LJQ
 * @date 2019/7/25 12:50
 *   统计文件夹大小
 **/
public class DirSize {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    public static void main(String[] args) throws InterruptedException {
        ShareData shareData = new ShareData();
        ReentrantLock lock = new ReentrantLock();
        new Thread(new T1(shareData, "D:\\test\\1", lock)).start();
        new Thread(new T1(shareData, "D:\\test\\2", lock)).start();
        new Thread(new T1(shareData, "D:\\test\\3", lock)).start();
        countDownLatch.await();
        new Thread(new SumThread(shareData)).start();
    }

    static class SumThread implements Runnable {
        private ShareData shareData;

        public SumThread(ShareData shareData) {
            this.shareData = shareData;
        }

        @Override
        public void run() {
            System.out.println(shareData.getTotalSize());
        }
    }

    static class T1 implements Runnable {
        private ShareData shareData;
        private String dirPath;
        private ReentrantLock lock;

        public T1(ShareData shareData, String dirPath, ReentrantLock lock) {
            this.shareData = shareData;
            this.dirPath = dirPath;
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                shareData.add(FileUtils.sizeOfDirectory(new File(dirPath)));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
                lock.unlock();
            }
        }
    }

    static class ShareData {
        private long totalSize;

        public void add(long size) {
            totalSize += size;
        }

        public long getTotalSize() {
            return totalSize;
        }
    }

}
