package leetcode.p2022m05.day0517;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/17
 * @time 8:53 PM
 */
public class Solution632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int temp = nums.get(i).get(0);
            min = Math.min(min, (long) temp);
            max = Math.max(max, (long) temp);
            pq.add(new int[]{i, 0, temp});
        }


        List<int[]> sortedList = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            sortedList.add(new int[]{temp[0], temp[2]});
            if (temp[1] < nums.get(temp[0]).size() - 1) {
                int t = nums.get(temp[0]).get(temp[1] + 1);
                pq.add(new int[]{temp[0], temp[1] + 1, t});
            }
        }

//        for (int[] item : sortedList) {
//            System.out.println(Arrays.toString(item));
//        }

        int left  = 0;
        int right = 0;

        int n = nums.size();


        Map<Integer, Integer> freq = new HashMap<>();
        while (right < sortedList.size()) {
            int g1 = sortedList.get(right)[0];
            freq.put(g1, freq.getOrDefault(g1, 0) + 1);
            while (left < right && freq.keySet().size() >= n) {
                long p1 = (long) sortedList.get(right)[1];
                long p2 = (long) sortedList.get(left)[1];
                if (p1 - p2 < max - min) {
                    max = p1;
                    min = p2;
                }
//                System.out.println(sortedList.get(left)[1]+" "+sortedList.get(right)[1]);
                int g2 = sortedList.get(left)[0];
                int f  = freq.get(g2) - 1;
                if (f > 0) {
                    freq.put(g2, f);
                } else {
                    freq.remove(g2);
                }
                left++;
            }
            right++;
        }
        return new int[]{(int) min, (int) max};
    }

    public static void main(String[] args) {
        //[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
        List<Integer> list1       = Arrays.asList(4, 10, 15, 24, 26);
        List<Integer> list2       = Arrays.asList(0, 9, 12, 20);
        List<Integer> list3       = Arrays.asList(5, 18, 22, 30);
        Solution632   solution632 = new Solution632();
        int[]         ans         = solution632.smallestRange(Arrays.asList(list1, list2, list3));
        System.out.println(Arrays.toString(ans));
    }
}
