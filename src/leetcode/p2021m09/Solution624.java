package leetcode.p2021m09;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/29
 * @time 10:58 PM
 */
public class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {

        List<Integer> first     = arrays.get(0);
        int           leftStart = first.get(0);
        int           rightEnd  = first.get(first.size() - 1);
        int maxDist =-1;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> temp = arrays.get(i);
            int           a    = rightEnd - temp.get(0);
            int           b    = temp.get(temp.size() - 1) - leftStart;
            maxDist = Math.max(maxDist, Math.max(a, b));
            if (temp.get(0) < leftStart) {
                leftStart = temp.get(0);
            }
            if (temp.get(temp.size() - 1) > rightEnd) {
                rightEnd = temp.get(temp.size() - 1);
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {

        Solution624         solution624 = new Solution624();
        List<List<Integer>> in          = Arrays.asList(Arrays.asList(1, 5), Arrays.asList(3, 4));
        int                 ans         = solution624.maxDistance(in);
        System.out.println(ans);
    }
}
