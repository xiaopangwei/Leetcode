package leetcode.p20210211;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1115Copy {

    private int n;

    private boolean flag=true;


    public Solution1115Copy(int n) {
        this.n = n;
    }

    //true
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (!flag){
                    this.wait();
                }
                //flag=true
                printFoo.run();
                flag=false;
                this.notifyAll();
            }


        }
    }

    //false
    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (flag) {
                    this.wait();
                }
                //flag=false
                printBar.run();
                flag=true;
                this.notifyAll();
            }
        }
    }

    public void A() { System.out.print(Thread.currentThread().getName()+" foo\n"); }
    public void B() { System.out.print(Thread.currentThread().getName()+" bar\n"); }


    public static void main(String[] args) throws Exception{

        Solution1115Copy solution1114 =new Solution1115Copy(10);
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
