package leetcode.p2022m01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/5
 * @time 10:38 PM
 */
public class MyLFUCache {
    static class LFUNode {
        int key;
        int value;
        public int cnt;
        public int version;

        public LFUNode(int key, int value, int version) {
            this.key = key;
            this.value = value;
            this.cnt = 1;
            this.version = version;
        }
    }

    int                   capacity;
    Map<Integer, LFUNode> map;
    TreeSet<LFUNode>      treeSet;
    int version = 0;

    public MyLFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        treeSet = new TreeSet<>(new Comparator<LFUNode>() {
            @Override
            public int compare(LFUNode o1, LFUNode o2) {
                if (o1.cnt != o2.cnt) {
                    return o1.cnt - o2.cnt;
                } else {
                    return o1.version - o2.version;
                }
            }
        });
    }

    public int get(int key) {
        if (this.capacity <= 0) {
            return -1;
        } else if (map.containsKey(key)) {
            LFUNode lfuNode = map.get(key);
            treeSet.remove(lfuNode);
            lfuNode.cnt++;
            lfuNode.version = version++;
            treeSet.add(lfuNode);
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LFUNode lfuNode = map.get(key);
            treeSet.remove(lfuNode);
            lfuNode.cnt++;
            lfuNode.version = version++;
            lfuNode.value = value;
            treeSet.add(lfuNode);
        } else {
            int size = map.entrySet().size();
            if (size < capacity) {
                LFUNode lfuNode = new LFUNode(key, value, version++);
                map.put(key, lfuNode);
                treeSet.add(lfuNode);
            } else {
                LFUNode temp = treeSet.pollFirst();
                if (temp != null) {
                    map.remove(temp.key);
                }

                LFUNode lfuNode = new LFUNode(key, value, version++);
                treeSet.add(lfuNode);
                map.put(key, lfuNode);
            }
        }
    }

    public static void main(String[] args) {
        MyLFUCache lfu = new MyLFUCache(0);
        lfu.put(1, 1);
        lfu.put(2, 2);
        System.out.println(lfu.get(1));
        lfu.put(3, 3);
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));

    }
}
