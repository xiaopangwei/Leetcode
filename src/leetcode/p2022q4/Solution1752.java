package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/27
 * @time 8:31 PM
 */
public class Solution1752 {
    public boolean check(int[] nums) {
        //3 4 5 1 2 3 4 5 1 2
        //2 1 3 4 2 1 3 4
        int[] copy = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        for (int i = nums.length; i < nums.length * 2; i++) {
            copy[i] = nums[i - nums.length];
        }

        int i = 0;
        while (i < copy.length) {
            int j = i + 1;
            while (j+1 < copy.length && copy[j] <= copy[j + 1]) {
                j++;
            }
            int len = j - i;
            if (len >= nums.length) {
                return true;
            }
            i = j;
        }
        return false;
    }

    public static void main(String[] args){
        Solution1752 solution1752=new Solution1752();
        System.out.println(solution1752.check(new int[]{2,1,3,4}));
    }
}
