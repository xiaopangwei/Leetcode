package leetcode.p2021m02.p20210213;


import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TestAtomic2 {

    int a=10;
    private AtomicStampedReference<Integer> reference =new AtomicStampedReference(a,0);

    public void cas1() throws InterruptedException {

        int oldStamp=reference.getStamp();
        int newStamp=oldStamp+1;

        Thread.sleep(1000);
        int oldVal=reference.getReference();
        int newVal=oldVal+1;

        System.out.println(Thread.currentThread().getName()+" cas1 "+oldStamp+","+newStamp+","+reference.getStamp());

        System.out.println(Thread.currentThread().getName()+" cas1 "+reference.compareAndSet(oldVal,newVal,oldStamp,newStamp));

    }

    public void cas2(){

        int oldVal=reference.getReference();
        System.out.println(Thread.currentThread().getName()+" cas2 first "+reference.getStamp());
        reference.compareAndSet(oldVal,3,reference.getStamp(),reference.getStamp()+1);


        int stamp=reference.getStamp();

        System.out.println(Thread.currentThread().getName()+" cas2 second "+stamp);
        System.out.println(Thread.currentThread().getName()
                +" cas2 "+reference.compareAndSet(3,0,stamp,stamp-1));
    }

    public static void main(String[] args) throws Exception{
//
        int         len        =30;
        TestAtomic2 testAtomic =new TestAtomic2();



        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    testAtomic.cas1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {

                    testAtomic.cas2();

            }
        });



        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
