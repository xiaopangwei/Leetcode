package common.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/30
 * @time 10:03 PM
 */
public class ABCProblem implements Runnable {

    int index = 0;

    public Lock lock = new ReentrantLock();

    public static void main(String[] args) throws Exception {
        ABCProblem abcProblem = new ABCProblem();
        Thread[]   threads    = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(abcProblem);
            threads[i].join();
            threads[i].start();
        }

        System.out.println("END");

    }


    @Override
    public void run() {

        lock.lock();
        try {
            if (index == 0) {
                System.out.println("A");
                index = 1;
            } else if (index == 1) {
                System.out.println("B");
                index = 2;
            } else {
                System.out.println("C");
                index = 0;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }

    }
}
