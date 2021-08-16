package leetcode.p2021m02.p20210211;

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
public class Solution1114Copy1 {


    private volatile boolean first2Second=false;
    private volatile boolean second2Third=false;

    public Solution1114Copy1() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        first2Second=true;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (!first2Second){
            Thread.yield();
        }

        printSecond.run();
        second2Third=true;


    }

    public void third(Runnable printThird) throws InterruptedException{

        while (!second2Third){
            Thread.yield();
        }

        printThird.run();
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
         Solution1114Copy1 solution1114 =new Solution1114Copy1();

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
