package leetcode.p2021m12;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/14
 * @time 9:54 PM
 */
public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {

        int[] ans = new int[num_people];

        int start = 1;

        int count = candies;

        int idx = 0;
        while (count > 0) {
            if (count<=start){
                ans[idx]+=count;
                break;
            }
            ans[idx] = start;
            count -= start;
            start++;

            idx = idx + 1;

            if (idx == num_people) {
                idx = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1103 solution1103 = new Solution1103();
        int[]        ans          = solution1103.distributeCandies(7, 4);
        System.out.println(Arrays.toString(ans));
    }
}
