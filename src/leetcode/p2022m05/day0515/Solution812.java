package leetcode.p2022m05.day0515;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 10:03 AM
 */
public class Solution812 {
    public double largestTriangleArea(int[][] points) {

        double maxArea = 0;
        for (int i = 0; i < points.length - 2; i++) {
            int a0 = points[i][0];
            int b0 = points[i][1];
            for (int j = i + 1; j < points.length - 1; j++) {
                int a1 = points[j][0];
                int b1 = points[j][1];
                for (int t = j + 1; t < points.length; t++) {

                    int a2 = points[t][0];
                    int b2 = points[t][1];

                    int    t1   = Math.abs((a1 - a0) * (b2 - b0));
                    int    t2   = Math.abs((a2 - a0) * (b1 - b0));
                    double temp = 0.5 * t1 * t2;
                    maxArea = Math.max(maxArea, temp);

                }
            }
        }
        return maxArea;
    }
}
