package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/3
 * @time 3:41 PM
 */
public class Solution1769 {
    public int[] minOperations(String boxes) {

        int[] ans = new int[boxes.length()];

        int count = 0;
        int prev  = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i - 1) - '0' == 1) {
                count++;
            }
            prev += count;
            ans[i] = prev;
        }

        count = 0;
        int next = 0;
        for (int i = boxes.length() - 2; i >= 0; i--) {
            if (boxes.charAt(i + 1) == '1') {
                count++;
            }
            next += count;
            ans[i] += next;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1769 solution1769 = new Solution1769();
        System.out.println(Arrays.toString(solution1769.minOperations("001011")));
    }
}
