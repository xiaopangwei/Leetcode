package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 8:11 PM
 */
public class SolutionJZ43 {
    public int countDigitOne(int n) {
        long base = 1;
        long ans  = 0;
        while (base <= n) {
            long low  = n % base;
            long high = (n / base) / 10;

            long curr = (n / base) % 10;

            // System.out.println(high+" "+curr+" "+low);
            if (curr > 1) {
                ans += (long) (high + 1) * (long) base;
            } else if (curr == 1) {
                ans += (long) high * (long) base + (long) low + (long) 1;
            } else {
                ans += ((long) high * (long) base);
            }
            base *= 10;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        SolutionJZ43 solutionJZ43 = new SolutionJZ43();
        int          ans          = solutionJZ43.countDigitOne(1410065408);
        System.out.println(ans);
    }
}
