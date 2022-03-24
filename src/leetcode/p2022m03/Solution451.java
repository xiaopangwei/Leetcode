package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/7
 * @time 10:03 PM
 */
public class Solution451 {
    public String frequencySort(String s) {
        Map<Character, Integer> freq   = new HashMap<>();
        int                     maxVal = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxVal = Math.max(maxVal, freq.get(ch));
        }

        List<Character>[] array = new List[maxVal + 1];
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            int index = entry.getValue();
            if (array[index] == null) {
                array[index] = new ArrayList<>();
            }
            array[index].add(entry.getKey());

        }

        StringBuilder builder = new StringBuilder();
        for (int i = maxVal; i > 0; i--) {
            if (array[i] != null && !array[i].isEmpty()) {
                List<Character> list = array[i];
                for (char ch : list) {
                    for (int k = 0; k < freq.get(ch); k++) {
                        builder.append(ch);
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(array));
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution451 solution451 = new Solution451();
        String      ans         = solution451.frequencySort("2a554442f544asfasssffffasss");
        System.out.println(ans);
    }
}
