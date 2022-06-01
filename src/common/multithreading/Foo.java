package common.multithreading;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/30
 * @time 10:56 PM
 */
public class Foo {

    volatile int i = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        while (i != 0) {
            Thread.yield();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (i != 1) {
            Thread.yield();
        }
        printSecond.run();
        i = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (i != 1) {
            Thread.yield();
        }
        printThird.run();
        i = 0;
    }
}
