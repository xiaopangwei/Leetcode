package leetcode.p2021m12;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/26
 * @time 9:54 PM
 */
public class Solution1235 {

    Map<String, Integer> cached = new HashMap<>();

    static class Job implements Comparable<Job> {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public int compareTo(Job o) {
            return this.end - o.end;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int       len  = startTime.length;
        List<Job> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        list.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.end != o2.end) {
                    return o1.end - o2.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });
        return dfs(0, 0, len, list);

    }



    public int dfs(int last, int index, int len, List<Job> list) {
        String key = last + "#" + index;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index == len) {
            return 0;
        }
        int s = list.get(index).start;
        if (s >= last) {
            int t1  = dfs(Math.max(last, list.get(index).end), index + 1, len, list) + list.get(index).profit;
            int t2  = dfs(last, index + 1, len, list);
            int ans = Math.max(t1, t2);
            cached.put(key, ans);
            return ans;
        } else {
            int ans = dfs(last, index + 1, len, list);
            cached.put(key, ans);
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution1235 solution1235 = new Solution1235();
        int ans = solution1235.jobScheduling(new int[]{6, 15, 7, 11, 1, 3, 16, 2},
                new int[]{19, 18, 19, 16, 10, 8, 19, 8},
                new int[]{2, 9, 1, 19, 5, 7, 3, 19});
        System.out.println(ans);
    }
}
