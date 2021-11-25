package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 10:44 PM
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {


        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                if (list.isEmpty() || list.get(list.size() - 1) == nums1[i]) {
                    list.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int[] array = new int[list.size()];
        int   index = 0;
        for (int t = 0; t < list.size(); t++) {
            array[index++] = list.get(t);
        }

        return array;
    }

    private boolean get(int[] source, int target) {
        int i = 0;
        int j = source.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (target == source[mid]) {
                return true;
            } else if (source[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
