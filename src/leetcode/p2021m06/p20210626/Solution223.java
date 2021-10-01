package leetcode.p2021m06.p20210626;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/25
 * @time 11:07 PM
 */
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {


        int overlapWidth  = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        int overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);

        int a = (ax2 - ax1) * (ay2 - ay1);
        int b = (bx2 - bx1) * (by2 - by1);

        int temp = a + b - Math.max(overlapHeight, 0) * Math.max(overlapWidth, 0);
        if (temp < 0) {
            return 0;
        } else {
            return temp;
        }

    }

}
