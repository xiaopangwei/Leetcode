package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/21
 * @time 9:31 PM
 */
public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k==0||k==1){
            return 0;
        }
        int left=0;
        int right=0;
        int prod=1;
        int count=0;
        while (right<nums.length){
            prod*=nums[right];
            while (left<nums.length && prod>=k){
                prod/=nums[left++];
            }

            count+=(right-left+1);
            right++;
        }
        return count;
    }

    public static void main(String[] args){
        Solution713 solution713=new Solution713();
        int ans=solution713.numSubarrayProductLessThanK(new int[]{10,5,2,6},100);
        System.out.println(ans);
    }
}
