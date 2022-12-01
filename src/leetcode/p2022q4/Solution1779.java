package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/1
 * @time 9:51 PM
 */
public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dist      = Integer.MAX_VALUE;
        int distIndex = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (x == point[0] || y == point[1]) {
                int temp = Math.abs(x - point[0]) + Math.abs(y - point[1]);
                if (temp < dist) {
                    dist = temp;
                    distIndex = i;
                }
            }
        }
        return distIndex;
    }
}
