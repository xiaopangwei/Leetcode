package leetcode.p2021m02.p20210212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1116 {
    private int n;
    //奇数
    private boolean flag=true;

    private Semaphore zeroSemaphore=new Semaphore(1);
    private Semaphore oddSemaphore=new Semaphore(0);
    private Semaphore evenSemaphore=new Semaphore(0);

    public Solution1116(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (flag){
               oddSemaphore.release();
            }
            else{
                evenSemaphore.release();
            }

        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            flag=!flag;
            zeroSemaphore.release();
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            flag=!flag;
            zeroSemaphore.release();
        }

    }

    public static void main(String[] args){
        IntConsumer consumer=new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        Solution1116 solution1116=new Solution1116(10);
        ExecutorService executors=Executors.newFixedThreadPool(3);
        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1116.zero(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1116.even(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        executors.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1116.odd(consumer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
