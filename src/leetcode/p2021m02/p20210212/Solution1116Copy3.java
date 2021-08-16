package leetcode.p2021m02.p20210212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1116Copy3 {
    private int n;


    public Solution1116Copy3(int n) {
        this.n = n;
    }


    private Lock lock =new ReentrantLock();

    private Condition zeroCondition=lock.newCondition();

    private Condition oddCondition=lock.newCondition();

    private Condition evenCondition=lock.newCondition();

    //1 -> zero
    //2 -> odd
    //3 -> even
    public int flag=1;

    private boolean oddOrEven=true;

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++){

                lock.lock();
                try {
                    while (flag!=1){
                        zeroCondition.await();
                    }
                    printNumber.accept(0);
                    if (oddOrEven) {
                        flag = 2;
                        oddCondition.signalAll();
                    } else {
                        flag = 3;
                        evenCondition.signalAll();
                    }
                }
                finally {
                    lock.unlock();
                }

            }
    }


    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            lock.lock();
            try {
                while (flag!=2){
                    oddCondition.await();
                }
                printNumber.accept(i);
                oddOrEven=!oddOrEven;
                flag=1;
                zeroCondition.signalAll();
            }
            finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i=2;i<=n;i+=2){
            lock.lock();
            try {
                while (flag!=3){
                    evenCondition.await();
                }
                printNumber.accept(i);
                oddOrEven=!oddOrEven;
                flag=1;
                zeroCondition.signalAll();
            }
            finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args){
        IntConsumer consumer=new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        Solution1116Copy3 solution1116 =new Solution1116Copy3(10);
        ExecutorService   executors    =Executors.newFixedThreadPool(3);
        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1116.zero(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1116.even(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1116.odd(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
