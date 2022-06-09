package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 8:58 PM
 */
public class Solution844 {
    public boolean backspaceCompare(String s, String t) {

        int i = s.length() - 1;
        int j = t.length() - 1;

        int backCount1 = 0;
        int backCount2 = 0;
        while (true) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    backCount1++;
                    i--;
                } else {
                    if (backCount1 > 0) {
                        backCount1--;
                        i--;
                    } else {
                        break;
                    }
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    backCount2++;
                    j--;
                } else {
                    if (backCount2 > 0) {
                        backCount2--;
                        j--;
                    } else {
                        break;
                    }
                }
            }

//            System.out.println(i+" "+j);
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else {
                break;
            }
        }

        return i < 0 && j < 0;
    }

    public static void main(String[] args) {

        Solution844 solution844 = new Solution844();
        boolean     ans         = solution844.backspaceCompare("nzp#o#g", "b#nzp#o#g");
        System.out.println(ans);
    }
}
