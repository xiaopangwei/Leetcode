package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 9:35 PM
 */
public class Solution17 {
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) {
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        dfs(map, digits, 0, new StringBuilder());

        return ans;
    }

    private void dfs(Map<Character, String> map, String digits, int index, StringBuilder builder) {
        if (index == digits.length()) {
            ans.add(builder.toString());
            return;
        }
        String temp = map.get(digits.charAt(index));
        for (char ch : temp.toCharArray()) {
            int len = builder.length();
            builder.append(ch);
            dfs(map, digits, index + 1, builder);
            builder.setLength(len);
        }
    }

    public static void main(String[] args) {
        Solution17   solution17 = new Solution17();
        List<String> ans        = solution17.letterCombinations("2");
        System.out.println(ans);
    }
}
