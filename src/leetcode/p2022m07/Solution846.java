package leetcode.p2022m07;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/30
 * @time 9:37 AM
 */
public class Solution846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length < groupSize) {
            return false;
        }
        //1 2 3 2 3 4 6 7 8
        //1 2 2 3 3 4 6 7 8
        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int item : hand) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        while (!freq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = freq.firstEntry();
            int                         first = entry.getKey();
            for (int i = 0; i < groupSize; i++) {
                int k = first + i;
                if (!freq.containsKey(k)) {
                    return false;
                }
                int t = freq.get(k);
                if (t - 1 > 0) {
                    freq.put(k, t - 1);
                } else {
                    freq.remove(k);
                }
            }
        }
        return true;
    }


    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, k, new ArrayList<>());
        return ans;
    }


    private void dfs(final int n, int startIndex, final int k, List<Integer> list) {

        if (list.size() == k) {
            System.out.println(list);
            List<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            ans.add(copy);
            return;
        }
        if (startIndex > n) {
            return;
        }

        list.add(startIndex);
        dfs(n, startIndex + 1, k, list);
        list.remove(list.size() - 1);

        dfs(n, startIndex + 1, k, list);
    }


    public static void main(String[] args) {
        int[]       array       = new int[]{1, 2, 3, 4, 5};
        Solution846 solution846 = new Solution846();
//        boolean     ans         = solution846.isNStraightHand(array, 4);
//        System.out.println(ans);
        System.out.println(solution846.combine(4, 2));
    }

}
