package leetcode.p2021m08;

import example.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 11:56 PM
 */
public class Solution133 {

    private Map<Integer, Node> state = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        state.put(node.val, newNode);
        Node       originalNode      = node;
        List<Node> originalNeighbors = originalNode.neighbors;

        for (Node oldNode : originalNeighbors) {
            if (!state.containsKey(oldNode.val)) {
                Node clonedNode = cloneGraph(oldNode);
                newNode.neighbors.add(clonedNode);
            } else {
                newNode.neighbors.add(state.get(oldNode.val));
            }

        }

        return newNode;
    }

    public static void main(String[] args) {
        Solution133 solution133 = new Solution133();
        Node        node1       = new Node(1);
        Node        node2       = new Node(2);
        Node        node3       = new Node(3);
        Node        node4       = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        Node newNode = solution133.cloneGraph(node1);

        System.out.println(node1+" "+node2+" "+node3+" "+node4);

        System.out.println(newNode.val+" "+newNode);
        Node a=newNode.neighbors.get(0);
        Node b=newNode.neighbors.get(1);
        System.out.println(a.val+" "+b.val+" "+a+" "+b);

        System.out.println(a.neighbors.get(0).val+" "+a.neighbors.get(1).val+" "+a.neighbors.get(0)+" "+a.neighbors.get(1));
        System.out.println(b.neighbors.get(0).val+" "+b.neighbors.get(1).val+" "+b.neighbors.get(0)+" "+b.neighbors.get(1));

    }
}
