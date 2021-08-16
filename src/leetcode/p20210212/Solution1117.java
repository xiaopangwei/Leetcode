package leetcode.p20210212;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1117 {


    private Semaphore hSemaphore=new Semaphore(2);
    private Semaphore oSemaphore=new Semaphore(1);

    private CyclicBarrier barrier=new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
//            System.out.println("Game over");
        }
    });
    public Solution1117() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

//        while (true) {
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            hSemaphore.acquire();
            releaseHydrogen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            hSemaphore.release();
//        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {


//        while (true) {
            oSemaphore.acquire();
            releaseOxygen.run();
            try {
                barrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.


            oSemaphore.release();
//        }
    }


    public static void main(String[] args) throws Exception{

    Runnable r1=new Runnable() {
        @Override
        public void run() {
            System.out.print("H");
        }
    };
    Runnable r2=new Runnable() {
            @Override
            public void run() {
                System.out.print("O");
            }
        };

    Solution1117 solution1117=new Solution1117();
    Thread t1=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                solution1117.hydrogen(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
    Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1117.hydrogen(r1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1117.oxygen(r2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2.start();
    t1.start();

    t3.start();
    t1.join();
    t2.join();
    t3.join();



    }


}
