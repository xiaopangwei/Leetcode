package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 9:32 PM
 */
public class Solution880 {
    public String decodeAtIndex(String s, int k) {
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count++;
                if (count == k) {
                    return String.valueOf(ch);
                }
            } else {
                long temp = count * (ch - '0');
                if (temp == k) {
                    String ans = "";
                    for (int j = i - 1; j >= 0; j--) {
                        if (s.charAt(j) >= 'a' && s.charAt(j) <= 'z') {
                            ans = String.valueOf(s.charAt(j));
                            break;
                        }
                    }
                    return ans;
                } else if (temp > k) {
                    long mod = k % count;
                    if (mod == 0) {
                        mod = count;
                    }
                    return decodeAtIndex(s, (int) mod);
                } else {
                    count = temp;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution880 solution880 = new Solution880();
        String      val         = solution880.decodeAtIndex("ha22", 5);
        System.out.println(val);
    }
}
