package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/17
 * @time 10:27 PM
 */
public class Solution400 {
    public int findNthDigit(int n) {
        long sum   = 0;
        long base  = 9;
        long digit = 1;

        int count = 15;
        if (n<10){
            return n;
        }
        while (count-- > 0) {

            sum += base * digit;
            base *= 10;
            digit++;

            long newNext = sum + base * digit;
            if (sum < n && n <= newNext) {
//                System.out.println(sum + " " + newNext + " " + base + " " + digit);
                int  minVal = (int) Math.pow(10, digit - 1);
                long number = minVal + (n - (sum + 1)) / digit;
                int  temp   = (int) ((n - (sum + 1))) % (int) digit;
                return String.valueOf(number).charAt(temp) - '0';
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        int         ans         = solution400.findNthDigit(1000000000);
        System.out.println(ans);
    }
}
