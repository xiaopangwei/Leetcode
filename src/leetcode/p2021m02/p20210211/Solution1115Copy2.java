package leetcode.p2021m02.p20210211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1115Copy2 {

    private int n;

    private Semaphore fooSemaphere=new Semaphore(1);
    private Semaphore barSemaphere=new Semaphore(0);


    private int i=0;
    public Solution1115Copy2(int n) {
        this.n = n;
    }

    //true
    public void foo(Runnable printFoo) throws InterruptedException {
        System.out.println("xxx"+Thread.currentThread().getName());
        for (int i=0;i<n;i++) {

            fooSemaphere.acquire();
            printFoo.run();
            barSemaphere.release();
        }
    }

    //false
    public void bar(Runnable printBar) throws InterruptedException {
        System.out.println("yyy"+Thread.currentThread().getName());
        for (int i=0;i<n;i++) {
            barSemaphere.acquire();
            printBar.run();
            fooSemaphere.release();
        }

    }

    public void A() { System.out.print(Thread.currentThread().getName()+" foo\n"); }
    public void B() { System.out.print(Thread.currentThread().getName()+" bar\n"); }


    public static void main(String[] args) throws Exception{

        Solution1115Copy2 solution1114 =new Solution1115Copy2(10);
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
