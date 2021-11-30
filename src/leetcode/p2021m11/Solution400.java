package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/30
 * @time 9:40 PM
 */
public class Solution400 {


        public int findNthDigit(int n){
            if(n <= 9)
                return n;

            long ln = n - 9; //ln = 11
            long digit = 2;

            while(ln > 0){
                long thisRoundDigits = getThisRoundDigits(digit);

                if(ln < thisRoundDigits)
                    break;
                ln -= thisRoundDigits;
                digit++;
            }

            //ln = 2
            //
            long whichNumber = (ln - 1) / digit;
            long whichPos    = (ln - 1) % digit;

            long startNumber = getStartNumber(digit);
            String res = startNumber + whichNumber + "";
            return res.charAt((int)whichPos) - '0';
        }

        private long getStartNumber(long digits){
            StringBuilder start = new StringBuilder();
            start.append("1");
            for(int i = 0; i < digits - 1; i++){
                start.append("0");
            }

            return Long.parseLong(start.toString());
        }

        private long getThisRoundDigits(long digit) {

            StringBuilder end = new StringBuilder();

            end.append("9");    // 99 -  10
            for(int i = 0; i < digit - 1; i++){

                end.append("9");
            }

            return (Long.parseLong(end.toString()) - getStartNumber(digit) + 1) * digit;
        }

    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
//        for (int i = 1; i < 1000; i++) {
            System.out.println(solution400.findNthDigit(189));
//        }

    }
}
