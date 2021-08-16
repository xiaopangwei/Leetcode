package leetcode.p2021m02.p20210226;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/23
 * @time 11:22 AM
 */
public class Template {

    static int a=10;

    static CountDownLatch countDownLatch=new CountDownLatch(20);
    Lock lock=new ReentrantLock();
    public void increse(){
        lock.lock();
        try {

            a++;
        }
        finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Template template=new Template();

        for (int i=0;i<20;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<100;i++) {
                        try {
                            Thread.sleep(new Random().nextInt(3));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        template.increse();
                    }
                    countDownLatch.countDown();
                }
            });
            t.start();
        }

        countDownLatch.await();

        System.out.println(a);


    }
}
