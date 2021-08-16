package leetcode.p2021m07;

import example.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 10:10 AM
 */
public class Solution671II {
    private int minValue=-1;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root,root.val);
        return minValue;
    }


    private  void dfs(TreeNode root,final int rootVal){
        if (root==null){
            return;
        }
        if (minValue!=-1 && root.val>minValue){
            return;
        }
        if (root.val>rootVal){
            if (minValue==-1) {
                minValue = root.val;
            }else {
                minValue=Math.min(minValue,root.val);
            }
        }
        dfs(root.left,rootVal);
        dfs(root.right,rootVal);

    }

    public static void main(String[] args){
        Solution671II solution671 =new Solution671II();
        TreeNode root=TreeNode.ofArray("[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]");
        System.out.println(solution671.findSecondMinimumValue(root));
    }
}
