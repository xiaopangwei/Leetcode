package leetcode.p2022m07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/29
 * @time 10:24 PM
 */
public class AllOne {

    static class Node {
        public Node prev;
        public Node next;
        int         freq;
        Set<String> sets;

        public Node(int freq) {
            this.freq = freq;
            sets = new HashSet<>();
        }

        public void add(String str) {
            sets.add(str);
        }

        public void remove(String str) {
            sets.remove(str);
        }

    }

    Map<String, Node> positionMap;
    Node              head;
    Node              last;

    public AllOne() {
        positionMap = new HashMap<>();
        head = new Node(0);
    }

    public void inc(String key) {
        if (positionMap.containsKey(key)) {
            Node node = positionMap.get(key);
            node.remove(key);
            if (node.next != null) {
                if (node.next.freq == node.freq + 1) {
                    node.next.sets.add(key);
                    positionMap.put(key, node.next);
                } else {
                    Node next    = node.next;
                    Node newNode = new Node(node.freq + 1);
                    newNode.add(key);
                    newNode.prev = node;
                    newNode.next = next;
                    node.next = newNode;
                    next.prev = newNode;
                    positionMap.put(key, newNode);
                }
            } else {
                Node newNode = new Node(node.freq + 1);
                positionMap.put(key, newNode);
                newNode.add(key);
                newNode.prev = node;
                node.next = newNode;
                last = newNode;
            }
            if (node.sets.isEmpty()) {
                node.prev.next = node.next;
                if (last == node) {
                    last = node.prev;
                }
            }
        } else {
            Node next = head.next;

            if (next != null && next.freq == 1) {
                next.add(key);
                positionMap.put(key, next);
            } else {
                Node newNode = null;
                newNode = new Node(1);
                newNode.add(key);
                newNode.prev = head;
                newNode.next = next;
                head.next = newNode;
                positionMap.put(key, newNode);
                newNode.add(key);
                if (next != null) {
                    next.prev = newNode;
                }
                if (last == null) {
                    last = newNode;
                }
            }

        }
//        print();

    }

    public void dec(String key) {

        Node node = positionMap.get(key);
        node.remove(key);

        if (node.prev != null) {
            if (node.prev.freq == node.freq - 1) {
                node.prev.sets.add(key);
                positionMap.put(key, node.prev);
            } else {
                Node prev    = node.prev;
                Node newNode = new Node(node.freq - 1);
                newNode.sets.add(key);
                newNode.prev = prev;
                newNode.next = node;
                prev.next = newNode;
                node.prev = newNode;
                positionMap.put(key, newNode);
            }
        } else {
            Node newNode = new Node(node.freq - 1);
            newNode.next = node;
            node.prev = newNode;
            newNode.sets.add(key);
            positionMap.put(key, newNode);
        }

        if (node.sets.isEmpty()) {
            node.prev.next = node.next;
            if (last == node) {
                last = node.prev;
            }
        }
//        print();

    }

    public String getMaxKey() {
        Node p = last;
        if (p != null) {
            for (String s : p.sets) {
                return s;
            }
        }
        return "";
    }

    public String getMinKey() {
        Node p = head.next;
        if (p != null) {
            for (String s : p.sets) {
                return s;
            }
        }
        return "";
    }


    void print() {
        System.out.println("------------------------");
        Node p = head.next;
        while (p != null) {
            System.out.print(p.sets + " " + p.freq + " \t");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("goodbye");
        allOne.inc("hello");
        allOne.inc("hello");
        System.out.println(allOne.getMaxKey());

        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");


        allOne.dec("hello");

        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");

        System.out.println(allOne.getMaxKey());


    }
}
