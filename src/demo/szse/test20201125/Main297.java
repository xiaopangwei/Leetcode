package demo.szse.test20201125;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/11/23
 * @time 11:30 AM
 */
public class Main297 {
    public static void main(String[] args){

    Main297 main297=new Main297();

    TreeNode node=new TreeNode(6);

        TreeNode lN=new TreeNode(4);

        TreeNode lNl=new TreeNode(1);
        TreeNode rN=new TreeNode(10);

        TreeNode rnr=new TreeNode(9);
        node.left=lN;
        node.right=rN;

        lN.left=lNl;
        rN.right=rnr;


//        String  str="null#6#4#10#1#null#null#9";
        String  str="     ";

    System.out.println(main297.deserialize(str));

    }
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> data  =new ArrayList<>();
        for (int i=0;i<1024;i++)
        {
            data.add(null);
        }

        serialize0(root,data,1);



        int maxLength=0;
        for (int i=data.size()-1;i>0;i--){
            if (data.get(i)!=null){
                maxLength=i;
                int parentIndex=maxLength/2;
                if (parentIndex*2==i){
                    maxLength++;
                }
                break;
            }
        }


        List<Integer> sub=new ArrayList<>(maxLength+1);

        for (int i=0;i<=maxLength;i++){

            sub.add(data.get(i));
        }

        String result=String.join("#",sub.stream().map(item->String.valueOf(item)).collect(Collectors.toList()));

        return result;
    }

    public void serialize0(TreeNode root,List<Integer> data,int index) {
        if (root==null)
        {
            return;
        }
        else{
            final int parentIndex=index;
            data.set(parentIndex,root.val);

            serialize0(root.left,data,2*index);
            serialize0(root.right,data,2*index+1);
        }
    }


    public void deserialize0(TreeNode root,String[] array,int index) {

        root.val=Integer.valueOf(array[index]);
        //left
        if (2*index<array.length) {
            String leftVal=array[2*index];
            if ("null".equals(leftVal))
            {
                root.left=null;
            }
            else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(leftVal));
                root.left = leftNode;
                deserialize0(leftNode, array, 2 * index);
            }
        }

        if (2*index+1<array.length) {
            String rightVal=array[2*index+1];
            if ("null".equals(rightVal))
            {
                root.right=null;
            }
            else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(rightVal));
                root.right = rightNode;
                deserialize0(rightNode, array, 2 * index+1);
            }
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data==null || data.trim().isEmpty()){
            return null;
        }
        String[] array=data.trim().split("#");

        if (array.length<=0){
            return null;
        }

        String rootValue=array[1].trim();
        if ("null".equals(rootValue)) {
            return null;
        }
        else{
            TreeNode treeNode=new TreeNode(Integer.parseInt(rootValue));
            deserialize0(treeNode,array,1);
            return treeNode;
        }

    }


}
