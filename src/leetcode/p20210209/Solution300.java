package leetcode.p20210209;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution300 {


    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        if (nums.length>=1){
            dp[0]=1;
        }
        for (int i=0;i<nums.length;i++){

            int max=1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]) {
                    max= Math.max(max, dp[j]+1);
                }
            }

            dp[i]=max;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public static void main(String[] args){
        Solution300 solution300=new Solution300();
        System.out.println(solution300.lengthOfLIS(new int[]{4,10,4,3,8,9}));

    }
}
