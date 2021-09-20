package leetcode.p2021m09;

import common.CustomTrie;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 2:49 PM
 */
public class Solution527 {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<String>> groupedMap = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int    len  = word.length();
            String key  = null;
            if (len > 3) {
                StringBuilder builder = new StringBuilder();
                key = builder
                        .append(word.charAt(0))
                        .append(word.length() - 2)
                        .append(word.charAt(len - 1))
                        .toString();
            } else {
                key = word;
            }


            if (!groupedMap.containsKey(key)) {
                groupedMap.put(key, new ArrayList<>());
            }
            groupedMap.get(key).add(words.get(i));
        }

        Map<String, String> afterMap = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : groupedMap.entrySet()) {
            List<String> list = entry.getValue();
            if (list.size() == 1) {
                String first = list.get(0);
                int    len   = first.length();
                if (len <= 3) {
                    afterMap.put(first, first);
                } else {
                    afterMap.put(first, entry.getKey());
                }
            } else {


                CustomTrie root = new CustomTrie("");
                for (int i = 0; i < list.size(); i++) {
                    CustomTrie.insert(root, list.get(i));
                }

                for (int i = 0; i < list.size(); i++) {
                    String     complete = list.get(i);
                    CustomTrie t        = CustomTrie.search(root, complete);

                    while (t.parent != null && t.parent.nextNodeMap.size() < 2) {
                        t = t.parent;
                    }
                    String head   = t.prefix;
                    String tail   = String.valueOf(complete.charAt(complete.length() - 1));
                    int remainedLength=complete.length() - 1 - head.length();
                    String middle = String.valueOf(remainedLength);

                    String abbr = head + middle + tail;
                    if (abbr.length() == complete.length() || remainedLength==0) {
                        afterMap.put(complete, complete);
                    } else {
                        afterMap.put(complete, abbr);
                    }

                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            ans.add(afterMap.get(word));
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution527 solution527 = new Solution527();
//
//        List<String> list = Arrays.asList("Huang", "123","Huan", "Hua", "Z");
//        String       ans  = solution527.getLongestCommonPrefix(list, 0, list.size() - 1);
//        System.out.println(ans + " " + ans.length());
        List<String> ans = solution527.wordsAbbreviation(Arrays.asList(
                "abcdefg", "abccefg", "abcckkg", "abccekg"
        ));
        System.out.println(ans);
    }
}
