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
public class TestAtomicStampedRef {


    public static void main(String[] args) throws Exception{

        AtomicStampedReference<Integer> a=new AtomicStampedReference<>(100,0);
        for (int i=0;i<30;i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Integer oldVal=a.getReference();
                    Integer newVal=oldVal+1;
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" # "+
                            a.compareAndSet(oldVal,newVal,a.getStamp(),a.getStamp()+1)
                            +" old:"+oldVal+" new:"+newVal);
                }
            });
            t.start();
        }


        while (true);
    }
}
