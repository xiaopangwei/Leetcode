package leetcode.p2021m07;

import example.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 10:10 AM
 */
public class Solution671 {
    public int findSecondMinimumValue(TreeNode root) {

        List<Integer> data =new ArrayList<>();

        dfs(root,data);
        if (data.size()<2){
            return -1;
        }else {
            int firstSmall  = data.get(0)>data.get(1)?data.get(1):data.get(0);
            int secondSmall = data.get(0)>data.get(1)?data.get(0):data.get(1);

            for (int i = 2; i < data.size(); i++) {
                int num=data.get(i);
                if (num<firstSmall){
                    secondSmall=firstSmall;
                    firstSmall=num;
                }else if (num>firstSmall && num<secondSmall){
                    secondSmall=num;
                }
            }

            return secondSmall;
        }

    }

    private void dfs(TreeNode root,List<Integer> list){
        if (root==null){
            return;
        }

        if (!list.contains(root.val)){
            list.add(root.val);
        }

        dfs(root.left,list);
        dfs(root.right,list);
    }

    public static void main(String[] args){
        Solution671 solution671=new Solution671();
        TreeNode node=new TreeNode(2,new TreeNode(2,null,null),
                new TreeNode(3,null,null));
        System.out.println(solution671.findSecondMinimumValue(node));
    }
}
