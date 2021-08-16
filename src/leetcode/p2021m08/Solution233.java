package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 10:13 AM
 */
public class Solution233 {
    public int countDigitOne(int n) {
        return countDigitK(n, 1);
    }

    public int countDigitK(int n, final int k) {

        int base  = 1;
        int low   = 0;
        int high  = n / 10;
        int count = 0;

        while (n != 0) {

            int curr = n % 10;

            int temp = 0;
            if (curr == k) {
                temp = high * base + low + 1;
            } else if (curr < k) {
                temp = (high * base);
            } else {
                temp = ((high + 1) * base);
            }

            System.out.println(high + " " + curr + " " + low+" total:"+temp);
            count += temp;
            low =curr*base+low;
            high = high / 10;
            n = n / 10;
            base *= 10;

        }

        return count;
    }




    public static void main(String[] args) {
        Solution233 solution233 = new Solution233();
        int ans=solution233.countDigitOne(13);
        System.out.println(ans);
    }
}
