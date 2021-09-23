package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 8:18 PM
 */
public class Solution267 {
    Set<String> ans = new HashSet<>();

    public List<String> generatePalindromes(String s) {


        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        int                                 count = 0;
        List<Map.Entry<Character, Integer>> list  = new ArrayList<>(freq.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        char middle = 0;
        for (Map.Entry<Character, Integer> e : list) {
            if (e.getValue() % 2 == 1) {
                middle = e.getKey();
                count++;
            }
        }
        if (count > 1) {
            return new ArrayList<>();
        }


        dfs(list, new char[s.length()], 0, middle);
        return new ArrayList<>(ans);
    }

    private void dfs(List<Map.Entry<Character, Integer>> available, char[] array, int index, char middle) {


        if (index >= array.length / 2) {
            if (array.length % 2 == 1) {
                array[index] = middle;
            }
            ans.add(new String(array));
            return;
        }

        for (int i = 0; i < available.size(); i++) {
            Map.Entry<Character, Integer> entry = available.get(i);
            char                          key   = entry.getKey();
            int                           f     = entry.getValue();
            if (entry.getValue() >= 2) {
                array[index] = key;
                array[array.length - 1 - index] = key;
                entry.setValue(f - 2);

                dfs(available, array, index + 1, middle);

                array[index] = 0;
                array[array.length - 1 - index] = 0;
                entry.setValue(f);
            }
        }
    }

    public static void main(String[] args) {
        Solution267  solution267 = new Solution267();
        List<String> ans         = solution267.generatePalindromes("aacaa");
        System.out.println(ans);
    }
}
