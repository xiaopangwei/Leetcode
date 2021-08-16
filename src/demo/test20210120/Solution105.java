package demo.test20210120;

/**
 * Definition for a binary tree node.
 *
 **/
class TreeNode1 {
      int       val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class Solution105 {
    public TreeNode1 buildTree(int[] preorder, int[] inorder) {

        int len=preorder.length;
        return dfs(preorder,inorder,0,len-1,0,len-1);

    }

    private int indexOf(int[] val,int left,int right,int target){
        for(int i=left;i<=right;i++){
            int item=val[i];
            if(item==target){
                return i;
            }
        }
        return -1;
    }

    public TreeNode1 dfs(int[] preorder,
                         int[] inorder,
                         int a1, int a2,
                         int b1, int b2)

    {
        if(a1==a2 || b1==b2){
            return new TreeNode1(preorder[a1]);
        }

        int       rootVal      =preorder[a1];
        TreeNode1 root         =new TreeNode1(rootVal);
        int       inOrderIndex =indexOf(inorder,b1,b2,rootVal);
        //left
        //[start,inOrder-1]
        if(inOrderIndex==b1){
            root.left=null;
        }
        else{
            int leftCount=inOrderIndex-b1;
            //preOrder a1+1...a1+index-b1
            //inOrder  b1.....index-1
            if (a1+leftCount<preorder.length && inOrderIndex-1<preorder.length) {
                TreeNode1 leftNode = dfs(preorder, inorder, a1 + 1, a1 + leftCount, b1, inOrderIndex - 1);
                root.left = leftNode;
            }
        }
        //right
        //[inOrder+1,end]
        if(inOrderIndex==b2){
            root.right=null;
        }
        else{
            int rightCount=b2-inOrderIndex;
            if (a2-rightCount+1<preorder.length && b2<preorder.length) {
                TreeNode1 rightNode = dfs(preorder, inorder, a2 - rightCount + 1, a2, inOrderIndex + 1, b2);
                root.right = rightNode;
            }
        }

        return root;
    }

    public static void main(String[] args){

        Solution105 solution105 =new Solution105();
        int[]       prev        =new int[]{1,2,3};
        int[]       inorder     =new int[]{1,2,3};
        TreeNode1   node        =solution105.buildTree(prev,inorder);
        System.out.print(node);
    }
}