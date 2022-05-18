package leetcode.p2022m05.day0508;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 8:24 PM
 */
public class Solution987 {
    Map<TreeNode, int[]> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        for (Map.Entry<TreeNode, int[]> entry : map.entrySet()) {
            int val = entry.getKey().val;
            int row = entry.getValue()[0];
            int col = entry.getValue()[1];

            if (!treeMap.containsKey(col)) {
                treeMap.put(col, new ArrayList<>());
            }

            treeMap.get(col).add(new int[]{row, col, val});
        }

        for (Map.Entry<Integer, List<int[]>> entry : treeMap.entrySet()) {
            Collections.sort(entry.getValue(), new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[2] - o2[2];
                    }
                }
            });

            List<Integer> temp = new ArrayList<>();
            for (int[] item : entry.getValue()) {
                temp.add(item[2]);
            }
            ans.add(temp);
        }
        return ans;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        map.put(root, new int[]{x, y});
        dfs(root.left, x + 1, y - 1);
        dfs(root.right, x + 1, y + 1);
    }

    public static void main(String[] args) {
        TreeNode    root        = TreeNodeBuilder.build("[1,2,3,4,6,5,7]");
        Solution987 solution987 = new Solution987();
        System.out.println(solution987.verticalTraversal(root));
    }
}
