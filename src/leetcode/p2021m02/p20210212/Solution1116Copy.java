package leetcode.p2021m02.p20210212;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1116Copy {
    private int n;
    //奇数
    private volatile boolean zeroFlag=true;
    private volatile boolean oddFlag=false;
    private volatile boolean evenFlag=false;

    private volatile boolean oddOrEven=true;

    public Solution1116Copy(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0;i<n;i++){
            while (!zeroFlag){
                Thread.yield();
            }

            printNumber.accept(0);
            if (oddOrEven){
                oddFlag=true;
            }
            else{
                evenFlag=true;
            }

            zeroFlag=!zeroFlag;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            while (!oddFlag){
                Thread.yield();
            }

            printNumber.accept(i);
            oddOrEven=false;
            oddFlag=!oddFlag;
            zeroFlag=true;
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {

        for (int i=2;i<=n;i+=2){
            while (!evenFlag){
                Thread.yield();
            }

            printNumber.accept(i);
            oddOrEven=true;
            evenFlag=!evenFlag;
            zeroFlag=true;

        }
    }

    public static void main(String[] args){
        IntConsumer consumer=new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        Solution1116Copy solution1116 =new Solution1116Copy(10);
        ExecutorService  executors    =Executors.newFixedThreadPool(3);
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
