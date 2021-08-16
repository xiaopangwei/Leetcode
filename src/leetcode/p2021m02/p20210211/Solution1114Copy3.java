package leetcode.p2021m02.p20210211;

import java.util.concurrent.CountDownLatch;
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
public class Solution1114Copy3 {

    private CountDownLatch c1=new CountDownLatch(1);
    private CountDownLatch c2=new CountDownLatch(1);

    public Solution1114Copy3() {

    }


    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        c1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        c1.await();
        printSecond.run();
        c2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException{


        c2.await();
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
         Solution1114Copy3 solution1114 =new Solution1114Copy3();

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
