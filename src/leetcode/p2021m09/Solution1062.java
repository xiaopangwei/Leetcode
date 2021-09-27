package leetcode.p2021m09;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/24
 * @time 11:01 PM
 */
public class Solution1062 {
    public int longestRepeatingSubstring(String s) {

        int left  = 0;
        int right = s.length() - 1;

        int len = s.length();
        while (left <= right) {
            int mid = (left + right) / 2;

            Set<String> sets = new HashSet<>();
            boolean     flag = false;
            for (int i = 0; i < len; i++) {
                int j = i + mid - 1;
                if (j >= len) {
                    continue;
                }
                String sub = s.substring(i, j + 1);
                if (sets.contains(sub)) {
                    flag = true;
                    break;
                } else {
                    sets.add(sub);
                }
            }

            if (flag) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        if (right>=0 && right<len){
            return right;
        }

        return 0;
    }

    public static void main(String[] args){
        Solution1062 solution1062=new Solution1062();
        int ans=solution1062.longestRepeatingSubstring("aaaaa");
        System.out.println(ans);
    }
}
