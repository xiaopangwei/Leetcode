package leetcode.p2021m10;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/4
 * @time 9:32 AM
 */
public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {

        int i = s.length() - 1;

        LinkedList<Character> ans = new LinkedList<>();
        while (i >= 0) {
            int count = 0;
            int j     = i;
            while (j >= 0 && count < k) {
                char temp = s.charAt(j);
                if (temp == '-') {
                    j--;
                    continue;
                }

                count++;
                if (temp >= 'a' && temp <= 'z') {
                    temp = (char) (temp - 'a' + 'A');
                }
                ans.addFirst(temp);
                j--;
            }

            ans.addFirst('-');
            i = j;
        }


        int cnt = 0;
        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j) == '-') {
                cnt++;
            } else {
                break;
            }
        }
        int    idx = 0;
        char[] res = new char[ans.size() - cnt];
        for (int j = cnt; j < ans.size(); j++) {
            res[idx++] = ans.get(j);
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution482 solution482 = new Solution482();
        String      res         = solution482.licenseKeyFormatting("5F3Z-2e-9-w", 4);
        System.out.println(res);
    }
}
