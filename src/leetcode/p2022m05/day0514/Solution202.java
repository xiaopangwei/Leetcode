package leetcode.p2022m05.day0514;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 10:41 AM
 */
public class Solution202 {
    Set<Integer> cached = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        if (cached.contains(n)){
            return false;
        }
        cached.add(n);
        int s = 0;
        while (n != 0) {
            int m = n % 10;
            int t = n / 10;
            s += m * m;
            n = t;
        }
        return isHappy(s);
    }


    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        boolean     ans         = solution202.isHappy(9);
        System.out.println(ans);
    }
}
