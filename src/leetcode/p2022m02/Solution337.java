package leetcode.p2022m02;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/7
 * @time 9:21 PM
 */
public class Solution337 {
    Map<TreeNode,Integer> cached=new HashMap<>();
    public int rob(TreeNode root) {
        if (cached.containsKey(root)){
            return cached.get(root);
        }
        if (root==null){
            return 0;
        }

        //抢root
        int ans=root.val;
        if (root.left!=null){
            ans+=rob(root.left.left);
            ans+=rob(root.left.right);
        }

        if (root.right!=null){
            ans+=rob(root.right.left);
            ans+=rob(root.right.right);
        }

        //不抢root
        int maxVal=Math.max(rob(root.left)+rob(root.right),ans);
        cached.put(root,maxVal);
        return maxVal;
    }

}
