package leetcode.p20210213;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TestAtomic1 {

    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public void cas1(){
        while (true){
            int old=atomicInteger.get();
            int newOne=old+1;

            boolean result=atomicInteger.compareAndSet(old,newOne);
            if (result){
                System.out.println(Thread.currentThread().getName()+" SUCCESS ==> old "+old+" new "+newOne);
                break;
            }
            else{
                System.out.println(Thread.currentThread().getName()+" FAILED ==> old "+old+" new "+newOne);
            }
        }

//        System.out.println(Thread.currentThread().getName()+"# cas1:"+atomicInteger.compareAndSet(old,newOne));
    }

    public void cas2(){
        int old=0;
        int newOne=2;
        System.out.println(Thread.currentThread().getName()+"# cas2:"+atomicInteger.compareAndSet(old,newOne));
    }

    public void cas3(){
        int old=2;
        int newOne=3;
        System.out.println(Thread.currentThread().getName()+"# cas3:"+atomicInteger.compareAndSet(old,newOne));
    }

    public void cas4(){
        int old=0;
        int newOne=2;
        System.out.println(Thread.currentThread().getName()+"# cas4:"+atomicInteger.compareAndSet(old,newOne));
    }
    public static void main(String[] args) throws Exception{
//
        int len=30;
        TestAtomic1 testAtomic=new TestAtomic1();
//        testAtomic.init();
        Thread[] tArray=new Thread[len];
        int idx=0;
        for (int i=0;i<len;i++){
            final  int j=i;
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    testAtomic.cas2();
//                    if (j%4==0) {
//                        try {
//                            Thread.sleep(new Random().nextInt(300));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        testAtomic.cas1();
//                    }
//                    else if (j%4==1){
//                        try {
//                            Thread.sleep(new Random().nextInt(400));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        testAtomic.cas2();
//                    }
//                    else if (j%4==2){
//                        try {
//                            Thread.sleep(new Random().nextInt(1000));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        testAtomic.cas3();
//                    }
//                    else{
//                        try {
//                            Thread.sleep(new Random().nextInt(5));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        testAtomic.cas4();
//                    }
                }
            });


            tArray[idx++]=t;
            t.start();
        }


        for (Thread t:tArray){
            t.join();
        }



        System.out.println("Final:"+testAtomic.atomicInteger.get());

    }
}
