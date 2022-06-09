package leetcode.p2022m06.day0601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 10:36 PM
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                int iIndex = i + 1;
                while (iIndex < nums1.length && nums1[i] == nums1[iIndex]) {
                    iIndex++;
                }
                i = iIndex;

                int jIndex = j + 1;
                while (jIndex < nums1.length && nums2[j] == nums2[jIndex]) {
                    jIndex++;
                }
                j = jIndex;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans   = new int[list.size()];
        int   index = 0;
        for (int item : list) {
            ans[index++] = item;
        }
        return ans;
    }
}
