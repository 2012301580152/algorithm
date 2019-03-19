package whu.hydro.algorithm.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName CAS
 * @Description TODO
 * @Author 86187
 * @Date 2019/3/15 16:45
 * @Version 1.0
 */



public class CAS {

    static AtomicLong k = new AtomicLong(0);
//    volatile static int k = 0;
    public static void add() throws InterruptedException {
//        Thread.sleep(10);
        k.addAndGet(1);
//        k.getAndAdd(1);
//        k++;
    }

    private static class Plus implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        Executor executor = new ThreadPoolExecutor(5,20,1,);
        ExecutorService executorService = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 10; i++) {
            executorService.execute(new Plus());
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {

        }


        System.out.println(k);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

//        AtomicLong
    }
}
