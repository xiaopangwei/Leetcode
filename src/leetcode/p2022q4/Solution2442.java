package leetcode.p2022q4;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/24
 * @time 9:24 PM
 */
public class Solution2442 {
    private int reverse(int s) {

        int ans = 0;
        while (s != 0) {
            ans = ans * 10 + s % 10;
            s /= 10;
        }
        return ans;
    }

    public int countDistinctIntegers(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }

        for (int num : nums) {
            sets.add(reverse(num));
        }
        return sets.size();
    }

    public static void main(String[] args) {
        Solution2442 solution2442 = new Solution2442();
        System.out.println(solution2442.countDistinctIntegers(new int[]{1, 13, 10, 12, 31}));
    }
}
