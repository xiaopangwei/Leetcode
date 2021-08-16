package leetcode.p2021m08;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 2:32 PM
 */
public class LFUCache {
    static class BiEntry {
        public int  k;
        public int  v;
        public int  times;
        public long timeStamp;

        public BiEntry(int k, int v, int times) {
            this.k = k;
            this.v = v;
            this.times = times;
            this.timeStamp = System.nanoTime();
        }
    }

    int maxCapacity;

    PriorityQueue<BiEntry> queue   = new PriorityQueue<>(new Comparator<BiEntry>() {
        @Override
        public int compare(BiEntry o1, BiEntry o2) {
            if (o1.times != o2.times) {
                return o1.times - o2.times;
            } else if (o1.timeStamp != o2.timeStamp) {
                return (int) (o1.timeStamp - o2.timeStamp);
            }
            return 0;
        }
    });
    Map<Integer, BiEntry>  dataMap = new HashMap<>();

    public LFUCache(int capacity) {
        maxCapacity = capacity;
    }

    public int get(int key) {

        if (!dataMap.containsKey(key)) {
//            System.out.println("get " + key + " res:-1");
            return -1;
        }
        BiEntry biEntry = dataMap.get(key);
        int     temp    = biEntry.v;
        queue.remove(biEntry);
        biEntry.timeStamp = System.nanoTime();
        biEntry.times++;
        queue.add(biEntry);
        dataMap.put(key, biEntry);
//        System.out.println("get " + key + " res:" + temp);
        return temp;
    }

    public void put(int key, int value) {
        if (!dataMap.containsKey(key)) {
            if (dataMap.keySet().size() < maxCapacity) {
                BiEntry entry = new BiEntry(key, value, 1);
                queue.add(entry);
                dataMap.put(key, entry);
            } else {
                BiEntry minEntry = queue.poll();
                if (minEntry != null) {
                    dataMap.remove(minEntry.k);
                    BiEntry entry = new BiEntry(key, value, 1);
                    queue.add(entry);
                    dataMap.put(key, entry);
                }
            }
        } else {
            BiEntry entry = dataMap.get(key);
            queue.remove(entry);
            entry.v = value;
            entry.timeStamp = System.nanoTime();
            entry.times++;
            queue.add(entry);
        }
    }

    public static void main(String[] args) {
        // cnt(x) = 键 x 的使用计数
        // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
        LFUCache lFUCache = new LFUCache(3);
        lFUCache.put(1, 1);
        lFUCache.put(2, 2);
        lFUCache.put(3, 3);
        lFUCache.put(4, 4);

        lFUCache.get(4);
        lFUCache.get(3);
        lFUCache.get(2);
        lFUCache.get(1);

        lFUCache.put(5, 5);

        lFUCache.get(1);
        lFUCache.get(2);
        lFUCache.get(3);
        lFUCache.get(4);
        lFUCache.get(5);


    }
}
