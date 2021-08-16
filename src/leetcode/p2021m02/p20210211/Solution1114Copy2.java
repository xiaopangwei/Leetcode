package leetcode.p2021m02.p20210211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1114Copy2 {


    private int number=1;
    private Lock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();

    public Solution1114Copy2() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            printFirst.run();
            condition1.signal();
            number=2;
        }
        finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        lock.lock();
        try{
            while (number!=2){
                condition1.await();
            }
            printSecond.run();
            number=3;
            condition2.signal();

        }
        finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException{


        lock.lock();
        try{
            while (number!=3){
                condition2.await();
            }
            printThird.run();
        }
        finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) throws Exception{

        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };

        Runnable r2=new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
            }
        };

        Runnable r3=new Runnable() {
            @Override
            public void run() {
                System.out.println("3");
            }
        };
         Solution1114Copy2 solution1114 =new Solution1114Copy2();

        ExecutorService executorService=Executors.newFixedThreadPool(3);
        

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1114.third(r3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {

                try {
                    solution1114.first(r1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1114.second(r2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
