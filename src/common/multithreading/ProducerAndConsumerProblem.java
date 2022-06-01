package common.multithreading;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/31
 * @time 10:17 PM
 */
public class ProducerAndConsumerProblem {

    LinkedList<Integer> list = new LinkedList<>();

    int maxLen = 100;

    int index = 1;

    public void produce() throws InterruptedException {
        synchronized (this) {
            while (list.size() == maxLen) {
                this.wait();
            }
            int t = index;
            System.out.println("add " + t);
            list.addLast(t);
            this.index=(index+1)%50;
            this.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) {
                this.wait();
            }
            System.out.println("remove " + list.removeFirst());
            this.notifyAll();
        }

    }

    public static void main(String[] args) {
        ProducerAndConsumerProblem pc = new ProducerAndConsumerProblem();
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
