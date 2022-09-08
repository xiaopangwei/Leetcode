package leetcode.p2022m06.day0628;

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
 * @date 2022/7/4
 * @time 4:56 PM
 */
public class Solution652 {

    List<TreeNode>       data = new ArrayList<>();
    Map<String, Integer> freq = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return data;
    }

    private String dfs(TreeNode root) {
        if (root == null) {
            return "NULL";
        }
        StringBuilder sb = new StringBuilder();

        sb.append(dfs(root.left));
        sb.append(",");
        sb.append(root.val);
        sb.append(dfs(root.right));
        sb.append(",");

        String serialization = sb.toString();

        freq.put(serialization, freq.getOrDefault(serialization, 0) + 1);
        if (freq.get(serialization) == 2) {
            data.add(root);
        }

        return serialization;
    }

    public static void main(String[] args){
        TreeNode root=TreeNodeBuilder.build("[0,0,0,0,null,null,0,null,null,null,0]");
        Solution652 solution652=new Solution652();
        System.out.println(solution652.findDuplicateSubtrees(root));
    }
}
