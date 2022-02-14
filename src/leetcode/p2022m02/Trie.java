package leetcode.p2022m02;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/13
 * @time 9:02 PM
 */
public class Trie {

    static class Node {
        char ch;
        public boolean isTerminated = false;
        public Map<Character, Node> next;

        public Node(char ch) {
            this.ch = ch;
            this.next = new HashMap<>();
        }
    }

    Node root;

    public Trie() {
        root = new Node(' ');
    }

    public void insert(String word) {
        Node p   = root;
        int  len = word.length();
        for (int i = 0; i < len; i++) {
            char    ch   = word.charAt(i);
            boolean flag = (i == len - 1);
            if (p.next.containsKey(ch)) {
                p = p.next.get(ch);
            } else {
                Node node = new Node(ch);
                p.next.put(ch, node);
                p = node;
            }

            if (flag) {
                p.isTerminated = true;
            }
        }
    }

    public boolean search(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.next.containsKey(ch)) {
                p = p.next.get(ch);
            } else {
                return false;
            }
        }
        return p.isTerminated;
    }

    public boolean startsWith(String prefix) {
        Node p   = root;
        int  len = prefix.length();
        for (int i = 0; i < len; i++) {
            char ch = prefix.charAt(i);
            if (p.next.containsKey(ch)) {
                p = p.next.get(ch);
            } else {
                return false;
            }
        }
        return true;
    }


}
