package leetcode.p2021m12;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 11:10 AM
 */
public class Solution1650 {
    static class Node {
        public int  val;
        public Node left;
        public Node right;
        public Node parent;
    }

    ;

    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) {
            return null;
        }
        Set<Node> parents = new HashSet<>();
        Node      t1      = p;
        while (t1 != null) {
            parents.add(t1);
            t1 = t1.parent;
        }

        Node t2 = q;
        while (t2 != null) {
            if (parents.contains(t2)) {
                return t2;
            } else {
                t2 = t2.parent;
            }
        }

        return null;
    }

}
