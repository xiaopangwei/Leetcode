package leetcode.p2021m07.p20210708;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/6
 * @time 1:16 PM
 */
public class Solution45 {
    public int jump(int[] nums) {

        int[] dp=new int[nums.length];
        dp[0]=0;
        for (int i=1;i<nums.length;i++){
            int j=0;
            while (j+nums[j]<i) {j++;}
            dp[i]=dp[j]+1;
        }
        return dp[nums.length-1];
    }


    public static void main(String[] args){
        Solution45 solution45=new Solution45();
        int ans=solution45.jump(new int[]{2,3,0,1,4});
        System.out.println(ans);
    }
}
