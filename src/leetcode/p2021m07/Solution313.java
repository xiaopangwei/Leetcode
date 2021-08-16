package leetcode.p2021m07;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/9
 * @time 9:32 AM
 */
public class Solution313 {
    public int nthSuperUglyNumber(int n, int[] primes) {

        if (n == 1) {
            return 1;
        }
        Set<Long> seen=new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1L);
        seen.add(1L);
        long latest = 1;
        for (int i = 0; i < n; i++) {
            long minVal = priorityQueue.poll();
            latest=minVal;
            for (int item : primes) {
                long next=minVal*item;
                if (seen.add(next)){
                    priorityQueue.add(next);
                }
            }
        }
        return (int)(latest);
    }


    public static void main(String[] args) {
        Solution313 solution313 = new Solution313();
//        int[] array={2,3,7,11};
//        solution313.primes(5,array);
//        for (int i=1;i<=20;i++){
//            System.out.println("i "+i+" "+solution313.primes(i,array));
//        }


        int ans = solution313.nthSuperUglyNumber(100000, new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251});
        System.out.println(ans);
    }
}
