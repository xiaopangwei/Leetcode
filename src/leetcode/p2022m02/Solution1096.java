package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/10
 * @time 9:28 PM
 */
public class Solution1096 {
    //"{a,b}{c,{d,e}}"
    //["ac","ad","ae","bc","bd","be"]
    public List<String> braceExpansionII(String expression) {
        List<String>  ans   = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(expression);

        while (!queue.isEmpty()) {
            String s   = queue.poll();
            int[]  pos = getFirstBucket(s);
            if (pos[0] == -1 && pos[1] == -1) {
                ans.add(s);
                continue;
            }
            String   content = s.substring(pos[0] + 1, pos[1]);
            String[] array   = content.split(",");
            for (String item : array) {
                String newStr = s.substring(0, pos[0]) + item + s.substring(pos[1] + 1);
                if (queue.contains(newStr)) {
                    continue;
                }
                queue.add(newStr);
            }
        }
        return ans;
    }

    private int[] getFirstBucket(String s) {
        int left  = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{') {
                left = i;
            } else if (ch == '}') {
                right = i;
                break;
            }
        }
        return new int[]{left, right};
    }

    public static void main(String[] args) {
        Solution1096 solution1096 = new Solution1096();
        List<String> ans          = solution1096.braceExpansionII("{{a,z},a{b,c},{ab,z}}");
        System.out.println(ans);
    }
}
