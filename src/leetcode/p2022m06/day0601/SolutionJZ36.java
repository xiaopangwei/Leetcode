package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 9:51 PM
 */
public class SolutionJZ36 {
    static class Node {
        public int  val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }

        public static SolutionJZ36.Node ofArray(String str) {
            String   sub   = str.substring(1, str.length() - 1);
            String[] array = sub.split(",");
            String   first = array[0].trim();
            if (first.equalsIgnoreCase("null")) {
                return null;
            }
            SolutionJZ36.Node root = create(array, 0);
            return root;
        }

        private static SolutionJZ36.Node create(String[] array, int start) {
            if (start < 0 || start >= array.length) {
                return null;
            }
            if ("null".equalsIgnoreCase(array[start])) {
                return null;
            }
            SolutionJZ36.Node left  = create(array, 2 * start + 1);
            SolutionJZ36.Node right = create(array, 2 * start + 2);

            SolutionJZ36.Node root = new SolutionJZ36.Node(Integer.parseInt(array[start]));

            root.left = left;
            root.right = right;
            return root;
        }
    }


    Node head = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        dfs(root);

        if (head != null) {
            head.left = last;
        }
        if (last != null) {
            last.right = head;
        }
        return head;
    }


    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        Node left  = root.left;
        Node right = root.right;

        dfs(left);

        if (head == null) {
            head = root;
        } else {
            last.right = root;
            root.left = last;
        }
        last = root;
        dfs(right);
    }

    public static void main(String[] args) {
        SolutionJZ36 solutionJZ36 = new SolutionJZ36();
        Node         root         = solutionJZ36.treeToDoublyList(Node.ofArray("[4,2,5,1,3]"));
        System.out.println(root);
    }
}
