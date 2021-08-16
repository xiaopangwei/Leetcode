package demo.szse.test20201123;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/11/23
 * @time 6:44 PM
 */
public class Main78 {

    public static void main(String[] args){
        Main78 main78=new Main78();
        main78.subsets(new int[]{1,2,3});
    }

    class TreeNode{
        int value;

        List<Integer> prev=new ArrayList<>();
        List<TreeNode> nodeList=new ArrayList<>();

        public TreeNode(int value){
            this.value=value;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean[] visited =new boolean[nums.length];
        for (int i=0;i<nums.length;i++){
            visited[i]=false;
        }

        for (int i=0;i<nums.length;i++)
        {
        TreeNode root=create(i,nums,visited);
        traverse(root,result);
        }

        result.add(new ArrayList<>());

        System.out.println(result);
        return result;

    }

    public TreeNode create(int startIndex,int[] numberArray,boolean[] visited){
        TreeNode root=new TreeNode(numberArray[startIndex]);
        visited[startIndex]=true;


        for (int i=startIndex+1;i<numberArray.length;i++){

            if (!visited[i]){
                TreeNode child=create(i,numberArray,visited);
                root.nodeList.add(child);
            }
        }


        visited[startIndex]=false;
        return root;

    }

    public void traverse(TreeNode node,List<List<Integer>> result){

        Queue<TreeNode> queue=new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()){
            TreeNode treeNode=queue.poll();
            if (!treeNode.prev.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                temp.addAll(treeNode.prev);
                temp.add(treeNode.value);
                result.add(temp);
            }
            else{
                List<Integer> a1=new ArrayList<>();
                a1.add(treeNode.value);
                result.add(a1);
            }

            for (TreeNode item:treeNode.nodeList) {
                if (!treeNode.prev.isEmpty()){
                    item.prev.addAll(treeNode.prev);
                }
                item.prev.add(treeNode.value);
                queue.add(item);
            }
        }

//        System.out.println(result);
    }
}
