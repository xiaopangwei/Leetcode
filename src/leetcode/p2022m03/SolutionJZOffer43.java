package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/17
 * @time 10:09 PM
 */
public class SolutionJZOffer43 {
    public int countDigitOne(int n) {
        if (n < 10) {
            return 1;
        }
        long base = 1;
        //base=100
        // xxxxyzz
        long ans  = 0;
        long high = 0;
        long cur  = 0;
        long low  = 0;
        while (n >= base) {
            high = (n / base) / 10;
            cur = (n / base) % 10;
            low = n % base;
            if (cur > 1) {
                ans += ((high + 1) * base);
            } else if (cur == 1) {
                //0-xxx-1  base
                //xxx      0~low
                ans += (high * base + low + (long) 1);
            } else {
                ans += (high * base);
            }
            base *= (long) 10;
        }
        return (int) (ans);
    }

    public static void main(String[] args) {
        SolutionJZOffer43 solutionJZOffer43 = new SolutionJZOffer43();
        int               ans               = solutionJZOffer43.countDigitOne(12);
        System.out.println(ans);
    }
}
