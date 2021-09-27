package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/26
 * @time 11:04 AM
 */
public class Solution1087 {
    public String[] expand(String s) {

        Queue<String> queue = new LinkedList<>();
        List<String>  ans   = new ArrayList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (!temp.contains("{")) {
                ans.add(temp);
            }
            int[] array = findBucket(temp);
            int   left  = array[0];
            int   right = array[1];
            if (left == -1 || right == -1) {
                continue;
            }
            String[] innerArray = temp.substring(left + 1, right).split(",");

            String a = temp.substring(0, left);
            String b = temp.substring(right + 1);
            for (String item : innerArray) {
                String concat = a + item + b;
                queue.add(concat);
            }
        }

        Collections.sort(ans);
        String[] res = new String[ans.size()];
        int      k   = 0;
        for (String item : ans) {
            res[k++] = item;
        }
        return res;
    }

    private int[] findBucket(String s) {
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}') {
                return new int[]{left, i};
            } else if (s.charAt(i) == '{') {
                left = i;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution1087 solution1087 = new Solution1087();
        String[]     array        = solution1087.expand("abcd");
        System.out.println(Arrays.toString(array));
    }
}
