package common;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 10:09 AM
 */
public class TreeNode {

      public  int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
      }
      public static TreeNode ofArray(String str){
          String sub=str.substring(1,str.length()-1);
          String[] array=sub.split(",");
          String first=array[0].trim();
          if (first.equals("null")){
              return null;
          }
          TreeNode root=create(array,0);
          return root;
      }

      private static TreeNode create(String[] array,int start){
          if(start<0 || start>=array.length){
              return null;
          }
          if ("null".equals(array[start])){
              return null;
          }
          TreeNode left=create(array,2*start+1);
          TreeNode right=create(array,2*start+2);

          TreeNode  root=new TreeNode(Integer.parseInt(array[start]));

          root.left=left;
          root.right=right;
          return root;
      }

      public static void main(String[] args){
          TreeNode root=TreeNode.ofArray("[2,2,5,null,null,5,7]");
          System.out.println(root);
      }

    public  static TreeNode search(TreeNode root,int value){
        if (root==null){
            return null;
        }

        if (root.val==value){
            return root;
        }
        else{
            TreeNode left=search(root.left,value);
            if (left!=null){
                return left;
            }

            TreeNode right=search(root.right,value);

            if (right!=null){
                return right;
            }else{
                return null;
            }
        }
    }
}
