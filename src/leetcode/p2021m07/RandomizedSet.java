package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 5:30 PM
 */
public class RandomizedSet {
    private int count=0;
    private Map<Integer,Integer> map=new HashMap<>();
    private List<Integer> data=new ArrayList<>();
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        data.add(count,val);
        map.put(val,count);
        count++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }

        int position=map.get(val);
        map.remove(val);

        int last=data.remove(count-1);
        if (position<=data.size()-1){
            data.set(position,last);
            map.put(last,position);
        }

        count--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {

        int random=new Random().nextInt(count);
        return data.get(random);
    }

    public static void main(String[] args){
        RandomizedSet randomizedSet=new RandomizedSet();
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.remove(0));
        randomizedSet.insert(0);
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        randomizedSet.insert(0);
    }

}
