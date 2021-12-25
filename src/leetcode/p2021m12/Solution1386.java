package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 3:35 PM
 */
public class Solution1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, List<Integer>> rsMap = new HashMap<>();
        for (int[] arr : reservedSeats) {
            if (!rsMap.containsKey(arr[0])) {
                rsMap.put(arr[0], new ArrayList<>());
            }
            rsMap.get(arr[0]).add(arr[1]);
            // 2 3 4 5
            // 4 5 6 7
            // 6 7 8 9
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            List<Integer> list = rsMap.get(i);
            if (list != null) {
                if (list.contains(4) || list.contains(5)) {

                    if (list.contains(6) || list.contains(7) || list.contains(8) || list.contains(9)) {
                        ans += 0;
                    } else {
                        ans += 1;
                    }
                } else if (list.contains(6) || list.contains(7)) {
                    if (list.contains(2) || list.contains(3) || list.contains(4) || list.contains(5)) {
                        ans += 0;
                    } else {
                        ans += 1;
                    }
                } else {
                    if (list.contains(2) || list.contains(3) || list.contains(8) || list.contains(9)) {
                        ans += 1;
                    } else {
                        ans += 2;
                    }
                }
            } else {
                ans+=2;
            }


        }
        return ans;
    }

    public static void main(String[] args) {
        int[][]      array        = new int[][]{{4,3},{1,4},{4,6},{1,7}};
        Solution1386 solution1386 = new Solution1386();
        int          ans          = solution1386.maxNumberOfFamilies(4, array);
        System.out.println(ans);
    }
}
