package leetcode.p2022m05.day0510;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 10:52 PM
 */
public class Solution190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {


        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int lastDigit = n & 1;
            int t         = 31 - i;
            ans += lastDigit << t;
            n >>>= 1;
        }

        return ans;
    }
}
