package leetcode.p2021m08;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/24
 * @time 10:07 PM
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int len1 = nums1.length;
        for (int i = 0; i < len1 / 2; i++) {
            int temp = nums1[i];
            nums1[i] = nums1[len1 - 1 - i];
            nums1[len1 - 1 - i] = temp;
        }


        int[][] sorted = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            sorted[i][0] = nums2[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });


        int   left  = 0;
        int   right = nums1.length - 1;
        int[] res   = new int[nums2.length];
        for (int i = 0; i < sorted.length; i++) {
            int value = sorted[i][0];
            int index = sorted[i][1];
            if (nums1[left] <= value) {
                res[index] = nums1[right--];
            } else {
                res[index] = nums1[left++];
            }
        }

        return res;
    }


    public static void main(String[] args) {

        Solution870 solution870 = new Solution870();

        int[] arr1 = new int[]{12,24,8,32};
        int[] arr2 = new int[]{13,25,32,11};

        System.out.println(Arrays.toString(solution870.advantageCount(arr1, arr2)));
    }
}
