package leetcode.p2021m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:13 PM
 */
public class Solution465 {

    private int ans = Integer.MAX_VALUE;

    public int minTransfers(int[][] transactions) {

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < transactions.length; i++) {
            int temp = transactions[i][2];
            map.put(transactions[i][0], map.getOrDefault(transactions[i][0], 0) + temp);
            map.put(transactions[i][1], map.getOrDefault(transactions[i][1], 0) - temp);
        }


        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!entry.getValue().equals(0)) {
                list.add(entry.getValue());
            }
        }
        dfs(0, list, 0);


        return ans;
    }


    private void dfs(int index, List<Integer> list, int depth) {

        if (depth >= ans) {
            return;
        }

        int j = index;
        while (j < list.size() && list.get(j).equals(0)) {
            j++;
        }
        index = j;

        if (index >= list.size()) {
            ans = Math.min(ans, depth);
            return;
        }
        int current = list.get(index);

        for (int i = index + 1; i < list.size(); i++) {
            int prev=list.get(i);
            if (list.get(i) * current < 0) {
                int total = list.get(i) + current;
                list.set(index, 0);
                list.set(i, total);

                dfs(index + 1, list, depth + 1);

                list.set(index, current);
                list.set(i, prev);
            }
        }

    }

    public static void main(String[] args) {
        Solution465 solution465 = new Solution465();
        int         ans         = solution465.minTransfers(new int[][]{{1, 5, 8}, {8, 9, 8}, {2, 3, 9}, {4, 3, 1}});
        System.out.println(ans);
    }

}
