package demo.thread;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/7
 * @time 1:47 PM
 */
public class TestInterrupted {


    public static void main(String[] args) throws Exception{

            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("2:"+Thread.interrupted());
                        System.out.println("3:"+Thread.interrupted());

                    }
//
//                    for (int i=0;i<10000;i++)
//                    {
//                        System.out.println(i+" "+Thread.interrupted());
//                    }
                }
            });
            t.start();

//            Thread.sleep(3*1000);
            t.interrupt();
            System.out.println("Part-1:"+t.isInterrupted());
            System.out.println("Part-2:"+t.isInterrupted());

            while (true);



    }


}
