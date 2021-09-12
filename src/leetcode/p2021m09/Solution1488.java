package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 10:26 PM
 */
public class Solution1488 {
    public int[] avoidFlood(int[] rains) {
        int   len = rains.length;
        int[] ans = new int[len];

        Map<Integer, Integer> poolAndDayIndex = new HashMap<>();

        List<Integer> empty = new ArrayList<>();

        //1,2,0,0,2,1
        boolean flag = true;
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                if (!poolAndDayIndex.containsKey(rains[i])) {
                    poolAndDayIndex.put(rains[i], i);
                    ans[i] = -1;
                } else {
                    int idx       = -1;
                    int lastIndex = poolAndDayIndex.get(rains[i]);
                    for (int j = 0; j < empty.size(); j++) {
                        int val = empty.get(j);
                        if (val > lastIndex && val < i) {
                            idx = val;
                            break;
                        }
                    }
                    if (idx >= 0 && idx < rains.length) {
                        ans[idx] = rains[i];
                        ans[i] = -1;
                        empty.remove((Integer) idx);
                        poolAndDayIndex.put(rains[i], i);
                    } else {

                        flag = false;
                        break;
                    }
                }
            } else {
                empty.add(i);
            }
        }

        if (flag) {
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == 0) {
                    ans[i] = 1;
                }
            }
            return ans;
        } else {
            return new int[0];
        }

    }

    public static void main(String[] args) {
//        [1,0,2,0,3,0,2,0,0,0,1,2,3]
//        [-1,1,-1,2,-1,3,-1,2,1,1,-1,-1,-1]
//        [-1,1,-1,2,-1,3,-1,1,1,1,-1,-1,-1]
        Solution1488 solution1488 = new Solution1488();
        int[]        arr          = solution1488.avoidFlood(new int[]{1,0,2,0,3,0,2,0,0,0,1,2,3});
        System.out.println(Arrays.toString(arr));
    }
}
