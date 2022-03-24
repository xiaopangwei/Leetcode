package leetcode.p2022m03;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/20
 * @time 4:23 PM
 */
public class Solution1356 {
    public int[] sortByBits(int[] arr) {
        int[] dp = new int[10001];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int[] temp = new int[2];
            temp[0] = arr[i];
            temp[1] = dp[arr[i]];
            list.add(temp);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i)[0];
        }

        return arr;

    }

    public static void main(String[] args) {
        int[]        array        = new int[]{2, 3, 5, 7, 11, 13, 17, 19};
        Solution1356 solution1356 = new Solution1356();
        int[]        ans          = solution1356.sortByBits(array);
        System.out.println(Arrays.toString(ans));
    }
}
