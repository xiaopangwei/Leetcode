package leetcode.p2022m05.day0516;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 10:48 PM
 */
//432
public class AllOne {

    public Map<String, Integer>          freq;
    public TreeMap<Integer, Set<String>> setMap;

    public AllOne() {
        freq = new HashMap<>();
        setMap = new TreeMap<>();
    }

    public void inc(String key) {
        int old     = freq.getOrDefault(key, 0);
        int newFreq = old + 1;
        freq.put(key, newFreq);

        if (setMap.containsKey(old)) {
            setMap.get(old).remove(key);
            if (setMap.get(old).isEmpty()) {
                setMap.remove(old);
            }
        }

        if (!setMap.containsKey(newFreq)) {
            setMap.put(newFreq, new HashSet<>());
        }
        setMap.get(newFreq).add(key);
    }

    public void dec(String key) {
        int old     = freq.getOrDefault(key, 0);
        int newFreq = old - 1;
        if (newFreq <= 0) {
            freq.remove(key);
        } else {
            freq.put(key, newFreq);
        }
        if (setMap.containsKey(old)) {
            setMap.get(old).remove(key);
            if (setMap.get(old).isEmpty()) {
                setMap.remove(old);
            }
        }
        if (newFreq > 0) {
            if (!setMap.containsKey(newFreq)) {
                setMap.put(newFreq, new HashSet<>());
            }
            setMap.get(newFreq).add(key);
        }

    }

    public String getMaxKey() {
        if (setMap.isEmpty()) {
            return "";
        } else {
            Set<String> set = setMap.lastEntry().getValue();
            if (set.isEmpty()) {
                return "";
            } else {
                return set.iterator().next();
            }
        }
    }

    public String getMinKey() {
        if (setMap.isEmpty()) {
            return "";
        } else {
            Set<String> set = setMap.firstEntry().getValue();
            if (set.isEmpty()) {
                return "";
            } else {
                return set.iterator().next();
            }
        }
    }

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");

        System.out.println(allOne.setMap);
        System.out.println(allOne.freq);
        System.out.println(allOne.getMinKey()); // 返回 "hello"
        allOne.dec("a");
        System.out.println(allOne.getMaxKey()); // 返回 "hello"
        System.out.println(allOne.getMinKey()); // 返回 "leet"

    }
}
