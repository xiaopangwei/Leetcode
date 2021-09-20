package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 1:12 PM
 */
public class Solution408 {
    public boolean validWordAbbreviation(String word, String abbr) {

        char[] completeWordCharArray = word.toCharArray();
        char[] abbrCharArray         = abbr.toCharArray();

        int i = 0;
        int j = 0;

        int lenOfAbbr = abbrCharArray.length;

        while (i < completeWordCharArray.length && j < lenOfAbbr) {
            int temp = 0;
            if (abbrCharArray[j] >= '0' && abbrCharArray[j] <= '9') {
                if (abbrCharArray[j] == '0') {
                    return false;
                }
            }
            while (j < lenOfAbbr && (abbrCharArray[j] >= '0' && abbrCharArray[j] <= '9')) {
                temp = temp * 10 + (abbrCharArray[j] - '0');
                j++;
            }
            if (temp > 0) {
                i += temp;
            } else {
                if (abbrCharArray[j] != completeWordCharArray[i]) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }


        if (i == completeWordCharArray.length && j == lenOfAbbr) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution408 solution408 = new Solution408();
        boolean     ans         = solution408.validWordAbbreviation("abc", "2");
        System.out.println(ans);
    }
}
