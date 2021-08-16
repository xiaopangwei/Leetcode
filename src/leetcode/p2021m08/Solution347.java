package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 3:47 PM
 */
public class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int item : nums) {
            int temp = freq.getOrDefault(item, 0);
            freq.put(item, temp + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (!priorityQueue.isEmpty()) {
                    int[] temp = priorityQueue.peek();
                    if (entry.getValue() >= temp[1]) {
                        priorityQueue.poll();
                        priorityQueue.add(new int[]{entry.getKey(), entry.getValue()});
                    }
                }
            }
        }

        int[] ans = new int[priorityQueue.size()];
        int   idx = 0;
        while (!priorityQueue.isEmpty()) {
            ans[idx++] = priorityQueue.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args){
        Solution347 solution347=new Solution347();
        int[] ans=solution347.topKFrequent(new int[]{1},1);
        System.out.println(Arrays.toString(ans));
    }
}
