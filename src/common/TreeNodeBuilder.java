package common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/4
 * @time 9:22 PM
 */
public class TreeNodeBuilder {
    public static void main(String[] args) {
        TreeNode root = TreeNodeBuilder.build("[1,null,2,3,4]");
        System.out.println(root);
    }

    public static TreeNode build(String str) {
        if (str.length() == 2) {
            return null;
        }
        String   sub   = str.substring(1, str.length() - 1);
        String[] array = sub.split(",");
        TreeNode root  = bfs(array);
//        System.out.println(root);
        return root;
    }

    private static TreeNode dfs(String[] array, int index) {
        if (index >= array.length) {
            return null;
        }
        int      rootVal = Integer.parseInt(array[index]);
        TreeNode root    = new TreeNode(rootVal);

        int leftIndex  = index * 2 + 1;
        int rightIndex = leftIndex + 1;

        if (leftIndex < array.length && !"null".equals(array[leftIndex])) {
            root.left = dfs(array, leftIndex);
        }

        if (rightIndex < array.length && !"null".equals(array[rightIndex])) {
            root.right = dfs(array, rightIndex);
        }
        return root;
    }

    private static TreeNode bfs(String[] array) {

        TreeNode root=new TreeNode(Integer.parseInt(array[0]));

        int i=0;
        int len=array.length;

        LinkedList<TreeNode> linkedList=new LinkedList<>();
        linkedList.add(root);
        while (i<len){
            i++;
            TreeNode temp=linkedList.pollFirst();
            if (i>=len){return root;}
            if ("null".equals(array[i])){
                temp.left=null;
            }else{
                temp.left=new TreeNode(Integer.parseInt(array[i]));
                linkedList.add(temp.left);
            }


            i++;
            if (i>=len){return root;}
            if ("null".equals(array[i])){
                temp.right=null;
            }else{
                temp.right=new TreeNode(Integer.parseInt(array[i]));
                linkedList.add(temp.right);
            }
        }
        return root;
    }
}
