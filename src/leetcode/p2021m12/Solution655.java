package leetcode.p2021m12;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 4:31 PM
 */
public class Solution655 {
    List<List<String>> ans = new ArrayList<>();

    int m;
    int n;

    public List<List<String>> printTree(TreeNode root) {

        m = getHeight(root);
        n = (1 << m) - 1;

        for (int i = 0; i < m; i++) {
            List<String> line = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                line.add("");
            }
            ans.add(line);
        }

        dfs(root, 0, 0, n - 1);

        return ans;

    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private void dfs(TreeNode root, int row, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = (left + right) >> 1;
        ans.get(row).set(mid, String.valueOf(root.val));

        dfs(root.left, row + 1, left, mid - 1);
        dfs(root.right, row + 1, mid + 1, right);
    }

    public static void main(String[] args) {
        String             str         = "[1,2,3,null,4]";
        TreeNode           root        = TreeNode.ofArray(str);
        Solution655        solution655 = new Solution655();
        List<List<String>> ans         = solution655.printTree(root);
        System.out.println(ans);
    }
}
