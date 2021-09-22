package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 3:06 PM
 */
public class Solution246 {
    static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
    }

    public boolean isStrobogrammatic(String num) {

        char[] array = num.toCharArray();
        int    i     = 0;
        int    j     = array.length - 1;


        while (i <= j) {
            if (i == j) {
                if (!map.containsKey(array[i] - '0')) {
                    return false;
                } else if (!map.get(array[i] - '0').equals(array[i] - '0')) {
                    return false;
                }
            } else {
                if (!map.containsKey(array[i] - '0') || !map.containsKey(array[j] - '0')) {
                    return false;
                }
                if (!map.get(array[i] - '0').equals(array[j] - '0')) {
                    return false;
                }

                if (!map.get(array[j] - '0').equals(array[i] - '0')) {
                    return false;
                }
            }


            i++;
            j--;

        }

        return true;
    }

    public static void main(String[] args) {
        Solution246 solution246 = new Solution246();
        boolean     ans         = solution246.isStrobogrammatic("619");
        System.out.println(ans);
    }
}
