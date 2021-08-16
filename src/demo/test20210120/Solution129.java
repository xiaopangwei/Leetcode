package demo.test20210120;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/11
 * @time 2:54 PM
 */




class TreeNode {
      int       val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class Solution129 {
    private List<List<Integer>> result =new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root,new ArrayList<>());
        return sum(result);
    }


    private int sum(List<List<Integer>> list){
        int result=0;
        for(List<Integer> item:list){
            int base=1;
            int temp=0;
            for(int i=item.size()-1;i>=0;i--){
                temp+=(base*item.get(i));
                base*=10;
            }
            result+=temp;
        }
        return result;
    }
    public void dfs(TreeNode root, List<Integer> data){
        if(root==null){
            return;
        }

        data.add(root.val);
//        System.out.println("Add :"+root.val);
        if (root.left==null && root.right==null){
            result.add(new ArrayList<>(data));
        }
        dfs(root.left,data);
        dfs(root.right,data);
//        System.out.println("Remove :"+root.val);
        data.remove(data.size()-1);

    }



    public static void main(String[] args){
        TreeNode left=new TreeNode(9);
        TreeNode right=new TreeNode(0);
        TreeNode root=new TreeNode(4,left,right);

        TreeNode node =new TreeNode(1);
        left.right=node;

        Solution129 solution129=new Solution129();
        System.out.print(solution129.sumNumbers(root));



    }

}
