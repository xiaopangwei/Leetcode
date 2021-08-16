package leetcode.p20210211;

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
public class Solution1115Copy1 {

    private int n;

    private Lock lock =new ReentrantLock();

    private Condition fooCondition=lock.newCondition();

    private Condition barCondition=lock.newCondition();

    private boolean flag=true;


    public Solution1115Copy1(int n) {
        this.n = n;
    }

    //true
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try{
                while (!flag){
                    fooCondition.await();
                }
                //flag=true
                printFoo.run();
                flag=false;
                barCondition.signal();
            }
            finally {
                lock.unlock();
            }
        }
    }

    //false
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try
            {
                while (flag) {
                    barCondition.await();
                }
                //flag=false
                printBar.run();
                flag=true;
                fooCondition.signal();
            }
            finally {
                lock.unlock();
            }

        }
    }

    public void A() { System.out.print(Thread.currentThread().getName()+" foo\n"); }
    public void B() { System.out.print(Thread.currentThread().getName()+" bar\n"); }


    public static void main(String[] args) throws Exception{

        Solution1115Copy1 solution1114 =new Solution1115Copy1(10);
        Runnable barRunnable=new Runnable() {
            @Override
            public void run() {

                try {
                    solution1114.foo(new Runnable() {
                        @Override
                        public void run() {
                            solution1114.A();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable fooRunnable=new Runnable() {
            @Override
            public void run() {
                try {
                    solution1114.bar(new Runnable() {
                        @Override
                        public void run() {
                            solution1114.B();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };



        ExecutorService executorService=Executors.newFixedThreadPool(2);
        executorService.submit(fooRunnable);
        executorService.submit(barRunnable);

    }
}
