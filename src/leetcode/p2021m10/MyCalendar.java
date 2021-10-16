package leetcode.p2021m10;

import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/16
 * @time 11:35 AM
 */
public class MyCalendar {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {

        treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer k1 = treeMap.floorKey(start);
        Integer k2 = treeMap.ceilingKey(start);

        if ((k1 == null || treeMap.get(k1) <= start) && (k2 == null || k2 >= end)) {
            treeMap.put(start, end);
            return true;
        }

        return false;
    }
}
