package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/28
 * @time 10:33 PM
 */
public class Solution428 {
    static class Node {
        public int        val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //1[2,3[6,7[11[14]]],4[8[12]],5[9[13],10]]
    public String serialize(Node root) {
        if (root == null) {
            return null;
        }
        List<String> data = new ArrayList<>();
        serialize0(root, data);
        String ans = String.join("", data);
        System.out.println(ans);
        return ans;
    }

    public void serialize0(Node root, List<String> list) {
        //[root,[left,right]]
        if (root == null) {
            return;
        } else {

            list.add(String.valueOf(root.val));

            if (root.children != null && !root.children.isEmpty()) {
                list.add("[");
                for (Node child : root.children) {
                    serialize0(child, list);
                    list.add(",");
                }
                if (list.get(list.size() - 1).equals(",")) {
                    list.remove(list.size() - 1);
                }
                list.add("]");
            }


        }
    }

    //1[2,3[6,7[11[14]]],4[8[12]],5[9[13],10]]
    public Node deserialize(String data) {

        if (data == null) {
            return null;
        }
//        System.out.println(Arrays.toString(arr));
        Stack<String> stack     = new Stack<>();
        Stack<Node>   nodeStack = new Stack<>();
        int           i         = 0;

//        1[3[5,6],2,4]
        while (i < data.length()) {
            if (data.charAt(i) == '[') {
                stack.push("[");
                i++;
            } else if (data.charAt(i) == ']') {

                LinkedList<Node> children = new LinkedList<>();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    stack.pop();
                    children.addFirst(nodeStack.pop());
                }
                stack.pop();

                Node parent = nodeStack.peek();
                parent.children = children;

                i++;
            } else if (data.charAt(i) == ',') {
                i++;
            } else {
                int temp = data.charAt(i) - '0';
                int j    = i + 1;
                while (j < data.length() && (data.charAt(j) >= '0' && data.charAt(j) <= '9')) {
                    temp = temp * 10 + (data.charAt(j) - '0');
                    j++;
                }

                i = j;

//                System.out.println("add " + temp);
                nodeStack.push(new Node(temp, new LinkedList<>()));
                stack.push(String.valueOf(temp));
            }

        }

        return nodeStack.peek();
    }


    private static Map<Integer, Node> gen() {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i < 15; i++) {
            map.put(i, new Node(i, new LinkedList<>()));
        }
        return map;
    }

    public static void main(String[] args) {

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node3 = new Node(3);
        node3.children = Arrays.asList(node5, node6);


        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node node1 = new Node(1);
        node1.children = Arrays.asList(node3, node2, node4);

//        Map<Integer, Node> map = gen();
//        map.get(1).children.add(map.get(2));
//        map.get(1).children.add(map.get(3));
//        map.get(1).children.add(map.get(4));
//        map.get(1).children.add(map.get(5));
//
//
//        map.get(3).children.add(map.get(6));
//        map.get(3).children.add(map.get(7));
//
//        map.get(7).children.add(map.get(11));
//        map.get(11).children.add(map.get(14));
//
//        map.get(4).children.add(map.get(8));
//        map.get(8).children.add(map.get(12));
//
//        map.get(5).children.add(map.get(9));
//        map.get(5).children.add(map.get(10));
//
//        map.get(9).children.add(map.get(13));


        Solution428 solution428 = new Solution428();
//        String      ans         = solution428.serialize(node1);
//        System.out.println(ans);
//
//        Node root=solution428.deserialize("1[3[5,6],2,4]");
//        System.out.println(root);


        String str  = solution428.serialize(node2);
        Node   root = solution428.deserialize(str);
        System.out.println(root);
    }
}
