package leetcode.p20210212;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TemplateMain1 {
    static AtomicInteger val =new AtomicInteger(0);
    public static void main(String[] args) throws Exception{

        CountDownLatch countDownLatch=new CountDownLatch(20);

        Semaphore semaphore=new Semaphore(20);

        for (int i=0;i<20;i++){
            final int j=i;
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        semaphore.acquire();
                        for (int i=0;i<10;i++) {
                            Thread.sleep(5);
                            val.incrementAndGet();
                        }
                        semaphore.release();

                        countDownLatch.countDown();

                        if (j==19){
                            throw new RuntimeException("hahahhawei");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.err.println(Thread.currentThread().getName()+"===="+e);
                }
            });
            t.start();


        }

        countDownLatch.await();
        System.out.println(val);

    }




}
