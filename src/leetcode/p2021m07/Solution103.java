package leetcode.p2021m07;

import example.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 9:59 AM
 */
public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        int level=1;
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){

            int size=queue.size();
            List<Integer> subList=null;
            if (level%2!=0){
                subList=new ArrayList<>();
            }else{
                subList=new LinkedList<>();
            }
            for (int i=0;i<size;i++){
                TreeNode parent=queue.poll();
                if (subList instanceof ArrayList){
                    ((ArrayList) subList).add(parent.val);
                }else if (subList instanceof LinkedList){
                    ((LinkedList) subList).addFirst(parent.val);
                }

                if (parent.left!=null){
                    queue.add(parent.left);
                }
                if (parent.right!=null){
                    queue.add(parent.right);
                }
            }
            list.add(subList);
            level++;
        }
        return list;
    }

    public static void main(String[] args){
        Solution103 solution103=new Solution103();
        System.out.println(solution103.zigzagLevelOrder(TreeNode.ofArray("[3,9,20,null,null,15,7]")));
    }
}
