package common.ms;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/9/6
 * @time 11:07 PM
 */
public class Daily0906 {
    public boolean isIdealPermutation(int[] nums) {
        //[1,0,2]
        //[1,1,2]

        //[1,2,0]
        //[1,2,2]

        int[] maxArray = new int[nums.length];
        maxArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxArray[i] = Math.max(maxArray[i-1], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (i - 2 >= 0 && maxArray[i - 2] > nums[i]) {
                return false;
            }
        }
        return true;
    }
}
