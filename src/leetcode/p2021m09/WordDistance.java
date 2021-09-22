package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 2:33 PM
 */
public class WordDistance {

    Map<String, List<Integer>> posMap = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            if (!posMap.containsKey(wordsDict[i])) {
                posMap.put(wordsDict[i], new ArrayList<>());
            }
            posMap.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> posList1 = posMap.get(word1);
        List<Integer> posList2 = posMap.get(word2);

        int minLen = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        while (i < posList1.size() && j < posList2.size()) {
            int x = posList1.get(i);
            int y = posList2.get(j);
            minLen = Math.min(minLen, Math.abs(x - y));
            if (x < y) {
                i++;
            } else {
                j++;
            }
        }

        return minLen;
    }

    public static void main(String[] args){
        WordDistance wordDistance=new WordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"});
        int ans=wordDistance.shortest("makes","coding");
        System.out.println(ans);
    }
}
