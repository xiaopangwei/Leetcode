package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 3:47 PM
 */
public class Solution140 {
    List<String> ans = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, 0, wordDict, new ArrayList<>());

        return ans;
    }

    private boolean dfs(String s, int left, List<String> wordDict, List<String> temp) {
        if (left >= s.length()) {
            ans.add(String.join(" ",temp));
            return true;
        }
        for (int i = left; i < s.length(); i++) {
            String a = s.substring(left, i + 1);
            if (!wordDict.contains(a)) {
                continue;
            }
            temp.add(a);
            dfs(s, i + 1, wordDict, temp);
            temp.remove(temp.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution140  solution140 = new Solution140();
        List<String> ans         = solution140.wordBreak("catsandog",
                Arrays.asList("cats","dog","sand","and","cat"));
        System.out.println(ans);
    }
}
