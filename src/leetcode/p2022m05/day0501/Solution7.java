package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 11:28 PM
 */
public class Solution7 {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        boolean flag = x > 0;
        if (!flag) {
            x = -x;
        }
        int sum = 0;
        while (x != 0) {
            int m = x % 10;
            if (sum>=(Integer.MAX_VALUE-m)/10){
                return 0;
            }
            sum = sum * 10 + m;
            int n = x / 10;
            x = n;
        }

        if (!flag) {
            return -sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int m=solution7.reverse(120);
        System.out.println(m);

    }
}
