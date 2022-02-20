package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 2:15 PM
 */
public class Solution133 {


    static class Node {
        public int        val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    Map<Node, Node> nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        Node cloned = new Node(node.val);
        nodeMap.put(node, cloned);
        for (Node t : node.neighbors) {
            cloned.neighbors.add(cloneGraph(t));
        }

        return cloned;
    }
}
