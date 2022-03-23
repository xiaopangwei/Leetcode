package leetcode.p2022m03;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/8
 * @time 10:01 PM
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

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        //root[left,right]
        List<String> ans = new ArrayList<>();
        serialize(root, ans);
        String temp = String.join("", ans);
        return temp;
    }

    public void serialize(Node root, List<String> list) {
        //root[left,right]
        if (root == null) {
            return;
        }

        list.add(String.valueOf(root.val));

        if (root.children != null && !root.children.isEmpty()) {
            list.add("[");
            for (Node node : root.children) {
                serialize(node, list);
                list.add(",");
            }
            if (!list.isEmpty() && list.get(list.size() - 1).equalsIgnoreCase(",")) {
                list.remove(list.size() - 1);
            }
            list.add("]");
        }
    }

    //    1[3[5,6],2,4]
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        int           i         = 0;
        Stack<String> strStack  = new Stack<>();
        Stack<Node>   nodeStack = new Stack<>();
        while (i < data.length()) {
            char ch = data.charAt(i);
            if (ch == '[') {
                strStack.push("[");
                i++;
            } else if (ch == ']') {
                LinkedList<Node> linkedList = new LinkedList<>();
                while (!strStack.isEmpty() && !strStack.peek().equals("[")) {
                    strStack.pop();
                    linkedList.addFirst(nodeStack.pop());
                }
                strStack.pop();
                Node parent = nodeStack.peek();
                parent.children = linkedList;
                i++;
            } else if (ch == ',') {
                i++;
            } else {
                int j    = i + 1;
                int temp = data.charAt(i) - '0';
                while (j < data.length() && (data.charAt(j) >= '0' && data.charAt(j) <= '9')) {
                    temp = temp * 10 + data.charAt(j) - '0';
                    j++;
                }
                strStack.push(String.valueOf(temp));
                nodeStack.push(new Node(temp, new LinkedList<>()));
                i = j;
            }
        }
        return nodeStack.peek();
    }

    public static void main(String[] args) {
        Solution428 solution428 = new Solution428();

        Node node2 = new Node(2);
        Node node4 = new Node(4);

        Node   node3 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node   node1 = new Node(1, Arrays.asList(node3, node2, node4));
        String ans   = solution428.serialize(node1);

        System.out.println(ans);
        System.out.println("--------");
        Node newNode=solution428.deserialize(ans);


        System.out.println(newNode);
    }
}
