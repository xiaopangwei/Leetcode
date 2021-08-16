package leetcode.p2021m02.p20210213;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TestAtomic {

    private AtomicIntegerArray atomicIntegerArray=new AtomicIntegerArray(10);

    public void init(){
        for (int i=0;i<10;i++) {
            atomicIntegerArray.set(i,0);
        }
    }

    public int increase(int i){
        return atomicIntegerArray.incrementAndGet(i);
    }


    public void print(){
        for (int i=0;i<10;i++){
            System.out.println("["+i+"],"+atomicIntegerArray.get(i));
        }
    }
    public static void main(String[] args) throws Exception{
//
//        TestAtomic testAtomic=new TestAtomic();
//        testAtomic.init();
//        Thread[] tArray=new Thread[20];
//        int idx=0;
//        for (int i=0;i<20;i++){
//            Thread t=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i=0;i<10;i++) {
//                        testAtomic.increase(i);
//                    }
//                }
//            });
//
//
//            tArray[idx++]=t;
//            t.start();
//        }
//
//
//        for (Thread t:tArray){
//            t.join();
//        }
//
//
//        testAtomic.print();

        AtomicInteger a1 =new AtomicInteger(0);


        System.out.println(a1.compareAndSet(0,2)+"==>"+a1.get());

    }
}
