package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/26
 * @time 2:41 PM
 */
public class Solution809 {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String w : words) {
            if (check(s, w)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean check(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i)!=word.charAt(j)){
                return false;
            }
            int t1 = i + 1;
            while (t1 < s.length() && s.charAt(t1) == s.charAt(i)) {
                t1++;
            }
            int len1 = t1 - i;

            int t2 = j + 1;
            while (t2 < word.length() && word.charAt(t2) == word.charAt(j)) {
                t2++;
            }

            int len2 = t2 - j;

            if (len1 < len2) {
                return false;
            }
            if (len1 > len2 && len1 < 3) {
                return true;
            }

            i = t1;
            j = t2;
        }
        return i == s.length() && j == word.length();
    }

    public static void main(String[] args) {
        Solution809 solution809 = new Solution809();
        int         ans         = solution809.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        System.out.println(ans);
    }


}
