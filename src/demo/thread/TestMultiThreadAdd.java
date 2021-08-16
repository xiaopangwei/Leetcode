package demo.thread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/19
 * @time 9:38 AM
 */
public class TestMultiThreadAdd {

    public int sum=0;
    private Lock lock=new ReentrantLock();

    public void add(){
        lock.lock();
        sum++;
        lock.unlock();

    }


    public static void main(String[] args) throws Exception{
        TestMultiThreadAdd testMultiThreadAdd=new TestMultiThreadAdd();
        for (int i=0;i<10000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    int random=new Random(3).nextInt(30);
                    try {
                        Thread.sleep(random);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    testMultiThreadAdd.add();
                }
            }).start();
        }

        Thread.sleep(10*1000);
        System.out.println(testMultiThreadAdd.sum);
    }
}
