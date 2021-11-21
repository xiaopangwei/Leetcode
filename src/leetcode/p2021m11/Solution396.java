package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/21
 * @time 9:51 PM
 */
public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int n   = nums.length;
        int sum = 0;
        for (int t : nums) {
            sum += t;
        }
        int maxVal = Integer.MIN_VALUE;


        int current=0;
        for (int i=0;i<nums.length;i++){
            current+=(i*nums[i]);
        }
        maxVal=Math.max(maxVal,current);
        for (int i = 0; i < n-1; i++) {
            current=current-sum+n*nums[i];
//            System.out.println(current);
            maxVal=Math.max(maxVal,current);
        }


        return maxVal;
    }

    public static void main(String[] args) {
        Solution396 solution396 = new Solution396();
        int         max         = solution396.maxRotateFunction(new int[]{100});
        System.out.println(max);
    }
}
