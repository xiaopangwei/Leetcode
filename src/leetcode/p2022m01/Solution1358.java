package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/27
 * @time 9:05 PM
 */
public class Solution1358 {
    public int numberOfSubstrings(String s) {
        int[] freq  = new int[3];
        int   left  = 0;
        int   right = 0;
        int   ans   = 0;
        while (right < s.length()) {
            int temp = s.charAt(right) - 'a';
            freq[temp]++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                ans += (right - left + 1);
                int a = s.charAt(left) - 'a';
                freq[a]--;
                left++;
            }
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1358 solution1358 = new Solution1358();
        int          ans          = solution1358.numberOfSubstrings("abcabc");
        System.out.println(ans);
    }


}
