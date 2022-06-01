package common.multithreading;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/31
 * @time 10:17 PM
 */
public class ProducerAndConsumerProblem1 {

    LinkedList<Integer> list = new LinkedList<>();

    int maxLen = 100;

    int index = 1;

    Lock lock = new ReentrantLock();

    Condition fullCondition  = lock.newCondition();
    Condition emptyCondition = lock.newCondition();

    public void produce() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == maxLen) {
                fullCondition.await();
            }
            int t = index;
            list.addLast(t);
            System.out.println("produce "+t);
            this.index = (index+1) % maxLen;
            emptyCondition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == 0) {
                emptyCondition.await();
            }
            System.out.println("consume "+list.removeFirst());
            fullCondition.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        ProducerAndConsumerProblem1 pc = new ProducerAndConsumerProblem1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        pc.produce();
                        Thread.sleep(20);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        pc.consume();
                        Thread.sleep(30);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        while (true) ;
    }
}
