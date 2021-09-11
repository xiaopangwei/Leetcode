package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/9
 * @time 10:11 PM
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        //第一个y>=x的 y位置
        int left  = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int           idx = left;
        List<Integer> ans = new ArrayList<>();
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                ans.add(arr[i]);
            }
            return ans;
        } else if (x > arr[arr.length - 1]) {
            //n-k;
            for (int i = arr.length - k; i < arr.length; i++) {
                ans.add(arr[i]);
            }
            return ans;
        } else {
            int count = 0;
            if (arr[idx] == x) {
                left = idx - 1;
                right = idx + 1;
                count++;
            } else {
                left = idx - 1;
                right = idx;
            }


            while (left >= 0 && right < arr.length) {
                if (count == k) {
                    break;
                }
                if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                    right++;
                } else {
                    left--;
                }
                count++;
            }

            while (left >= 0) {
                if (count == k) {
                    break;
                }
                count++;
                left--;
            }
        }


        int start = left + 1;
        int end   = left + 1 + k;
        for (int i = start; i < end; i++) {
            ans.add(arr[i]);
        }

        return ans;


    }

    public static void main(String[] args) {
        Solution658   solution658 = new Solution658();
        List<Integer> list        = solution658.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5);
        System.out.println(list);
    }

}
