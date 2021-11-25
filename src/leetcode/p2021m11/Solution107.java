package leetcode.p2021m11;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 8:51 PM
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        LinkedList<List<Integer>> ans=new LinkedList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> level=new ArrayList<>();
            for (int i=0;i<size;i++) {
                TreeNode temp = queue.poll();
                level.add(temp.val);
                if (temp.left!=null){
                    queue.add(temp.left);
                }
                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }
            ans.addFirst(level);

        }
        return ans;
    }

    public static void main(String[] args){
        Solution107 solution107=new Solution107();
        TreeNode root=TreeNode.ofArray("[3,9,20,null,null,15,7]");
        List<List<Integer>> ans=solution107.levelOrderBottom(root);
        System.out.println(ans);
    }
}
