package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/13
 * @time 9:58 PM
 */
public class MyHeap {
    List<Integer> list = new ArrayList<>();

    public MyHeap(int[] array) {
        for (int item : array) {
            this.add(item);
        }
    }

    public void add(int target) {
        list.add(target);
        shiftUp();

    }


    private void shiftUp() {
        int index = list.size() - 1;
        if (index == 0) {
            return;
        }
        int parent = index % 2 != 0 ? index / 2 : (index - 1) / 2;
        while (true) {

            if (list.get(parent) <= list.get(index)) {
                break;
            }

            swap(index, parent);

            index = parent;

            if (index==0){
                return;
            }else {
                parent = index % 2 != 0 ? index / 2 : (index - 1) / 2;
            }

        }
    }


    private void shiftDown() {


        int last = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        if (list.isEmpty()) {
            return;
        }
        list.set(0, last);

        int index = 0;
        int left  = 0, right = 0;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;

            int minIndex = -1;
            int minVal   = Integer.MAX_VALUE;

            if (left < list.size() && list.get(index) > list.get(left)) {
                minIndex = left;
                minVal = Math.min(list.get(left), minVal);
            }

            if (right < list.size() && list.get(index) > list.get(right)) {
                if (list.get(right) < minVal) {
                    minIndex = right;
                }
            }

            if (minIndex == -1) {
                break;
            }

            swap(index, minIndex);
            index = minIndex;

        }


    }


    public int remove() {

        int t = list.get(0);

        if (!list.isEmpty()) {
            shiftDown();
        }

        return t;

    }

    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }


    public static void main(String[] args) {
        int[]  array = new int[]{1, 6, 5, 4, 8, 12, 10};
        MyHeap heap  = new MyHeap(array);


        int len = array.length;
        for (int i = 0; i < len; i++) {
            heap.remove();
        }
    }
}
