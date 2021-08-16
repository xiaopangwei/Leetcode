package leetcode.p20210312;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/12
 * @time 2:26 PM
 */
public class Solution239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0])
                {
                    return o2[0]-o1[0];
                }
                else{
                    return o2[1]-o1[1];
                }
            }
        });
        int count=0;
        int[] res=new int[nums.length-k+1];
        for (int i=0;i<k;i++){
            queue.add(new int[]{nums[i],i});
        }
        res[count++]=queue.peek()[0];

        for (int i=k;i<nums.length;i++){

            queue.add(new int[]{nums[i],i});
            while (true){
                int[] temp=queue.peek();
                if (temp[1]>i-k)
                {
                    res[count++]=temp[0];
                    break;
                }
                else{
                    queue.poll();
                }
            }

        }

        return res;


    }



    public static void main(String[] args){
        Solution239   solution315 =new Solution239();
        int[] ans=solution315.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        System.out.println(Arrays.toString(ans));
    }

}
