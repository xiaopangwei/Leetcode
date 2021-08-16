package leetcode.p2021m07;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 4:21 PM
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans=new ArrayList<>();

        dfs(root,ans);

        return ans;
    }

    private void dfs(TreeNode root,List<Integer> ans){
        if (root==null){
            return;
        }
        dfs(root.left,ans);
        ans.add(root.val);
        dfs(root.right,ans);
    }
}
