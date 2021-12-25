package leetcode.p2021m12;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/23
 * @time 10:38 PM
 */
public class Solution373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1) + o2.get(0) - o1.get(0) - o1.get(1);
            }
        });

        List<List<Integer>> list = new ArrayList<>();

        int m = Math.min(k, nums1.length);
        int n = Math.min(k, nums2.length);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pq.size() < k) {
                    pq.add(Arrays.asList(nums1[i], nums2[j]));
                } else {
                    int s = pq.peek().get(0) + pq.peek().get(1);
                    if (nums1[i] + nums2[j] < s) {
                        pq.poll();
                        pq.add(Arrays.asList(nums1[i], nums2[j]));
                    }
                }
            }
        }


        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }

        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        Solution373         solution373 = new Solution373();
        List<List<Integer>> ans         = solution373.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println(ans);
    }
}
