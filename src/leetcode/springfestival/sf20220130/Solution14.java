package leetcode.springfestival.sf20220130;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 2:05 PM
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }

        int i = start;
        int j = end;

        int    mid   = (i + j) / 2;
        String left  = longestCommonPrefix(strs, start, mid);
        String right = longestCommonPrefix(strs, mid + 1, end);
        return getCommon(left, right);
    }

    private String getCommon(String aStr, String bStr) {
        if (aStr.isEmpty() || bStr.isEmpty()) {
            return "";
        }

        int minLength = Math.min(aStr.length(), bStr.length());
        int i=0;
        for (i = 0; i < minLength; i++) {
            if (aStr.charAt(i) != bStr.charAt(i)) {
                break;
            }
        }
        if (i > 0) {
            return aStr.substring(0, i);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String     ans        = solution14.longestCommonPrefix(new String[]{"dog","racecar","car"});
        System.out.println(ans);
    }
}
