package leetcode.p2022m05.day0507;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 3:38 PM
 */
public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left  = 0;
        int right = arr.length - 1;
        while (left + k <= right) {
            int leftAbsGap  = Math.abs(x - arr[left]);
            int rightAbsGap = Math.abs(x - arr[right]);
            if (leftAbsGap > rightAbsGap) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution658 solution658 = new Solution658();
        System.out.println(solution658.findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }
}
