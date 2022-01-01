package leetcode.p2021m12;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 9:12 PM
 */
public class MyHashSet {

    LinkedList<Integer>[] list;

    public MyHashSet() {
        list = new LinkedList[64];
        for (int i = 0; i < 64; i++) {
            list[i] = new LinkedList();
        }
    }

    public void add(int key) {
        int               h        = hash(key);
        Iterator<Integer> iterator = list[h].iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            if (val == key) {
                return;
            }
        }

        list[h].addFirst(key);
    }

    public void remove(int key) {
        int               h        = hash(key);
        Iterator<Integer> iterator = list[h].iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            if (val == key) {
                iterator.remove();
            }
        }
    }

    public boolean contains(int key) {
        int               h        = hash(key);
        Iterator<Integer> iterator = list[h].iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            if (val == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % 64;
    }
}
