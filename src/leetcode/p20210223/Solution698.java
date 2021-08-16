package leetcode.p20210223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/23
 * @time 11:22 AM
 */
public class Solution698 {
    private int partitionCount;
    private int avg;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=Arrays.stream(nums).sum();
        if (sum%k!=0)
        {
            return false;
        }
        int avg=sum/k;

        Arrays.sort(nums);
        partitionCount=k;
        this.avg=avg;
        if (nums[nums.length-1]>avg)
        {
            return false;
        }
        boolean[] visited=new boolean[nums.length];
        return partition(nums,0,0,visited,0);
    }

   private boolean partition(final int[] nums,int round,int start,boolean[] visited,int currentSum){

//       System.out.println("start #start:"+start+" currentSum:"+currentSum+ " round:"+round);
       if (round==partitionCount)
       {
           return true;
       }
        if (currentSum==avg)
        {
                System.out.println(Arrays.toString(visited));
                return partition(nums,round+1,0,visited,0);
        }

        boolean flag=false;
        for (int i=start;i<nums.length;i++){

            if (visited[i]) continue;
            if (nums[i]+currentSum>avg) {
//                System.out.println("--- end #start:"+start+" currentSum:"+currentSum+ " round:"+round + "result: "+flag);
                return false;
            }

            visited[i]=true;
//            System.out.println("选择"+nums[i]);
            flag=partition(nums,round,i+1,visited,currentSum+nums[i]);
            if (flag){
                return true;
            }
//            System.out.println("删除"+nums[i]);
            visited[i]=false;
        }
//       System.out.println("--- end #start:"+start+" currentSum:"+currentSum+ " round:"+round + "result: "+flag);
        return flag;

   }

    public static void main(String[] args){
        Solution698 solution698=new Solution698();
        long start=System.currentTimeMillis();
        int[] array=new int[]{4, 3, 2, 3, 5, 2, 1};
        //1 1 2 3 3 4 5
        int k=4;
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(solution698.canPartitionKSubsets(array,k));
    }
}
