package leetcode.p2021m10;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/9
 * @time 9:57 AM
 */
public class SummaryRanges {
    TreeMap<Integer, Integer> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {

        if (map.isEmpty()) {
            map.put(val, val);
            return;
        }

        if (map.containsKey(val)) {
            return;
        }


        Map.Entry<Integer, Integer> moreThanEntry = map.ceilingEntry(val + 1);
        Map.Entry<Integer, Integer> lessThanEntry = map.floorEntry(val);

        if (lessThanEntry != null && lessThanEntry.getKey() <= val && lessThanEntry.getValue() >= val) {
            return;
        }
        if (moreThanEntry != null && lessThanEntry != null && lessThanEntry.getValue() + 1 == val && moreThanEntry.getKey() - 1 == val) {

            int left  = lessThanEntry.getKey();
            int right = moreThanEntry.getValue();
            map.remove(moreThanEntry.getKey());
            map.remove(lessThanEntry.getKey());
            map.put(left, right);

        } else if (lessThanEntry != null && lessThanEntry.getValue() + 1 == val) {

            int key = lessThanEntry.getKey();
            map.remove(key);
            map.put(key, val);

        } else if (moreThanEntry != null && moreThanEntry.getKey() - 1 == val) {

            int right = moreThanEntry.getValue();
            map.remove(moreThanEntry.getKey());
            map.put(val, right);

        } else {
            map.put(val, val);
        }

    }

    public int[][] getIntervals() {

        int     index = 0;
        int     size  = map.keySet().size();
        int[][] res   = new int[size][2];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res[index][0] = entry.getKey();
            res[index][1] = entry.getValue();
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(1, 2);
//        map.put(2, 3);
//        map.put(3, 4);
//        map.put(6, 8);
//        map.put(10, 15);

        //<=target
//        Map.Entry<Integer,Integer> e=map.floorEntry(2);
//        System.out.println(e.getKey()+" "+e.getValue());
//
//
//        e=map.floorEntry(7);
//        System.out.println(e.getKey()+" "+e.getValue());
//
//
//        e=map.floorEntry(-1);
//        System.out.println(e.getKey()+" "+e.getValue());


        //>=target
//        Map.Entry<Integer,Integer> e=map.ceilingEntry(2);
//        System.out.println(e.getKey()+" "+e.getValue());
//
//
//        e=map.ceilingEntry(7);
//        System.out.println(e.getKey()+" "+e.getValue());
//
//
//        e=map.ceilingEntry(4);
//        System.out.println(e.getKey()+" "+e.getValue());


        SummaryRanges summaryRanges = new SummaryRanges();
        int[]         arr           = new int[]{1, 3, 7, 2, 6};
        for (int item : arr) {
            summaryRanges.addNum(item);
            int[][] res = summaryRanges.getIntervals();
            System.out.println("------------=> "+item);
            for (int[] t : res) {
                System.out.println(Arrays.toString(t));
            }
            System.out.println("+++++++++++");
        }

    }
}
