package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/10
 * @time 8:55 PM
 */
public class Solution1087 {
    // s = "{a,b}c{d,e}f"
    // 输出：["acdf","acef","bcdf","bcef"]
    // ads{a,b,c}f
    //请你 按字典顺序 ，返回所有以这种方式形成的单词。

    List<String> ans = new ArrayList<>();

    public String[] expand(String s) {
        dfs(s);
        Collections.sort(ans);
        return ans.toArray(new String[]{});
    }

    private void dfs(String s) {
        if (!s.contains("{")) {
            ans.add(s);
            return;
        }
        int startOfFirstBucket = s.indexOf("{");
        int endOfFirstBucket   = s.indexOf("}");

        String content = s.substring(startOfFirstBucket + 1, endOfFirstBucket);

        String[] array = content.split(",");

        String prefix = s.substring(0, startOfFirstBucket);
        String suffix = s.substring(endOfFirstBucket + 1, s.length());
        for (String item : array) {
            dfs(prefix + item + suffix);
        }
    }

    public static void main(String[] args) {
        Solution1087 solution1087 = new Solution1087();
        String[]     ans          = solution1087.expand("abcd");
        System.out.println(Arrays.toString(ans));
    }
}
