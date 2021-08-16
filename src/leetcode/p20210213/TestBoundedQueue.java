package leetcode.p20210213;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/13
 * @time 4:00 PM
 */
public class TestBoundedQueue {

    private int n;
    public AtomicInteger head=new AtomicInteger(0);
    public AtomicInteger tail=new AtomicInteger(0);


    public volatile int[] array;

    public TestBoundedQueue(int n){
        this.n=n;
        array=new int[n];
    }

    public void enqueue(int x){
        while (true) {
            int lastTail=tail.get();
            int newTail=(lastTail+1)%n;

            if (newTail==head.get()){
//                System.out.println("Blocking enqueue");
                continue;
            }
            if (tail.compareAndSet(lastTail,newTail)){
                System.out.println("Enqueue:"+lastTail);
                array[newTail]=x;

                return;
            }


        }
    }


    public int dequeue(){

        while (true) {
            int lastHead=head.get();
            int newHead=(lastHead+1)%n;
            if (newHead==tail.get())
            {
//                System.out.println("Blocking dequeue");
                continue;
            }
            if (head.compareAndSet(lastHead,newHead)){
                System.out.println("Dequeue:"+lastHead);
              return array[lastHead];
            }


        }
    }


    public static void main(String[] args) throws Exception{
        TestBoundedQueue queue=new TestBoundedQueue(5);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++)
                {
                    queue.enqueue(i);
                }


            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++)
                {
                    queue.dequeue();
                }
            }
        });

        t1.start();

        t2.start();

        t1.join();

        t2.join();

    }
}
