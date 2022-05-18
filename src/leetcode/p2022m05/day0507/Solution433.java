package leetcode.p2022m05.day0507;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 9:52 AM
 */
public class Solution433 {

    public int minMutation(String start, String end, String[] bank) {
        boolean flag = false;
        for (String item : bank) {
            if (item.equals(end)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return -1;
        }
        Map<String, Integer> visited1 = new HashMap<>();
        Queue<String>        queue1   = new LinkedList<>();
        visited1.put(start, 0);
        queue1.add(start);

        Map<String, Integer> visited2 = new HashMap<>();
        Queue<String>        queue2   = new LinkedList<>();
        visited2.put(end, 0);
        queue2.add(end);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() <= queue2.size()) {
                String temp = queue1.poll();
                if (visited2.containsKey(temp)) {
                    return visited1.get(temp) + visited2.get(temp);
                } else {
                    for (String item : bank) {
                        if (visited1.containsKey(item)) {
                            continue;
                        }
                        if (check(item, temp)) {
                            visited1.put(item, visited1.get(temp) + 1);
                            queue1.add(item);
                        }
                    }
                }
            } else {
                String temp = queue2.poll();
                if (visited1.containsKey(temp)) {
                    return visited1.get(temp) + visited2.get(temp);
                } else {
                    for (String item : bank) {
                        if (visited2.containsKey(item)) {
                            continue;
                        }
                        if (check(item, temp)) {
                            visited2.put(item, visited2.get(temp) + 1);
                            queue2.add(item);
                        }
                    }
                }

            }
        }

        return -1;


    }

    private boolean check(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution433 solution433 = new Solution433();


        //"AACCGGTT" "AACCGCTA" ["AACCGGTA","AACCGCTA","AAACGGTA"]

        int ans = solution433.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
        System.out.println(ans);
    }
}
