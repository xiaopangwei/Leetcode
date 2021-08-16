package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 11:07 PM
 */
public class Solution268 {
    public int missingNumber(int[] nums) {

        int len=nums.length;
        int sum1=len*(len+1)/2;
        int sum2=0;
        for (int item:nums){
            sum2+=item;
        }
        return sum1-sum2;
    }

    public static void main(String[] args){
        Solution268 solution268=new Solution268();
        int ans=solution268.missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(ans);
    }

}
