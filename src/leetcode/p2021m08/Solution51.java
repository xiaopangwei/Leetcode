package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 10:41 AM
 */
public class Solution51 {
    public boolean checkRecord(String s) {

        char[] array = s.toCharArray();

        int absentDays = 0;

        int length = array.length;

        int i = 0;
        while (i < length) {
            if (array[i] == 'A') {
                absentDays++;
                if (absentDays >= 2) {
                    return false;
                }
                i++;
            } else if (array[i] == 'L') {
                int j = i + 1;
                while (j < length && array[j] == 'L') {
                    j++;
                }
                if (j - i >= 3) {
                    return false;
                }
                i = j;
            } else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution51 solution51=new Solution51();
        System.out.println(solution51.checkRecord("PPALLL"));
    }
}
