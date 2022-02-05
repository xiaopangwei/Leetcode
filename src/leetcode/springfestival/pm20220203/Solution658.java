package leetcode.springfestival.pm20220203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 3:07 PM
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
        } else if (x >= arr[arr.length - 1]) {
            for (int i = arr.length - 1; i >= arr.length - k; i--) {
                list.add(arr[i]);
            }
        } else {

            int left  = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < x) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // left >=k的第一个元素

            // right <k的最后一个元素

            int j     = left;
            int i     = right;
            int count = 0;

            while (j < arr.length && i >= 0) {
                if (count == k) {
                    break;
                }

                int a = Math.abs(arr[i] - x);
                int b = Math.abs(arr[j] - x);

                if (a == b) {
                    list.add(arr[i--]);

                } else if (a < b) {
                    list.add(arr[i--]);

                } else {
                    list.add(arr[j++]);
                }
                count++;
            }

            while (count<k && i >= 0) {
                list.add(arr[i--]);
                count++;
            }

            while (count<k && j < arr.length) {
                list.add(arr[j++]);
                count++;
            }
        }


        Collections.sort(list);

        return list;
    }

    //[-2,-1,1,2,3,4,5]
    public static void main(String[] args) {
        Solution658 solution658 = new Solution658();
        System.out.println(solution658.findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5},
                7, 3));

    }
}
