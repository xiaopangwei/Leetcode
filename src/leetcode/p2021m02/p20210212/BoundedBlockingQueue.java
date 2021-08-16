package leetcode.p2021m02.p20210212;

import java.util.LinkedList;
import java.util.Queue;
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
public class BoundedBlockingQueue {

    private int n;
    private Queue<Integer> data              =new LinkedList<>();
    private Lock           lock              =new ReentrantLock();
    private Condition      notFullCondition  =lock.newCondition();
    private Condition      notEmptyCondition =lock.newCondition();
    public BoundedBlockingQueue(int capacity) {
        this.n=capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {

            while (data.size()==n){
                notFullCondition.await();
            }

            data.add(element);
            notEmptyCondition.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public int dequeue() throws InterruptedException {
        int retVal;
        lock.lock();
        try {

            while (data.isEmpty()){
                notEmptyCondition.await();
            }

            retVal=data.remove();
            notFullCondition.signalAll();
        }
        finally {
            lock.unlock();
        }
        return retVal;
    }

    public int size() {
        return data.size();
    }



    public static void main(String[] args) throws Exception {
    }

}
