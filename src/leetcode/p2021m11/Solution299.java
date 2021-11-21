package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/8
 * @time 8:31 PM
 */
public class Solution299 {
    public String getHint(String secret, String guess) {

        Map<Integer, List<Integer>> valueAndPos = new HashMap<>();

        char[] array = secret.toCharArray();
        int    len   = array.length;
        for (int i = 0; i < len; i++) {
            int val=array[i] - '0';
            if (!valueAndPos.containsKey(val)) {
                valueAndPos.put(val, new ArrayList<>());
            }

            valueAndPos.get(val).add(i);
        }

        int a = 0;
        int b = 0;

        for (int i = 0; i < len; i++) {
            int val = guess.charAt(i) - '0';
            if (valueAndPos.containsKey(val)) {
                if (val == (array[i] - '0')) {
                    b++;
                    valueAndPos.get(val).remove((Integer) i);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            int val = guess.charAt(i) - '0';
            if (val == (array[i] - '0')) {
                continue;
            }
            if (valueAndPos.containsKey(val)) {
                List<Integer> posList = valueAndPos.get(val);
                if (posList != null && !posList.isEmpty()) {
                    posList.remove(0);
                    a++;
                }

            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(b).append("A").append(a).append("B");
        return builder.toString();

    }

    public static void main(String[] args) {
        Solution299 solution299 = new Solution299();
        String      res         = solution299.getHint("1", "1");
        System.out.println(res);
    }
}
