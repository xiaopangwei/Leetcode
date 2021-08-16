package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/21
 * @time 10:27 AM
 */
public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int count=0;
        int len=nums.length;
        for (int i=0;i<len;i++){
            int sum=nums[i];
            if (sum==goal){
                count++;
            }
            for (int j=i+1;j<len;j++){
                sum+=nums[j];
                if (sum>goal){
                    break;
                }else if (sum==goal){
                    System.out.println(i+","+j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args){
        Solution930 solution930=new Solution930();
        System.out.println(solution930.numSubarraysWithSum(new int[]{1,0,1,0,1},2));
    }
}
