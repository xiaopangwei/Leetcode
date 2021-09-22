package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 2:45 PM
 */
public class Solution245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int minLen = wordsDict.length + 1;
        if (word1.equals(word2)) {
            int last = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equals(wordsDict[i])) {
                    if (last == -1) {
                        last = i;
                    } else {
                        minLen = Math.min(minLen, i - last);
                        last=i;
                    }
                }
            }
            return minLen;
        }

        List<Integer> wordPosList1 = new ArrayList<>();
        List<Integer> wordPosList2 = new ArrayList<>();


        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (!wordPosList2.isEmpty()) {
                    minLen = Math.min(minLen, i - wordPosList2.get(wordPosList2.size() - 1));
                }
                wordPosList1.add(i);
            }
            if (wordsDict[i].equals(word2)) {
                if (!wordPosList1.isEmpty()) {
                    minLen = Math.min(minLen, i - wordPosList1.get(wordPosList1.size() - 1));
                }
                wordPosList2.add(i);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        Solution245 solution245 = new Solution245();
        // word1 = “coding”, word2 = “practice”
        int ans = solution245.shortestWordDistance(
                new String[]{"a", "c", "a", "a"},
                "a", "a");
        System.out.println(ans);
    }
}
