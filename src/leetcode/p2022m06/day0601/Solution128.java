package leetcode.p2022m06.day0601;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/6
 * @time 10:59 PM
 */
public class Solution128 {
    Map<Integer, Integer> parent = new HashMap<>();
    Set<Integer>          sets   = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        for (int item : nums) {
            if (sets.contains(item)) {
                continue;
            }
            sets.add(item);
            parent.put(item, item);
        }

        for (int item : nums) {
            if (sets.contains(item + 1)) {
                union(item, item + 1);
            }
        }

        Map<Integer, Integer> freq = new HashMap<>();


        int maxValue = -1;

        for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
            int p = find(entry.getKey());
            int t = freq.getOrDefault(p, 0) + 1;
            freq.put(p, t);
            if (t > maxValue) {
                maxValue = t;
            }
        }


//        System.out.println(parent);
        return maxValue;

    }


    private int find(int x) {
        if (x == parent.get(x)) {
            return x;
        }
        int temp = find(parent.get(x));
        parent.put(x, temp);
        return temp;
    }

    private void union(int x, int y) {

        int p1 = find(x);
        int p2 = find(y);
        if (p1 != p2) {
            if (p1 < p2) {
                parent.put(p1, p2);
            } else {
                parent.put(p2, p1);
            }
        }
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int         ans         = solution128.longestConsecutive(new int[]{100,4,200,1,3,2});
        System.out.println(ans);

    }
}
