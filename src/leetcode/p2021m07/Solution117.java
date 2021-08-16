package leetcode.p2021m07;

import com.sun.tools.corba.se.idl.StringGen;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 4:19 PM
 */
public class Solution117 {
    static  class Node {
        public int              val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        public static Node ofArray(String str){
            String sub=str.substring(1,str.length()-1);
            String[] array=sub.split(",");
            String first=array[0].trim();
            if (first.equals("null")){
                return null;
            }
            Node root=create(array,0);
            return root;
        }

        private static Node create(String[] array,int start){
            if(start<0 || start>=array.length){
                return null;
            }
            if ("null".equals(array[start])){
                return null;
            }
            Node left=create(array,2*start+1);
            Node right=create(array,2*start+2);

            Node  root=new Node(Integer.parseInt(array[start]));

            root.left=left;
            root.right=right;
            return root;
        }

    }
    public Node connect(Node root) {

       if (root==null){
           return null;
       }
       if (root.left!=null){
           if (root.right==null){
               Node nextNode=getNextNode(root.next);
               display(root.left,nextNode);
               root.left.next=nextNode;
           }
           else{
               display(root.left,root.right);
               root.left.next=root.right;
           }
       }
       if (root.right!=null){
           Node temp=getNextNode(root.next);
           display(root.right,temp);
           root.right.next=temp;
       }

       connect(root.left);
        connect(root.right);

        return root;
    }

    public void display(Node prev,Node next){
        int a=-1;
        if (prev!=null){
            a=prev.val;
        }
        int b=-1;
        if (next!=null){
            b=next.val;
        }
        String temp1= String.valueOf(a);
        if (a==-1){
            temp1="NULL";
        }
        String temp2= String.valueOf(b);
        if (b==-1){
            temp2="NULL";
        }
        System.out.println(temp1+" ==> "+temp2);

    }
    public Node getNextNode(Node root){
        if (root==null){
            return null;
        }
        if (root.left!=null) {return root.left;}
        else if (root.right!=null) {return root.right;}
        else if (root.next!=null) {
            return getNextNode(root.next);
        }
        return null;
    }

    public static void main(String[] args){
        Solution117 solution117=new Solution117();
        Node temp=Node.ofArray("[2,1,3,0,7,9,1,2,null,1,0,null,null,8,8,null,null,null,null,7]");
        Node root=solution117.connect(temp);
        System.out.println(root);
    }
}
