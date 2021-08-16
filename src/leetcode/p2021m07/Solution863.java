package leetcode.p2021m07;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 9:13 AM
 */
public class Solution863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        //子节点-》父亲
        Map<TreeNode,TreeNode> edge=new HashMap<>();
        dfs(root,edge);
        List<Integer> ans=new ArrayList<>();
        Map<Integer,Boolean> visited=new HashMap<>();
        visited.put(target.val,true);
        dfs(target,k,0,ans,visited,edge);
        return ans;
    }

    private void dfs(TreeNode root,Map<TreeNode,TreeNode> edge){
        if (root==null){
            return;
        }

        if (root.left!=null){
            edge.put(root.left,root);
            dfs(root.left,edge);
        }

        if (root.right!=null){
            edge.put(root.right,root);
            dfs(root.right,edge);
        }
    }


    private void dfs(TreeNode root, final int k,int level,List<Integer> ans,Map<Integer,Boolean> visited,
                     Map<TreeNode,TreeNode> edge){

        if (root==null){
            return;
        }
        if (level==k){
            ans.add(root.val);
            return;
        }
        if (level>k){
            return;
        }

        if (root.left!=null && !visited.containsKey(root.left.val)){
            visited.put(root.left.val,true);
            dfs(root.left,k,level+1,ans,visited,edge);
        }

        if (root.right!=null && !visited.containsKey(root.right.val)){
            visited.put(root.right.val,true);
            dfs(root.right,k,level+1,ans,visited,edge);
        }

        if (edge.containsKey(root)){
            TreeNode parent=edge.get(root);
            if (!visited.containsKey(parent.val)){
                visited.put(parent.val,true);
                dfs(parent,k,level+1,ans,visited,edge);
            }
        }
    }



//    private List<Integer> bfs(TreeNode root, final int level){
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        int depth=0;
//        while (!queue.isEmpty()){
//            List<Integer> sameLevel=new ArrayList<>();
//            for (int i=0;i<queue.size();i++){
//                TreeNode temp=queue.poll();
//                sameLevel.add(temp.val);
//                System.out.println(sameLevel);
//                if (temp.left!=null){
//                    queue.add(temp.left);
//                }
//                if (temp.right!=null){
//                    queue.add(temp.right);
//                }
//            }
//            if (depth==level){
//                return sameLevel;
//            }
//            depth++;
//        }
//        return null;
//    }



    public static void main(String[] args){
        Solution863 solution863=new Solution863();
        TreeNode root=TreeNode.ofArray("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode targetNode=TreeNode.search(root,3);
        List<Integer> ans=solution863.distanceK(root,targetNode,2);
        System.out.println(ans);
    }
}
