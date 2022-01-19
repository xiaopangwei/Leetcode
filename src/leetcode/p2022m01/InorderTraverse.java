package leetcode.p2022m01;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 10:51 PM
 */
public class InorderTraverse {


    static class TreeNode {
        public int      val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode parent;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            if (this==null){
                return "null";
            }
            return String.valueOf(val);
        }
    }

    public TreeNode getNext(TreeNode root) {
        if (root.right != null) {
            TreeNode p = root.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            TreeNode parent = root.parent;
            if (parent == null) {
                return null;
            } else {
                if (parent.left == root) {
                    return parent;
                } else {
                    TreeNode q = root;
                    parent = q.parent;

                    while (true) {
                        if (parent == null) {
                            return null;
                        }
                        if (parent.left == q) {
                            return parent;
                        }

                        q = parent;
                        parent = parent.parent;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);


        root.left = n2;
        root.right = n3;

        n2.parent = root;
        n3.parent = root;

        n2.right = n4;
        n4.parent = n2;


        n3.left = n5;
        n3.right = n6;

        n5.parent = n3;
        n6.parent = n3;

        InorderTraverse traverse=new InorderTraverse();
        System.out.println(traverse.getNext(n6));

    }
}
