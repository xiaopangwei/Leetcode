package leetcode.p2022m05.day0507;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 10:10 PM
 */
public class RandomizedSet {
    Map<Integer, Integer> position;
    List<Integer>         data;
    Random random = new Random();

    public RandomizedSet() {
        data = new ArrayList<>();
        position = new HashMap<>();
    }

    public boolean insert(int val) {
        if (position.get(val) == null) {
            data.add(val);
            position.put(val, data.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (position.get(val) == null) {
            return false;
        }
        int index = position.get(val);
        position.remove(val);
        int lastVal = data.remove(data.size() - 1);
        if (index < data.size()) {
            data.set(index, lastVal);
            position.put(lastVal, index);
        }
        return true;
    }

    public int getRandom() {
        int index = random.nextInt(data.size());
        return data.get(index);
    }


    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));

    }
}
