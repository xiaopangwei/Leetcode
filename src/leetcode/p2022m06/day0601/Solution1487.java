package leetcode.p2022m06.day0601;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/11
 * @time 10:46 PM
 */
public class Solution1487 {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> freq = new HashMap<>();
        List<String>         ans  = new ArrayList<>();
        for (String name : names) {
            if (!freq.containsKey(name)) {
                ans.add(name);
                freq.put(name, 0);
            } else {
                int    times = freq.get(name) + 1;
                String key   = name + "(" + times + ")";
                while (true) {
                    if (freq.containsKey(key)) {
                        times++;
                        key = name + "(" + times + ")";
                    } else {
                        break;
                    }
                }
                ans.add(key);
                freq.put(key, 0);
                System.out.println(key+" 设置成0");
                freq.put(name, freq.get(name) + 1);
                System.out.println(name+" 设置成"+freq.get(name));
            }
        }
        String[] array = new String[names.length];
        ans.toArray(array);
        return array;
    }

    public static void main(String[] args) {
        Solution1487 solution1487 = new Solution1487();
        //["kaido","kaido(1)","kaido","kaido(1)","kaido(2)"]
        String[] ans = solution1487.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"});
        System.out.println(Arrays.toString(ans));
    }
}
