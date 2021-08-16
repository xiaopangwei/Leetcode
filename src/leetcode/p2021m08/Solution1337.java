package leetcode.p2021m08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 9:30 AM
 */
public class Solution1337 {
    static class Item {
        public int value;
        public int rowId;

        public Item(int value, int rowId) {
            this.value = value;
            this.rowId = rowId;
        }
    }


    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.value < o2.value) {
                    return -1;
                } else if (o1.value == o2.value) {
                    return o1.rowId - o2.rowId;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < mat.length; i++) {
            int count = getCount(mat[i]);

            priorityQueue.add(new Item(count, i));
        }


        int[] ans = new int[k];
        int   m   = 0;
        while (!priorityQueue.isEmpty() && m < k) {
            Item temp = priorityQueue.poll();
            System.out.println(temp.rowId);
            ans[m++] = temp.rowId;
        }
        return ans;
    }

    private int getCount(int[] array) {
        int left  = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == 0) {
                if (mid == 0) {
                    return 0;
                } else if (array[mid - 1] == 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution1337 solution1337 = new Solution1337();
        int[][]      array        = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
//        int[][] array=new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int[] ans=solution1337.kWeakestRows(array,3);
        System.out.println(Arrays.toString(ans));
//        int ans = solution1337.getCount(new int[]{1, 1, 1, 1, 1});
//        System.out.println(ans);
    }
}
