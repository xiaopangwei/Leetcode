package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 5:22 PM
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int majorValue = nums[0];
        int majorCount = 1;

        for (int i = 1; i < nums.length; i++) {
            if (majorValue != nums[i]) {
                majorCount--;
            } else {
                majorCount++;
            }

            if (majorCount <= 0) {
                majorValue = nums[i];
                majorCount = 1;
            }
        }

        return majorValue;
    }

    public static void main(String[] args){
        Solution169 solution169=new Solution169();
        int val=solution169.majorityElement(new int[]{3,2,3});
        System.out.println(val);
    }
}
