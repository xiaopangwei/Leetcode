package leetcode.p2021m08;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/3
 * @time 3:41 PM
 */
public class Solution315 {
    public int count = 0;

    int[] posMap;

    public List<Integer> countSmaller(int[] nums) {

        int   length = nums.length;
        int[] ans    = new int[length];
        posMap = new int[length];
        sort(nums, 0, length - 1, ans);
        System.out.println(Arrays.toString(ans));
        return null;
    }

    private void sort(int[] nums, int start, int end, int[] ans) {

        if (end - start <= 0) {
            return;
        }
        int mid = (start + end) / 2;

        sort(nums, start, mid, ans);
        sort(nums, mid + 1, end, ans);
        int[] temp = new int[end - start + 1];
        merge(nums, start, mid, nums, mid + 1, end, temp, ans);
        System.out.println(start + " , " + end + " => " + Arrays.toString(nums));
    }

    private void merge(int[] a, int s1, int e1, int[] b, int s2, int e2, int[] temp, int[] ans) {
        int i = s1;
        int j = s2;


        int k = 0;
        while (i <= e1 && j <= e2) {
            if (a[i] == b[j]) {
                temp[k++] = a[i++];
                temp[k++] = b[j++];
            } else if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else {
                count += (e1 - i + 1);
                temp[k++] = b[j++];
            }
        }

        if (i <= e1) {
            for (int p = i; p <= e1; p++) {
                temp[k++] = a[p];
            }
        }
        if (j <= e2) {
            for (int p = j; p <= e2; p++) {
                temp[k++] = b[p];
            }
        }

        System.arraycopy(temp, 0, a, s1, temp.length);
    }

    public static void main(String[] args) {
        Solution315 solution315 = new Solution315();
//        int[]       a           = {1, 3, 5, 7, 8};
//        int[]       b           = {2, 4, 8, 100};
//        int[]       temp        = new int[2];
//        solution315.merge(a, 0, 0, a, 1, 1, temp);
        int[] array = new int[]{4, 2, 1, 3, 7, 100, -1};
        solution315.countSmaller(array);
        System.out.println(solution315.count);

    }

}
