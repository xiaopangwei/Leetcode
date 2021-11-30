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
 * @date 2021/11/28
 * @time 11:09 AM
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> ans=new ArrayList<>();
        while (!queue.isEmpty()){
            int size=queue.size();
            int maxVal=Integer.MIN_VALUE;
            for (int i=0;i<size;i++) {
                TreeNode t = queue.poll();
                maxVal=Math.max(maxVal,t.val);
                if (t.left!=null){
                    queue.add(t.left);
                }else{
                    queue.add(t.right);
                }
            }

            ans.add(maxVal);

        }

        return ans;
    }

    public static void main(String[] args){}

}
