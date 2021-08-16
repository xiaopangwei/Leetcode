package leetcode.p20210212;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/12
 * @time 5:58 PM
 */
public class NotifyAndWaitTest {


    private int max=5;
    private Queue<Integer> data =new LinkedList<>();

    public synchronized void produce() throws InterruptedException{
//        System.out.println("ENTER produce");
        if (data.size()==max){
            System.out.println("Blocking produce");
            this.wait();
        }

        data.add(new Random().nextInt(10));

        this.notifyAll();
    }

    public synchronized void consume() throws InterruptedException{
//        System.out.println("ENTER consume");

        if (data.size()==0){
            System.out.println("Blocking consume");
            this.wait();
        }

        System.out.println(data.remove());

        this.notifyAll();
    }


    public static void main(String[] args) throws Exception {
        NotifyAndWaitTest test=new NotifyAndWaitTest();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        test.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread t2=new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i=0;i<50;i++) {
                    try {
                        test.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t2.start();

    }

}
