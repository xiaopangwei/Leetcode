package leetcode.p2022q4;

import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/4
 * @time 9:42 PM
 */
public class Solution6254 {
    public long dividePlayers(int[] skill) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int s : skill) {
            treeMap.put(s, treeMap.getOrDefault(s, 0) + 1);
        }

        int  target = treeMap.firstKey() + treeMap.lastKey();
        long ans    = 0;
        while (!treeMap.isEmpty()) {
            int t1 = treeMap.firstKey();
            int t2 = treeMap.lastKey();
            if (t1 + t2 != target) {
                return -1;
            }
            ans += (long) t1 * (long) t2;
            if (treeMap.firstEntry().getValue() > 1) {
                treeMap.put(t1, treeMap.get(t1) - 1);
            } else {
                treeMap.remove(t1);
            }

            if (treeMap.lastEntry().getValue() > 1) {
                treeMap.put(t2, treeMap.get(t2) - 1);
            } else {
                treeMap.remove(t2);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution6254 solution6254 = new Solution6254();
        System.out.println(solution6254.dividePlayers(new int[]{1, 1, 2, 3}));
    }
}
