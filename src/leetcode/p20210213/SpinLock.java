package leetcode.p20210213;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class SpinLock {

    private AtomicReference<Thread> lock=new AtomicReference<>();

    private int number=0;

    public void lock(){
        while (true){
            if (lock.compareAndSet(null,Thread.currentThread())){
                break;
            }
        }
    }

    public void unlock(){
        while (true){
            if (lock.compareAndSet(Thread.currentThread(),null)){
                break;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        SpinLock lock=new SpinLock();
        int  len=20;
        int idx=0;
        Thread[] threads=new Thread[len];

        for (int i=0;i<len;i++){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();

                    lock.number++;

                    lock.unlock();
                }
            });
            threads[idx++]=t;
            t.start();
        }

        for (Thread t:threads){
            t.join();
        }


        System.out.println("Final:"+lock.number);

    }
}
