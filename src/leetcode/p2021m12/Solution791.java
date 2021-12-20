package leetcode.p2021m12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 10:54 AM
 */
public class Solution791 {
    public String customSortString(String order, String s) {

        char[] rank = new char[order.length()];

        int[] tempArray = new int[26];
        Arrays.fill(rank, (char) 0);
        Arrays.fill(tempArray, -1);
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            rank[i] = ch;
            tempArray[ch - 'a'] = i;
        }

        Map<Character, Integer> freq = new HashMap<>();

        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (tempArray[ch - 'a'] != -1) {
                freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            } else {
                tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
            }
        }


        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < rank.length; i++) {
            char ch    = rank[i];
            int  times = freq.getOrDefault(ch, 0);
            for (int k = 0; k < times; k++) {
                resBuilder.append(ch);
            }
        }

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                resBuilder.append(entry.getKey());
            }
        }


        return resBuilder.toString();
    }

    public static void main(String[] args) {
        Solution791 solution791 = new Solution791();
        String      ans         = solution791.customSortString("cba", "abcd");
        System.out.println(ans);
    }
}
