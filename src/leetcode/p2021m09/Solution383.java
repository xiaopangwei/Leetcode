package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 11:07 AM
 */
public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int ch   = ransomNote.charAt(i) - 'a';
            int temp = freq[ch];
            if (temp == 0) {
                return false;
            } else {
                freq[ch] = temp - 1;
            }
        }
        return true;
    }
}
