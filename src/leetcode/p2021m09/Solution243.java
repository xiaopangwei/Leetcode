package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 2:10 PM
 */
public class Solution243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {

        List<Integer> wordPosList1 = new ArrayList<>();
        List<Integer> wordPosList2 = new ArrayList<>();

        int minLen = wordsDict.length + 1;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (!wordPosList2.isEmpty()) {
                    minLen = Math.min(minLen, i - wordPosList2.get(wordPosList2.size() - 1));
                }
                wordPosList1.add(i);
            } else if (wordsDict[i].equals(word2)) {
                if (!wordPosList1.isEmpty()) {
                    minLen = Math.min(minLen, i - wordPosList1.get(wordPosList1.size() - 1));
                }
                wordPosList2.add(i);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        Solution243 solution243 = new Solution243();
        // word1 = “coding”, word2 = “practice”
        int ans = solution243.shortestDistance(
                new String[]{"practice", "makes", "perfect", "coding", "makes"},
                "makes", "coding");
        System.out.println(ans);
    }
}
