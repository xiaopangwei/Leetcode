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
public class Solution1114 {


    private boolean first2Second=false;
    private boolean second2Third=false;

    public Solution1114() {

    }


    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this)
        {
            printFirst.run();
            this.notifyAll();
            first2Second=true;
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (this) {
            while (!first2Second){
                this.wait();
            }

            printSecond.run();

            this.notifyAll();
            first2Second=false;
            second2Third=true;
        }
    }

    public void third(Runnable printThird) throws InterruptedException{

        synchronized (this) {

            while (!second2Third){
                this.wait();
            }
            printThird.run();
            this.notifyAll();
            second2Third=false;
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
         Solution1114 solution1114=new Solution1114();

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
