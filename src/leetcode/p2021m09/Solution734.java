package leetcode.p2021m09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 10:25 PM
 */
public class Solution734 {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if (sentence1.length != sentence2.length) {
            return false;
        }
        Set<String> sets = new HashSet<>();
        for (List<String> item : similarPairs) {
            sets.add(item.get(0) + "#" + item.get(1));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            String key1 = sentence1[i] + "#" + sentence2[i];
            String key2 = sentence2[i] + "#" + sentence1[i];
            if (!sets.contains(key1) && !sets.contains(key2)) {
                return false;
            }
        }
        return true;
    }
}
