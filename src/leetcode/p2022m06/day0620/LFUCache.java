package leetcode.p2022m06.day0620;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/22
 * @time 11:11 PM
 */
public class LFUCache {

    class LFUNode {
        int key;
        int value;
        public int  cnt;
        public long version;

        public LFUNode(int k, int v) {
            this.key = k;
            this.value = v;
            this.cnt = 1;
            this.version = 0;

        }
    }

    Map<Integer, LFUNode> map;
    TreeSet<LFUNode>      treeSet;
    int                   capacity;
    long version = 0;

    public LFUCache(int capacity) {
        this.map = new HashMap<>();
        this.treeSet = new TreeSet<>(new Comparator<LFUNode>() {
            @Override
            public int compare(LFUNode o1, LFUNode o2) {
                if (o1.cnt != o2.cnt) {
                    return o1.cnt - o2.cnt;
                } else {
                    return (int) (o1.version - o2.version);
                }
            }
        });
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LFUNode node = map.remove(key);
            map.remove(node.key);
            treeSet.remove(node);
            node.cnt++;
            node.version = version++;
            treeSet.add(node);
            map.put(key, node);
            return node.value;
        }
        return -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            LFUNode node = map.remove(key);
            node.cnt++;
            node.value = value;
            node.version = version++;
            treeSet.add(node);
        } else {

            if (map.keySet().size() < this.capacity) {
                LFUNode node = new LFUNode(key, value);
                node.version = version++;
                treeSet.add(node);
                map.put(key, node);
            } else {
                LFUNode head = treeSet.pollFirst();
                if (head != null) {
                    map.remove(head.key);
                    treeSet.remove(head);
                }
                LFUNode node = new LFUNode(key, value);
                node.version = version++;
                treeSet.add(node);
                map.put(key, node);
            }
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
//
//["LFUCache","put","put","get","put","get","get","put","get","get","get"]
//[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3, 3);
        System.out.println(lfuCache.get(2));
    }
}
