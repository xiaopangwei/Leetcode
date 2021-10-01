package leetcode.p2021m09;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:03 PM
 */
public class Solution1436 {
    public String destCity(List<List<String>> paths) {

        Set<String> candidates = new HashSet<>();
        Set<String> impossible = new HashSet<>();

        for (int i = 0; i < paths.size(); i++) {
            candidates.add(paths.get(i).get(1));
            impossible.add(paths.get(i).get(0));
        }
        String ans = null;

        for (String item : candidates) {
            if (!impossible.contains(item)) {
                ans = item;
            }
        }

        return ans;
    }
}
