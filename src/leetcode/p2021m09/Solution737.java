package leetcode.p2021m09;

import common.uaf.UnionAndFind;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 10:30 PM
 */
public class Solution737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        if (sentence1.length != sentence2.length) {
            return false;
        }


        Map<String, Integer> map = new HashMap<>();


        int count = 0;

        for (int i = 0; i < similarPairs.size(); i++) {
            if (!map.containsKey(similarPairs.get(i).get(0))) {
                map.put(similarPairs.get(i).get(0), count++);
            }
            if (!map.containsKey(similarPairs.get(i).get(1))) {
                map.put(similarPairs.get(i).get(1), count++);
            }
        }

        UnionAndFind unionAndFind = new UnionAndFind(map.keySet().size());

        for (int i = 0; i < similarPairs.size(); i++) {
            String k1 = similarPairs.get(i).get(0);
            String k2 = similarPairs.get(i).get(1);
            unionAndFind.union(map.get(k1), map.get(k2));
        }

        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }

            if (!map.containsKey(sentence1[i]) || !map.containsKey(sentence2[i])){
                return false;
            }
            int p1 = unionAndFind.find(map.get(sentence1[i]));
            int p2 = unionAndFind.find(map.get(sentence2[i]));

            if (p1 != p2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution737 solution737 = new Solution737();
//        [["great", "fine"], ["acting","drama"], ["skills","talent"]]
        List<List<String>> pairs = new ArrayList<>();

        pairs.add(Arrays.asList("great", "fine"));
        pairs.add(Arrays.asList("acting", "drama"));
        pairs.add(Arrays.asList("skills", "talent"));
        pairs.add(Arrays.asList("good", "great"));

        boolean ans = solution737.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
                new String[]{"good", "drama", "talent"}, pairs);

        System.out.println(ans);
    }
}
