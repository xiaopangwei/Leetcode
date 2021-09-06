package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/5
 * @time 8:10 PM
 */
public class Solution727 {
    public String minWindow(String S, String T) {

        int start = 0;
        int end   = S.length() - 1;

        int sIndex = 0;
        int tIndex = 0;

        boolean flag = false;

        while (sIndex < S.length()) {

            if (S.charAt(sIndex) != T.charAt(tIndex)) {
                sIndex++;
            } else {
                sIndex++;
                tIndex++;
                int sReverseIndex = sIndex - 1;
                if (tIndex >= T.length()) {
                    int right = sIndex - 1;
                    tIndex--;
                    flag = true;
                    while (sReverseIndex >= 0 && tIndex >= 0) {
                        if (S.charAt(sReverseIndex) == T.charAt(tIndex)) {
                            sReverseIndex--;
                            tIndex--;
                        } else {
                            sReverseIndex--;
                        }
                    }

                    int currentLength = right - sReverseIndex;
                    if (currentLength < end - start + 1) {
                        start = sReverseIndex + 1;
                        end = right;
                    }
//                    System.out.println(String.format("start:[%d],end:[%d]", sReverseIndex + 1, right));
                    sIndex = sReverseIndex + 2;
                    tIndex = 0;
                }
            }
        }

        if (!flag) {
            return "";
        } else {
            return S.substring(start, end + 1);
        }
    }

    public static void main(String[] args) {
        Solution727 solution727 = new Solution727();
//        String      res         = solution727.minWindow("abc", "e");
        String      res         = solution727.minWindow("vdwses", "de");
        System.out.println(res);
    }
}
