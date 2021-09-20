package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 1:35 PM
 */
public class Solution320 {
    List<String> ans = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {

        dfs(word, 0, "", 0);
        return ans;
    }

    private void dfs(final String word, int index, String tmp, int cnt) {
        if (index == word.length()) {
            if (cnt > 0) {
                tmp = tmp + String.valueOf(cnt);
            }
            ans.add(tmp);
            return;
        }
        char   ch = word.charAt(index);
        String t  = "";
        if (cnt > 0) {
            t = String.valueOf(cnt);
        }
        t = t + String.valueOf(ch);
        dfs(word, index + 1, tmp + t, 0);
        dfs(word, index + 1, tmp, cnt + 1);
    }

    public static void main(String[] args) {
        Solution320  solution320 = new Solution320();
        List<String> ans         = solution320.generateAbbreviations("word");
        System.out.println(ans);


    }
}
