package demo.thread;

import java.util.concurrent.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/7
 * @time 1:47 PM
 */
public class TestFuture {

    static class MyCallable implements Callable<Integer>{

        private int age;

        public MyCallable(int age){
            this.age=age;
        }
        @Override
        public Integer call() throws Exception {
            int newAge=age+1;
            System.out.println("GET:"+newAge+" THREAD:"+Thread.currentThread().getName());
            return newAge;
        }
    }

    public static void main(String[] args) throws Exception{
//        TestFuture testFuture = new TestFuture();
//        for (int i=0;i<3;i++) {
//            Callable<Integer> callable=new MyCallable(i);
//            FutureTask<Integer> task=new FutureTask<>(callable);
//            Thread t=new Thread(task);
//            t.start();
//
//            System.out.println(task.get());
//        }

        ExecutorService executorService=Executors.newFixedThreadPool(3);
        for (int i=0;i<5;i++) {
            Future<Integer> futureTask = executorService.submit(new MyCallable(i));
            System.out.println(futureTask.get());
        }


    }


}
