package demo.szse;


import java.util.ArrayList;
import java.util.List;

public class StaticBlockTest {


    private static class InnerClass {

        private static  int a=1;
        static {
            System.out.println("<clinit>"+Thread.currentThread().getName()+"#"+a);
        }
    }

    static {
        System.out.println(Thread.currentThread().getName()+"#Static");
    }
    public static void main(String[] args) throws InterruptedException {



        List<Thread> threadList =new ArrayList<>();
        for (int i=0;i<3;i++)
        {
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    InnerClass cls=new InnerClass();
                }
            });
            threadList.add(t);
            t.start();

        }

        for (Thread t:threadList){
            t.join();
        }




    }
}
