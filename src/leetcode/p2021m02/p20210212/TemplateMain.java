package leetcode.p2021m02.p20210212;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TemplateMain {
    public static void main(String[] args) throws Exception{
        CyclicBarrier barrier=new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("All OK!!");
            }
        });

        Thread[] threads=new Thread[4];

        for (int i=0;i<3;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"##COME");
                    try {
                        barrier.await();
                        System.out.println(Thread.currentThread().getName()+"AWAIT##END");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }


                }
            });
            threads[i]=t;
            t.start();

        }

        System.out.println(barrier.getNumberWaiting()+","+barrier.getParties());

//        barrier.await();
        Thread.sleep(3000);
        for (int i=0;i<2;i++){

            new  Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Before "+Thread.currentThread().getName());
                        barrier.await();
                        System.out.println("Next "+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        barrier.await();
        System.out.println(barrier.getNumberWaiting()+","+barrier.getParties());
//        barrier.await();



//        barrier.await();

//        System.out.print(Thread.currentThread().getName()+"##END");



    }




}
