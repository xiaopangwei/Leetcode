package leetcode.p2022m05.day0511;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 9:25 PM
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> freq = new HashMap<>();
        List<String>         ans  = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int j = i + 10;
            if (j > s.length()) {
                break;
            }
            String temp = s.substring(i, j);
            int    f    = freq.getOrDefault(temp, 0);
            if (f == 0) {
                freq.put(temp, 1);
            } else {
                freq.put(temp, f + 1);
                if (f == 1) {
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
