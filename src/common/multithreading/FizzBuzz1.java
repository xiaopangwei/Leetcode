package common.multithreading;

import java.util.function.IntConsumer;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/30
 * @time 10:38 PM
 */
public class FizzBuzz1 {
    private int n;

    volatile int i=1;

    public FizzBuzz1(int n) {
        this.n = n;
    }

    //3
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    //5
    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 5 == 0 && i % 3 != 0) {
                    printBuzz.run();
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }


    //15
    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 15 == 0) {
                    printFizzBuzz.run();
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 15 == 0) {
                    printNumber.accept(i);
                    i++;
                    this.notifyAll();
                } else {
                    this.wait();
                }
            }
        }
    }
}
