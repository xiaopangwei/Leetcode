package leetcode.p2021m02.p20210212;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution1226 {

    private final Map<Integer,Lock> idAndLockRefMap;
    public Solution1226() {
       idAndLockRefMap=new HashMap<>();
       for (int i=0;i<5;i++){
           if (!idAndLockRefMap.containsKey(i)){
               idAndLockRefMap.put(i,new ReentrantLock());
           }
       }

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int left=philosopher;
        int right=(philosopher-1+5)%5;

        int smallerIndexLock=Math.min(left,right);
        int biggerIndexLock=Math.max(left,right);

        idAndLockRefMap.get(smallerIndexLock).lock();
        idAndLockRefMap.get(biggerIndexLock).lock();

        try{
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
        finally {
            idAndLockRefMap.get(smallerIndexLock).unlock();
            idAndLockRefMap.get(biggerIndexLock).unlock();
        }
        System.out.println("Index:"+philosopher);

    }


    public static void main(String[] args) throws Exception{

        Runnable pickLeftFork=new Runnable() {
            @Override
            public void run() {
                System.out.println("pickLeftFork");
            }
        };
        Runnable pickRightFork=new Runnable() {
            @Override
            public void run() {
                System.out.println("pickRightFork");
            }
        };
        Runnable eat=new Runnable() {
            @Override
            public void run() {
                System.out.println("eat");
            }
        };
        Runnable putLeftFork=new Runnable() {
            @Override
            public void run() {
                System.out.println("putLeftFork");
            }
        };
        Runnable putRightFork=new Runnable() {
            @Override
            public void run() {
                System.out.println("putRightFork");
            }
        };

        Solution1226 solution1226=new Solution1226();
        for (int i=0;i<5;i++){
            final  int j=i;
            Thread t=new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        solution1226.wantsToEat(j,pickLeftFork,pickRightFork,eat,putLeftFork,putRightFork);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            t.start();
            t.join();
        }
    }




}
