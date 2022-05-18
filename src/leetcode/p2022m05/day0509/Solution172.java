package leetcode.p2022m05.day0509;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 9:23 PM
 */
public class Solution172 {
    public int trailingZeroes(int n) {

        int ans = 0;

        for (int base = 5; base <= n; base *= 5) {
            ans += n / base;
        }


        return ans;
    }

    public static void main(String[] args) {
        Solution172 solution172=new Solution172();
        int n=solution172.trailingZeroes(100);
        System.out.println(n);
    }
}
