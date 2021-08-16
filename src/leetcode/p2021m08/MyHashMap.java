package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 4:22 PM
 */
public class MyHashMap {
    private List<List<int[]>>  valueList;
    private List<Set<Integer>> keyList;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

        valueList = new ArrayList<>();
        keyList = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            valueList.add(i, new ArrayList<>());
            keyList.add(i, new HashSet<>());
        }
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {

        Integer obj      = Integer.valueOf(key);
        int     hashcode = obj.hashCode();
        int     idx      = hashcode % 16;

        if (keyList.get(idx).contains(key)) {
            List<int[]> list = valueList.get(idx);
            for (int i = 0; i < list.size(); i++) {
                int[] array = list.get(i);
                if (array[0] == key) {
                    list.set(i, new int[]{array[0], value});
                }
            }
        } else {
            valueList.get(idx).add(new int[]{key, value});
            keyList.get(idx).add(key);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        Integer obj      = Integer.valueOf(key);
        int     hashcode = obj.hashCode();
        int     idx      = hashcode % 16;
        if (!keyList.get(idx).contains(key)) {
            return -1;
        } else {
            List<int[]> list = valueList.get(idx);
            for (int i = 0; i < list.size(); i++) {
                int[] array = list.get(i);
                if (array[0] == key) {
                    return array[1];
                }
            }
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        Integer obj      = Integer.valueOf(key);
        int     hashcode = obj.hashCode();
        int     idx      = hashcode % 16;
        if (keyList.get(idx).contains(key)) {
            List<int[]>     list     = valueList.get(idx);
            Iterator<int[]> iterator = list.iterator();
            while (iterator.hasNext()) {
                int[] array = iterator.next();
                if (array[0] == key) {
                    iterator.remove();
                }
            }
            keyList.get(idx).remove(key);
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        int       temp      = 0;
        temp = myHashMap.get(11);
        System.out.println(temp);
        myHashMap.put(1, 2);
        System.out.println(myHashMap.get(1));
        myHashMap.put(1, 3);
        System.out.println(myHashMap.get(1));
        myHashMap.put(2, 4);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(3);
        System.out.println(myHashMap.get(3));
        temp = myHashMap.get(1);
        System.out.println(temp);
        temp = myHashMap.get(2);
        System.out.println(temp);
        myHashMap.put(2,100);
        System.out.println(myHashMap.get(2));
    }
}
