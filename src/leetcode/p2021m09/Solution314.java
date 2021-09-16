package leetcode.p2021m09;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/15
 * @time 5:29 PM
 */
public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<int[]>> ans = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        dfs(ans, 0, root, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : ans.entrySet()) {
            List<int[]> temp = entry.getValue();
            Collections.sort(temp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            List<Integer> innerList = new ArrayList<>();
            for (int[] item : temp) {
                innerList.add(item[1]);
            }
            res.add(innerList);
        }
        return res;
    }

    private void dfs(final Map<Integer, List<int[]>> map, int colIndex, TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(colIndex)) {
            map.put(colIndex, new ArrayList<>());
        }
        map.get(colIndex).add(new int[]{depth, root.val});
        dfs(map, colIndex - 1, root.left, depth + 1);
        dfs(map, colIndex + 1, root.right, depth + 1);
    }

    public static void main(String[] args) {
        Solution314 solution314 = new Solution314();
        TreeNode    root        = TreeNode.ofArray("[3,9,20,null,null,15,7]");
        System.out.println(solution314.verticalOrder(root));
    }
}
