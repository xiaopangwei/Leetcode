package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:11 PM
 */
public class Solution774 {
    double exp = 1e-6;

    public double minmaxGasDist(int[] stations, int k) {

//        int minVal = Integer.MAX_VALUE;
//        int maxVal = Integer.MIN_VALUE;
//
//        for (int i = 0; i < stations.length; i++) {
//            maxVal = Math.max(maxVal, stations[i]);
//            minVal = Math.min(minVal, stations[i]);
//        }

        double left  = 0;
        double right = 1e8;

        while (right - left >= exp) {

            double mid = (left + right) / 2;

            int count = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                count += (stations[i + 1] - stations[i]) / mid;
            }

            System.out.println(mid+" "+count+" "+k);
            if (count <= k) {
                right = mid - exp;
            } else {
                left = mid + exp;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution774 solution774 = new Solution774();
        double      ans         = solution774.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9);
        System.out.println(ans);
    }
}
