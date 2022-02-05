package leetcode.p2021m08;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 3:58 PM
 */
public class Solution543 {
    private int maxVal = -1;
    Map<TreeNode, List<Integer>> map = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {

        dfs(root);

        return maxVal;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left  = dfs(root.left);
        int right = dfs(root.right);
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
        }
        map.get(root).add(left);
        map.get(root).add(right);
        map.get(root).add(left + right);
        maxVal = Math.max(maxVal, left + right);
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args){
        TreeNode root=TreeNodeBuilder.build("[1,2,3,4,5]");
        Solution543 solution543=new Solution543();
        int ans=solution543.diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}
