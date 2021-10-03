package leetcode.p2021m10;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 11:10 AM
 */
public class Solution544 {
    public String findContestMatch(int n) {

        int i = 2;

        List<String> ans = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            ans.add(String.valueOf(j));
        }
        while (i <= n) {
            int left  = 0;
            int right = ans.size() - 1;
            while (left < right) {
                String first = ans.get(left);
                String last  = ans.get(right);
                ans.remove(right);
                StringBuilder builder = new StringBuilder("(");
                builder.append(first);
                builder.append(",");
                builder.append(last);
                builder.append(")");
                ans.set(left, builder.toString());
                left++;
                right--;
            }
            i = i << 1;
        }
        return ans.get(0);
    }

    public static void main(String[] args) {
        Solution544 solution544 = new Solution544();
        String      ans         = solution544.findContestMatch(8);
        System.out.println(ans);
    }

}
