package leetcode.p2021m11;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/21
 * @time 9:22 PM
 */
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if (node==null){
                while (!queue.isEmpty()){
                    if (queue.poll()!=null){
                        return false;
                    }
                }
                return true;
            }
            queue.add(node.left);
            queue.add(node.right);

        }

        return true;
    }
}
