package leetcode.p2022m02;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/14
 * @time 10:49 PM
 */
public class MyHashMap {
    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int hashCode() {
            return key % 16;
        }
    }

    LinkedList<Node>[] head;

    public MyHashMap() {
        head = new LinkedList[16];
        for (int i = 0; i < head.length; i++) {
            head[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int              hashCode   = key % 16;
        LinkedList<Node> linkedList = head[hashCode];
        boolean          flag       = false;
        for (Node node : linkedList) {
            if (node.key == key) {
                node.value = value;
                flag = true;
                break;
            }
        }
        if (!flag) {
            linkedList.add(new Node(key, value));
        }
    }

    public int get(int key) {
        int              hashCode   = key % 16;
        LinkedList<Node> linkedList = head[hashCode];
        int              ans        = -1;
        for (Node node : linkedList) {
            if (node.key == key) {
                return node.value;
            }
        }
        return ans;
    }

    public void remove(int key) {
        int              hashCode   = key % 16;
        LinkedList<Node> linkedList = head[hashCode];
        Iterator<Node>   iterator   = linkedList.iterator();
        while (iterator.hasNext()) {
            Node t = iterator.next();
            if (t.key == key) {
                iterator.remove();
                break;
            }
        }
    }
}
