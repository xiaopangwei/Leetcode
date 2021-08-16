package leetcode.p2021m07;

import example.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 10:38 PM
 */
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans=new ArrayList<>();

        Queue<TreeNode> queue=new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()){
            List<Integer> levelList=new ArrayList<>();
            int len=queue.size();
            for (int i=0;i<len;i++){

                TreeNode temp=queue.poll();
                levelList.add(temp.val);


                if (temp.left!=null){
                    queue.add(temp.left);
                }

                if (temp.right!=null){
                    queue.add(temp.right);
                }
            }

            ans.add(levelList);

        }
        return ans;
    }

    public static void main(String[] args){
        Solution102 solution102=new Solution102();
        TreeNode root=TreeNode.ofArray("[3,9,5,20,null,null,15,7,100,3,4,5,6,7,8,3]");
        List<List<Integer>> ans=solution102.levelOrder(root);
        System.out.println(ans);
    }
}
