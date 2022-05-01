package leetcode.todo;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 10:49 AM
 */
public class Solution1542 {
    //还有很多疑问
    public int longestAwesome(String s) {
        int                   n      = s.length();
        Map<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        prefix.put(0, -1);
        int ans = 0;
        int sequence = 0;
        for (int j = 0; j < n; ++j) {
            int digit = s.charAt(j) - '0';
            sequence ^= (1 << digit);
            System.out.println(j+" "+digit+" "+sequence);
            if (prefix.containsKey(sequence)) {
                ans = Math.max(ans, j - prefix.get(sequence));
            } else {
                prefix.put(sequence, j);
            }
            System.out.println(prefix);
            for (int k = 0; k < 10; ++k) {
                if (prefix.containsKey(sequence ^ (1 << k))) {
                    ans = Math.max(ans, j - prefix.get(sequence ^ (1 << k)));
                }
            }
        }
        return ans;
    }



    public static void main(String[] args){
        Solution1542 solution1542=new Solution1542();
        int a=123;
        int b=456;
        int ans=solution1542.longestAwesome("3242415");
        System.out.println(ans);

    }
}
