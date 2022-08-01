package leetcode.p2022m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 3:27 PM
 */
public class Solution969 {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int[] tmp = findMax(arr, i);
            if (tmp[0] != i) {
                reverse(arr, 0, tmp[0]);
                System.out.println(Arrays.toString(arr));
                if (tmp[0] != 0) {
                    ans.add(tmp[0] + 1);
                }
                reverse(arr, 0, i);
                System.out.println(Arrays.toString(arr));
                ans.add(i + 1);

            }
        }
        return ans;
    }


    private void reverse(int[] array, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
            i++;
            j--;
        }
    }

    private int[] findMax(int[] arr, int end) {
        int idx   = -1;
        int value = Integer.MIN_VALUE;
        for (int i = 0; i <= end; i++) {
            if (arr[i] > value) {
                idx = i;
                value = arr[i];
            }
        }
        return new int[]{idx, value};
    }

    public static void main(String[] args) {
        Solution969   solution969 = new Solution969();
        List<Integer> ans         = solution969.pancakeSort(new int[]{1,2,3});
        // 3 2 4 1
        // 4 2 3 1
        // 1 3 2 4
        // 3 1 2 4
        // 2 1 3 4
        // 1 2 3 4

        System.out.println(ans);
    }
}
