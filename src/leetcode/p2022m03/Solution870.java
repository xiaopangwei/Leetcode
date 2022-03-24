package leetcode.p2022m03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/17
 * @time 8:12 PM
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        //[32,24,12,8]
        //[32,25,13,1]
        Arrays.sort(nums1);
        reverse(nums1);
        int[][] temp = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            temp[i] = new int[2];
            temp[i][0] = i;
            temp[i][1] = nums2[i];
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });

        int[] ans  = new int[nums1.length];
        int   left = 0;

        int right = nums1.length - 1;
        for (int i = 0; i < temp.length; i++) {
            int index = temp[i][0];
            if (nums1[left] <= temp[i][1]) {
                ans[index] = nums1[right--];
            } else {
                ans[index] = nums1[left++];
            }
        }
        return ans;
    }

    private void reverse(int[] nums1) {
        int i = 0;
        int j = nums1.length - 1;
        while (i < j) {
            int temp = nums1[i];
            nums1[i] = nums1[j];
            nums1[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution870 solution870 = new Solution870();
        //A = [12,24,8,32]
        //B = [13,25,32,11]
        int[] ans = solution870.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        System.out.println(Arrays.toString(ans));
    }
}
