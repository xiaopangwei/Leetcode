package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/31
 * @time 6:03 PM
 */
public class Solution140 {
    public Map<String, List<String>> cached = new HashMap<>();


    public List<String> wordBreak(String s, List<String> wordDict) {

        return dfs(s, wordDict, new ArrayList<>());
    }

    public List<String> dfs(String source, final List<String> wordDict, List<String> selected) {
        if (cached.containsKey(source)) {
            return cached.get(source);
        }
        if (source.length() <= 0) {
            return Arrays.asList("");
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= source.length(); i++) {
            String left = source.substring(0, i);
            selected.add(left);
            if (wordDict.contains(left)) {
                String right = source.substring(i, source.length());

                List<String> temp        = dfs(right, wordDict, selected);
                List<String> combination = new ArrayList<>();
                for (String item : temp) {
                    if (item.isEmpty()) {
                        combination.add(left);
                    } else {
                        combination.add(left + " " + item);
                    }

                }

                res.addAll(combination);
            }
            selected.remove(selected.size() - 1);
        }


        if (!cached.containsKey(source)) {
            cached.put(source, res);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();
        List<String> ans = solution140.wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        System.out.println(ans);
    }
}
