package common.multithreading;

import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/31
 * @time 10:17 PM
 */
public class ProducerAndConsumerProblem2 {

    BlockingDeque<Integer> blockingDeque=new LinkedBlockingDeque<>();

    int maxLen = 100;

    int index = 1;

    public void produce() throws InterruptedException {

    }

    public void consume() throws InterruptedException {


    }

    public static void main(String[] args) {
        ProducerAndConsumerProblem2 pc = new ProducerAndConsumerProblem2();
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
