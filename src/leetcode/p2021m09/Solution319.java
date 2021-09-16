package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/14
 * @time 9:04 PM
 */
public class Solution319 {
    public int bulbSwitch(int n) {

       return (int)Math.sqrt(n);

    }

    public static void main(String[] args) {
        Solution319 solution319 = new Solution319();
        int         ans         = solution319.bulbSwitch(3);
        System.out.println(ans);
    }
}
