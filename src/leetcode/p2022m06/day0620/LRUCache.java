package leetcode.p2022m06.day0620;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/22
 * @time 10:57 PM
 */
public class LRUCache {

    class LRUNode {
        int k;
        int v;

        public LRUNode(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    Map<Integer, LRUNode> cacheMap;
    LinkedList<LRUNode> list = new LinkedList();
    int capacity;

    public LRUCache(int capacity) {
        this.cacheMap = new HashMap<>();
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        LRUNode node = cacheMap.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (!cacheMap.containsKey(key)) {
            if (list.size() < capacity) {
                LRUNode node = new LRUNode(key, value);
                cacheMap.put(key, node);
                list.addFirst(node);
            } else {
                LRUNode last = list.getLast();
                cacheMap.remove(last.k);
                list.remove(last);

                LRUNode node = new LRUNode(key, value);
                cacheMap.put(key, node);
                list.addFirst(node);
            }
        } else {
            LRUNode t = cacheMap.get(key);
            list.remove(t);
            t.v = value;
            list.addFirst(t);
        }
    }

}
