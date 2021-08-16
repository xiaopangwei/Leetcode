package leetcode.p2021m02.p20210212;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1195 {

    private int n;

    private volatile int flag=4;

    private AtomicInteger num=new AtomicInteger(1);

    public Solution1195(int n) {
        this.n = n;
    }

    //flag=1;
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (num.get()<=n) {
            while (flag != 1) {
                Thread.yield();
            }
            printFizz.run();
            this.flag = next();
        }

    }

    //flag=2;
    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (num.get()<=n) {
            while (flag != 2) {
                Thread.yield();
            }
            printBuzz.run();
            this.flag = next();
        }
    }
    //flag=3;
    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num.get()<=n) {
            while (flag != 3) {
                Thread.yield();
            }
            printFizzBuzz.run();
            this.flag = next();
        }
    }
    //flag=4;
    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (num.get()<=n) {
            while (flag != 4) {
                Thread.yield();
            }
            printNumber.accept(this.num.get());
            this.flag = next();
        }
    }

    public int next(){
        int current=num.addAndGet(1);
        int n=current;
        if (current>this.n){
            System.exit(0);
        }
        if (n%3==0 && n%5!=0){
            return 1;
        }
        else if (n%5==0 && n%3!=0){
            return 2;
        }
        else if (n%5==0 && n%3==0){
            return 3;
        }
        return 4;
    }

    public static void main(String[] args) throws Exception{

        Runnable printFizz=new Runnable() {
            @Override
            public void run() {
                System.out.println("fizz");
            }
        };

        Runnable printBuzz=new Runnable() {
            @Override
            public void run() {
                System.out.println("buzz");
            }
        };


        Runnable printFizzbuzz=new Runnable() {
            @Override
            public void run() {
                System.out.println("fizzbuzz");
            }
        };


        IntConsumer printNumber=new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        };

        Solution1195 solution1195=new Solution1195(15);

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1195.fizz(printFizz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1195.buzz(printBuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1195.fizzbuzz(printFizzbuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    solution1195.number(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();




    }
}

