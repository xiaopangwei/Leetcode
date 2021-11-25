package leetcode.p2021m11;


import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/25
 * @time 9:44 PM
 */
abstract class Node {
    public abstract int evaluate();
    // define your fields here
}

class BiNode extends Node {
    boolean opr;
    String  val;
    BiNode  left;
    BiNode  right;

    public BiNode(String val, boolean opr) {
        this.val = val;
        this.opr = opr;
    }

    @Override
    public int evaluate() {
        return dfs(this);
    }

    private int dfs(BiNode root) {
        if (!root.opr) {
            return Integer.parseInt(root.val);
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        switch (root.val) {
            case "+":
                return l + r;
            case "-":
                return l - r;
            case "*":
                return l * r;
            case "/":
                return l / r;
        }

        return -1;

    }
}

public class TreeBuilder {
    Node buildTree(String[] postfix) {

        Stack<BiNode> stack = new Stack<>();

        int i = 0;
        while (i < postfix.length) {
            String t = postfix[i];
            if ("+".equals(t) || "-".equals(t) || "*".equals(t) || "/".equals(t)) {
                BiNode first  = stack.pop();
                BiNode second = stack.pop();
                BiNode root   = new BiNode(t, true);
                root.right = first;
                root.left = second;
                stack.push(root);
            } else {
                BiNode root = new BiNode(t, false);
                stack.push(root);
            }
            i++;
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[]    arr         = new String[]{"100","200","+","2","/","5","*","7","+"};
        TreeBuilder treeBuilder = new TreeBuilder();
        Node        node        = treeBuilder.buildTree(arr);
        System.out.println(node.evaluate());
    }
}
