package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/1
 * @time 10:21 PM
 */
public class Solution2405 {
    public int partitionString(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        boolean[] visited = new boolean[26];
        int       count   = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (visited[index]) {
                Arrays.fill(visited, false);
                visited[index] = true;
                count++;
            } else {
                visited[index] = true;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Solution2405 solution2405 = new Solution2405();
        int          ans          = solution2405.partitionString("ssssss");
        System.out.println(ans);
    }
}
