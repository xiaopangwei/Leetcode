package leetcode.shopee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/14
 * @time 1:53 PM
 */
public class SearchLeafNodeInBiTree {

    public List<Integer> ans=new ArrayList<>();
    static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
        }
    }

    public List<Integer> search(int[] preOrder){
        int[] inOrder=preOrder.clone();
        Arrays.sort(inOrder);
        int len=preOrder.length;
        Node root=createTree(preOrder,inOrder,0,len-1,
                0,len-1);
        searchLeafNode(root);
        return ans;

    }

    private int indexOf(int[] src,int start,int end,int target){
        for (int i=start;i<=end;i++){
            if (src[i]==target){
                return i;
            }
        }
        return -1;
    }

    private Node createTree(final int[] prevOrder,final int[] inOrder,int prevStartIndex,int prevEndIndex
                            ,int inStartIndex,int inEndIndex){

        if (prevEndIndex==prevStartIndex||inEndIndex==inStartIndex){
            return new Node(prevOrder[prevStartIndex]);
        }

        int rootVal=prevOrder[prevStartIndex];
        int indexInOrder=indexOf(inOrder,inStartIndex,inEndIndex,rootVal);
        Node root =new Node(rootVal);

        if (indexInOrder==inStartIndex){
            root.left=null;
        }
        else{
            int countNumber=indexInOrder-inStartIndex;

            Node left=createTree(prevOrder,inOrder,
                    prevStartIndex+1,countNumber+prevStartIndex,
                    inStartIndex,inStartIndex+countNumber-1);

            root.left=left;
        }

        if (indexInOrder==inEndIndex){
            root.right=null;
        }
        else{
            int countNumber=inEndIndex-indexInOrder;
            Node right=createTree(prevOrder,inOrder,
                    prevEndIndex-countNumber+1,prevEndIndex,
                    indexInOrder+1,inEndIndex);
            root.right=right;
        }

        return root;
    }




    public void searchLeafNode(Node root){
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null){
            ans.add(root.val);
        }
        if (root.left!=null){
            searchLeafNode(root.left);
        }
        if (root.right!=null){
            searchLeafNode(root.right);
        }
    }
    public static void main(String[] args){
        SearchLeafNodeInBiTree searchLeafNodeInBiTree=new SearchLeafNodeInBiTree();
        int[] pre=new int[]{9, 8, 7, 10};

        searchLeafNodeInBiTree.search(pre);
    }
}
