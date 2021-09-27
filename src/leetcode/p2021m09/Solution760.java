package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/26
 * @time 1:33 PM
 */
public class Solution760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                map.put(nums2[i], new ArrayList<>());
            }
            map.get(nums2[i]).add(i);
        }

        int[] array = new int[nums1.length];
        int   idx   = 0;
        for (int i = 0; i < nums1.length; i++) {
            List<Integer> list = map.get(nums1[i]);
            array[idx++] = list.get(0);
            list.remove(0);
        }

        return array;
    }

    public static void main(String[] args) {
        Solution760 solution760 = new Solution760();
        int[]       arr         = solution760.anagramMappings(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28});
        System.out.println(Arrays.toString(arr));
    }
}
