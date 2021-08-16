package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 10:41 PM
 */
public class Solution1334 {
    public double angleClock(int hour, int minutes) {

        double hourAngle    = hour * 30.0;
        double minuateAngle = minutes * 6.0;

        double delta = minutes * 0.5;

        hourAngle += delta;

//        double temp = minuateAngle - hourAngle;
        double temp = (minuateAngle - hourAngle + 360) % 360;

        if (temp - 180 > 0.001) {
            return 360 - temp;
        } else {
            return temp;
        }
    }

    public static void main(String[] args) {
        Solution1334 solution1334 = new Solution1334();
        System.out.println(solution1334.angleClock(9, 0));

    }
}
