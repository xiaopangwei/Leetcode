package leetcode.p2022m05.day0507;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 3:28 PM
 */
public class Solution1344 {
    public double angleClock(int hour, int minutes) {

        double y = minutes * 6;
        double x = (hour % 12) * 1.0 * 30 + minutes * 1.0 / 60 * 30;

        double temp = 0;
        if (x - y < 0) {
            temp = y - x;
        } else {
            temp = x - y;
        }

        if (temp - 180 > 1e-6) {
            return 360 - temp;
        } else {
            return temp;
        }
    }

    public static void main(String[] args) {
        Solution1344 solution1344 = new Solution1344();
        double       temp         = solution1344.angleClock(12, 0);
        System.out.println(temp);
    }
}
