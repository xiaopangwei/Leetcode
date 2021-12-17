package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/13
 * @time 9:28 PM
 */
public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> posMap = new HashMap<>();
        char[]                  array  = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            posMap.put(array[i], i);
        }
        int           i     = 0;
        int           first = 0;
        int           last  = 0;
        List<Integer> ans   = new ArrayList<>();
        while (i < array.length) {

            int index = posMap.get(array[i]);
            last = Math.max(last, index);

            if (i == last) {
                ans.add(i - first + 1);
                first = i + 1;
            }
            i++;
        }

        return ans;

    }

    public static void main(String[] args) {
        Solution763   solution763 = new Solution763();
        List<Integer> ans         = solution763.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(ans);
    }
}
