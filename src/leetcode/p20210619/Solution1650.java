package leetcode.p20210619;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/21
 * @time 11:00 PM
 */
public class Solution1650 {
  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p==null||q==null||root==null){
            return null;
        }
        if (root==p || root==q){
            return root;
        }

        List<TreeNode> l1=new ArrayList<>();
        List<TreeNode> l2=new ArrayList<>();

        this.getPath(root,p,l1);
        this.getPath(root,q,l2);


        if (p==q){
            return  l1.get(l1.size()-2);
        }



        int index1=0;
        int index2=0;

        while (index1<l1.size() && index2<l2.size()){
            if (l1.get(index1)!=l2.get(index2)){
                return l1.get(index1-1);
            }else{
                index1++;
                index2++;
            }
        }

        return  l1.get(Math.min(index1,index2)-1);

    }


    private boolean getPath(TreeNode root, TreeNode p,List<TreeNode> path){
        if (root==null){
            return false;
        }
        if (root==p){
            path.add(p);
           return true;
        }else{
            path.add(root);
            boolean r1=getPath(root.left,p,path);
            if (r1){
                return true;
            }
            boolean r2=getPath(root.right,p,path);
            if (r2){
                return true;
            }
            path.remove(path.size()-1);
        }

        return false;
    }


    public static void main(String[] args){
        TreeNode root=new TreeNode(0);
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);


        root.left=t1;
        root.right=t2;

        t1.left=t3;
        t2.right=t4;

        t4.right=t5;

        Solution1650 solution1650=new Solution1650();
        System.out.println(solution1650.lowestCommonAncestor(root,t1,t4).val);
        System.out.println(solution1650.lowestCommonAncestor(root,t1,t3).val);
        System.out.println(solution1650.lowestCommonAncestor(root,t2,t3).val);
        System.out.println(solution1650.lowestCommonAncestor(root,t2,t5).val);


    }
}
