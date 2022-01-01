package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/28
 * @time 9:16 PM
 */
public class Solution409 {
    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int                     len = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }


        boolean flag=false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int t = entry.getValue();
            if (t % 2 == 0) {
                len += t;
            } else {
                len+=(t-1);
                flag=true;
            }
        }


        if (flag){
            return len+1;
        }else{
            return len;
        }

    }

    public static void main(String[] args) {
        String      s           = "abccccdd";
        Solution409 solution409 = new Solution409();
        int         ans         = solution409.longestPalindrome(s);
        System.out.println(ans);
    }
}
