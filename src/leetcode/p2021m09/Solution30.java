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
 * @date 2021/9/1
 * @time 8:34 PM
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {

        Map<String, Integer> freq = new HashMap<>();

        for (String item : words) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        int perLength = words[0].length();

        int width = perLength * words.length;


        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {

            int end = i + width - 1;
            if (end >= s.length()) {
                continue;
            }

            Map<String, Integer> map = new HashMap<>();

            boolean match = true;
            int     j     = i;
            while (j + perLength - 1 <= end) {
                String temp = s.substring(j, j + perLength);
//                System.out.println(i+" "+(j+perLength)+" "+temp);
                if (!freq.containsKey(temp)) {
                    match = false;
                    break;
                } else {
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
                j += perLength;
            }

            if (match) {
                boolean flag = true;
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    if (!entry.getValue().equals(freq.get(entry.getKey()))) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    ans.add(i);
                }
            }

        }

        return ans;
    }


    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();

        StringBuilder stringBuilder = new StringBuilder();
        String[]      array         = new String[5001];
        int           k             = 0;
        for (int i = 0; i < 5001; i++) {
            stringBuilder.append("a");
            array[k++] = "a";
        }
        String str = stringBuilder.toString();


        List<Integer> ans = solution30.findSubstring(str, array);
        System.out.println(ans);

    }
}
