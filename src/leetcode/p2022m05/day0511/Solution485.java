package leetcode.p2022m05.day0511;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 8:22 PM
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxVal=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==1){
                count++;
                maxVal=Math.max(count,maxVal);
            }else{
                count=0;
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
        Solution485 solution485=new Solution485();
        int ans=solution485.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1});
        System.out.println(ans);
    }
}
