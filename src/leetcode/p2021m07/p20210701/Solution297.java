package leetcode.p2021m07.p20210701;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/1
 * @time 3:29 PM
 */
public class Solution297 {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


   static class Codec {

        private int getDepth(TreeNode root){
            if (root==null) {return 0;}
            return Math.max(getDepth(root.left),getDepth(root.right))+1;
        }
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            if (root==null){
                return "";
            }
            List<String> ans=new ArrayList<>();

            int depth=getDepth(root);
            int totalNumber= (1 << depth)-1;
            Queue<TreeNode> queue=new LinkedList<>();
            if (root!=null){
                queue.add(root);
            }

            while (!queue.isEmpty()){
                TreeNode parent=queue.poll();
                ans.add(String.valueOf(parent.val));
                if (ans.size()==totalNumber){
                    return String.join("#",ans);
                }
                if (parent.left==null){
                    queue.add(new TreeNode(-99));
                }else{
                    queue.add(parent.left);
                }

                if (parent.right==null){
                    queue.add(new TreeNode(-99));
                }else{
                    queue.add(parent.right);
                }
            }

            return String.join("#",ans);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] res=data.split("#");
            int idx=0;
            if (res.length<=0||data.length()==0){
                return null;
            }
            Map<Integer,TreeNode> map=new HashMap<>();
            for (int i=0;i<res.length;i++){
                int intVal=Integer.valueOf(res[i]);
                if (intVal!=-99){
                    map.put(i,new TreeNode(intVal));
                }
            }

            while (idx<res.length){
                if (map.containsKey(idx)) {
                    TreeNode root = map.get(idx);

                    if (map.containsKey(2*idx+1)) {
                        root.left = map.get(2*idx+1);
                    }

                    if (map.containsKey(2*idx+2)) {
                        root.right = map.get(2*idx+2);
                    }
                }
                idx++;
            }

            return map.get(0);
        }
    }


    public static void main(String[] args){

       TreeNode root=new TreeNode(1);
        TreeNode temp=root;
       for (int i=2;i<=50;i++){
           TreeNode node=new TreeNode(i);
           temp.right=node;
           temp=node;
       }
//       TreeNode left=new TreeNode(2);
//       TreeNode right=new TreeNode(3);
//       root.left=left;
//       root.right=right;
//
//
//        TreeNode right21=new TreeNode(6);
//        TreeNode right22=new TreeNode(7);
//        TreeNode right1=new TreeNode(4);
//        right1.left=right21;
//        right1.right=right22;
//        TreeNode right2=new TreeNode(5);
//       right.left=right1;
//       right.right=right2;



        Codec codec=new Codec();
       String result=codec.serialize(root);
       System.out.println(result);
       TreeNode newRoot=codec.deserialize(result);
       System.out.println(newRoot);


    }
}
