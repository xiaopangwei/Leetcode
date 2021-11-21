package leetcode.p2021m11;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 10:22 AM
 */
public class Solution652 {
    Map<String, Integer> freq      = new HashMap<>();
    List<TreeNode>       treeNodes = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {


        dfs(root);
        return treeNodes;

    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String key = root.val + "," + dfs(root.left) +"," + dfs(root.right);
        int    f   = this.freq.getOrDefault(key, 0);
        if (f == 1) {
            treeNodes.add(root);
        }

        freq.put(key, f + 1);

        return key;
    }

    public static void main(String[] args){
        TreeNode root=TreeNode.ofArray("[1,2,3,4,null,2,4,null,null,4]");
        Solution652 solution652=new Solution652();
        List<TreeNode> list=solution652.findDuplicateSubtrees(root);
        for (TreeNode node:list){
            System.out.println(node.val);
        }
    }


}
