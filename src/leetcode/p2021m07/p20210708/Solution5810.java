package leetcode.p2021m07.p20210708;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/11
 * @time 11:20 PM
 */
public class Solution5810 {

      static class TreeNode {
          int val;TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
             this.right = right;
          }
      }

      private List<List<Integer>> getLeafNode(List<TreeNode> trees){
          List<List<Integer>> ans=new ArrayList<>();
          for (TreeNode root:trees){
              List<Integer> leaf=new ArrayList<>();
              if (root.left==null && root.right==null){
                  leaf.add(root.val);
              }
              if (root.left!=null){
                  leaf.add(root.left.val);
              }
              if (root.right!=null){
                  leaf.add(root.right.val);
              }
              ans.add(leaf);

          }
          return ans;
      }

    public TreeNode canMerge(List<TreeNode> trees) {

          return null;

    }

    private TreeNode merge(List<TreeNode> trees,int source,int target,boolean[] visited,List<List<Integer>> leafNodesList){
        List<Integer> leaves=leafNodesList.get(target);
        TreeNode sourceRoot=trees.get(source);
        TreeNode targetRoot=trees.get(target);
        if (leaves.contains(sourceRoot.val)){
            visited[source]=true;
            if (targetRoot.val==sourceRoot.val){
                targetRoot=sourceRoot;
            }else if (targetRoot.left.val==sourceRoot.val){
                targetRoot.left=sourceRoot;
            }else{
                targetRoot.right=sourceRoot;
            }
            for (int i=0;i<trees.size();i++){
                for (int j=0;j<trees.size();j++){
                    if (i!=j && !visited[i] && !visited[j]){

                    }
                }
            }

            visited[source]=false;
        }

        return null;
    }
}
