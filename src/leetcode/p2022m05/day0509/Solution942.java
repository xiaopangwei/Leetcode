package leetcode.p2022m05.day0509;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 7:37 PM
 */
public class Solution942 {
    public int[] diStringMatch(String s) {
        int[] ans   = new int[s.length() + 1];
        int   left  = 0;
        int   right = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = left++;
            } else {
                ans[i] = right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution942 solution942 = new Solution942();
        int[]       ans         = solution942.diStringMatch("IDID");
        System.out.println(Arrays.toString(ans));
    }
}
