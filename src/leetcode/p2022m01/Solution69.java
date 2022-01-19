package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/18
 * @time 9:15 PM
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x==0){return 0;}
        double x0 = x;
        while (true) {
            double temp = x0 - (x0 * x0 - x) / (2 * x0);
            if (Math.abs(temp - x0) < 0.0000001) {
                return (int) temp;
            }
            x0 = temp;
        }
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        int        ans        = solution69.mySqrt(9);
        System.out.println(ans);
    }
}
