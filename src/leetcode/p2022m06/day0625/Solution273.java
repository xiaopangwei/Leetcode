package leetcode.p2022m06.day0625;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/26
 * @time 7:46 PM
 */
public class Solution273 {
    String[] str1 = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] str2 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] str3 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    final static int BILL = 1000000000;
    final static int MILL = 1000000;
    final static int THR  = 1000;

    public String numberToWords(int num) {

        if (num < THR) {
            return convert(num);
        }
        StringBuilder sb       = new StringBuilder();
        int           billion  = num / BILL;
        int           million  = (num % BILL) / MILL;
        int           thousand = ((num % BILL) % MILL) / THR;
        int           remained = num - billion * BILL - million * MILL - thousand * THR;
        if (billion != 0) {
            sb.append(numberToWords(billion));
            sb.append(" billion ");
        }

        if (million != 0) {
            sb.append(numberToWords(million));
            sb.append(" million ");
        }

        if (thousand != 0) {
            sb.append(numberToWords(thousand));
            sb.append(" thousand ");
        }

        if (remained != 0) {
            sb.append(convert(remained));
        }
        return sb.toString();
    }


    public String convert(int num) {
        StringBuilder sb       = new StringBuilder();
        int           hundreds = num / 100;
        if (hundreds != 0) {
            sb.append(str1[hundreds]);
            sb.append(" hundred ");
        }

        num = num % 100;
        if (num == 0) {
            return sb.toString();
        }
        //0 99
        if (num < 9) {
            sb.append(str1[num]);
        } else if (num < 20) {
            sb.append(str2[num - 10]);
        } else {

            int t1 = num / 10;
            int t2 = num % 10;
            sb.append(str3[t1]);
            sb.append(" ");
            if (t2 != 0) {
                sb.append(str1[t2]);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Solution273 solution273 = new Solution273();
        String      ans         = solution273.numberToWords(1234567);
        System.out.println(ans);
    }
}
