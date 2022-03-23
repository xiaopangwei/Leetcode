package leetcode.p2022m03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/9
 * @time 9:20 PM
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> parents = new HashMap<>();
        Set<Integer>          res     = new HashSet<>();
        for (int item : nums) {
            if (!res.contains(item)) {
                res.add(item);
                parents.put(item, item);
            }
        }
        for (int item : nums) {
            int bigger = item + 1;
            if (res.contains(bigger)) {
                union(parents, item, bigger);
            }
        }
        int maxVal = 0;
        for (int item : res) {
            int temp = find(parents, item);
            maxVal = Math.max(maxVal, temp - item + 1);
        }
        return maxVal;
    }

    private int find(Map<Integer, Integer> parent, int p) {
        if (parent.get(p) == p) {
            return p;
        }
        int temp = find(parent, parent.get(p));
        parent.put(p, temp);
        return temp;
    }

    private void union(Map<Integer, Integer> parent, int p, int q) {
        int t1 = find(parent, p);
        int t2 = find(parent, q);
        parent.put(t1, t2);
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int         ans         = solution128.longestConsecutive(new int[]{5,100, 0,4, 200, 1, 3, 2});
        System.out.println(ans);
    }

}
