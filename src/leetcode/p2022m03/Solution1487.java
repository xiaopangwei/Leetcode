package leetcode.p2022m03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/10
 * @time 9:08 PM
 */
public class Solution1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[]             res = new String[names.length];
        //["kaido","kaido(1)","kaido","kaido(1)"]
        //["kaido","kaido(1)","kaido(2)","kaido(1)(1)"]

        //["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
        //["onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"]
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!map.containsKey(name)) {
                map.put(name, 0);
                res[i] = name;
            } else {
                int    newTime = map.get(name) + 1;
                String temp    = name + "(" + newTime + ")";
                while (map.containsKey(temp)) {
                    newTime++;
                    temp = name + "(" + newTime + ")";
                }
                res[i] = temp;
                //TODO:一定要加，否则肯定要TLE
                map.put(name, map.get(name) + 1);
                map.put(temp, 0);
            }
        }
        System.out.println(map);
        return res;
    }

    public static void main(String[] args) {
        Solution1487 solution1487 = new Solution1487();
        String[]     res          = solution1487.getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"});
        System.out.println(Arrays.toString(res));
    }

}
