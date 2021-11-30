package leetcode.p2021m11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/29
 * @time 9:50 PM
 */
public class Solution786 {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {

        int[] ans = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double t1 = arr[o1[0]] * 1.0 / arr[o1[1]];
                double t2 = arr[o2[0]] * 1.0 / arr[o2[1]];
                return Double.compare(t1,t2);
            }
        });

        for (int i=1;i<arr.length;i++){
            pq.add(new int[]{0,i});
        }


        int times=k;
        while (times >0){
            int[] tmp=pq.poll();
            if (tmp[0]+1<tmp[1]){
                pq.add(new int[]{tmp[0]+1,tmp[1]});
            }
//            System.out.println(arr[tmp[0]]+" "+arr[tmp[1]]);
            times--;
            if (times==0){
                ans=new int[]{arr[tmp[0]],arr[tmp[1]]};
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution786 solution786=new Solution786();
        int[] array=new int[]{1,2,3,5};
        int[] ans=solution786.kthSmallestPrimeFraction(array,4);
        System.out.println(Arrays.toString(ans));
    }
}
