package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 2:54 PM
 */
public class Solution1004 {

    public int longestOnes(int[] nums, int k) {

        int zeroCnt = 0;
        int left    = 0;
        int right   = 0;
        int maxLen  = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                zeroCnt++;
                if (zeroCnt > k) {
                    int i = left;
                    while (i < nums.length && zeroCnt > k) {
                        if (nums[i] == 0) {
                            zeroCnt--;
                        }
                        i++;
                    }
                    left = i;
                    maxLen = Math.max(maxLen, right - left + 1);
                    right++;
                } else {
                    maxLen = Math.max(maxLen, right - left + 1);
                    right++;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
        int          cnt          = solution1004.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3);
        System.out.println(cnt);
    }
}
