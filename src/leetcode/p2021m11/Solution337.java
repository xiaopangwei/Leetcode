package leetcode.p2021m11;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/22
 * @time 8:52 PM
 */
public class Solution337 {
    Map<TreeNode,Integer> cache=new HashMap<>();
    public int rob(TreeNode root) {
       int max=dfs(root);
       return max;
    }

    private int dfs(TreeNode root){
        if (cache.containsKey(root)){
            return cache.get(root);
        }
        if (root==null){
            return 0;
        }
        //不抢
        int t1=dfs(root.left)+dfs(root.right);
        int t2=root.val;
        if (root.left!=null) {
            t2 += (dfs(root.left.left) + dfs(root.left.right));
        }
        if (root.right!=null) {
            t2 += (dfs(root.right.left) + dfs(root.right.right));
        }
        int ans= Math.max(t1,t2);
        cache.put(root,ans);
        return ans;
    }
}
