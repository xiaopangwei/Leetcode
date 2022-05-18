package leetcode.p2022m05.day0508;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 10:24 PM
 */
public class Solution1404 {
    public int numSteps(String s) {

        return dfs(s);
    }

    private int dfs(String s) {

        if (s.length() == 1) {
            return 0;
        }

        if (s.charAt(s.length() - 1) == '0') {
            return dfs(trimLeftZero(s, 0, s.length() - 2))+1;
        } else {
            return dfs(incr(s))+1;
        }
    }

    public String incr(String s) {

        char[] arr = s.toCharArray();
        int    i   = s.length() - 1;
        for (; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                arr[i] = '1';
                break;
            } else {
                arr[i] = '0';
            }
        }

        String temp = new String(arr);
        if (i < 0) {
            return "1" + temp;
        } else {
            return temp;
        }
    }

    public static String trimLeftZero(String s, int start, int end) {
        StringBuilder builder = new StringBuilder();
        int           i       = start;
        while (i < end && s.charAt(i) == '0') {
            i++;
        }

        while (i <= end) {
            builder.append(s.charAt(i));
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution1404 solution1404 = new Solution1404();
        int          ans          = solution1404.numSteps("1101");
        System.out.println(ans);
    }


}
