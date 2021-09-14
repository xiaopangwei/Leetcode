package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/13
 * @time 8:59 PM
 */
public class Solution447 {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length < 3) {
            return 0;
        }
        int ans = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            Map<Integer, Integer> distAndCountRefMap = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    int temp = getDist(points[i][0], points[i][1], points[j][0], points[j][1]);
                    distAndCountRefMap.put(temp, distAndCountRefMap.getOrDefault(temp, 0) + 1);
                }
            }
//            System.out.println(distAndCountRefMap);
            for (Map.Entry<Integer, Integer> entry : distAndCountRefMap.entrySet()) {
                int v = entry.getValue();
                if (v >= 2) {
//                    System.out.println(v * (v - 1));
                    ans += (v * (v - 1));
                }
            }
        }

        return ans;
    }


    private int getDist(int x, int y, int m, int n) {
        return (x - m) * (x - m) + (y - n) * (y - n);
    }

    public static void main(String[] args) {
        Solution447 solution447 = new Solution447();
//        [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        int ans = solution447.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}});
        System.out.println(ans);
    }
}
