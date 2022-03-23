package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 10:05 PM
 */
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int square1 = (ax2 - ax1) * (ay2 - ay1);
        int square2 = (bx2 - bx1) * (by2 - by1);
        int width   = Math.min(ax2, bx2) - Math.max(ax1, bx2);
        int height  = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlap = width <= 0 || height <= 0 ? 0 : width * height;
        return square1 + square2 - Math.max(0, overlap);
    }
}
