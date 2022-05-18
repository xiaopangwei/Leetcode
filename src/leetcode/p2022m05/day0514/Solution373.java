package leetcode.p2022m05.day0514;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 3:08 PM
 */
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int v1 = nums1[o1[0]] + nums2[o1[1]];
                int v2 = nums1[o2[0]] + nums2[o2[1]];
                return v1 - v2;
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            pq.add(new int[]{i, 0});
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()){
                break;
            }
            int[] temp = pq.poll();
            ans.add(Arrays.asList(nums1[temp[0]], nums2[temp[1]]));

            if (temp[1] + 1 < nums2.length) {
                pq.add(new int[]{temp[0], temp[1] + 1});
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution373 solution373 = new Solution373();
        System.out.println(solution373.kSmallestPairs(new int[]{1,3}, new int[]{3}, 3));
    }
}
