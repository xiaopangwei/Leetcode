package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/28
 * @time 10:15 PM
 */
public class Solution681 {
    private long minDiff = Integer.MAX_VALUE;
    private List<Character> ans;

    private int dayLong = 3600 * 24;

    public String nextClosestTime(String time) {
        String        newTime = time.replace(":", "");
        List<Integer> list    = new ArrayList<>();
        for (char item : newTime.toCharArray()) {
            int k = item - '0';
            if (list.contains(k)) {
                continue;
            }
            list.add(k);

        }

        dfs(list, 0, newTime, new ArrayList<>());


        char[] array = new char[5];
        array[0] = ans.get(0);
        array[1] = ans.get(1);
        array[2] = ':';
        array[3] = ans.get(2);
        array[4] = ans.get(3);

        return new String(array);
    }

    private int getDiff(String a, List<Character> b) {
        int h1 = (a.charAt(0) - '0') * 10 + (a.charAt(1) - '0');
        int m1 = (a.charAt(2) - '0') * 10 + (a.charAt(3) - '0');
        int h2 = (b.get(0) - '0') * 10 + (b.get(1) - '0');
        int m2 = (b.get(2) - '0') * 10 + (b.get(3) - '0');

        int t1 = h1 * 3600 + m1 * 60;
        int t2 = h2 * 3600 + m2 * 60;
        if (t2 > t1) {
            return t2 - t1;
        } else {
            return dayLong - (t1 - t2);
        }
    }

    private void dfs(List<Integer> list, int index, String time, List<Character> data) {
        if (index == 4) {
//            System.out.println(data);
            int diff = getDiff(time, data);
            if (diff < minDiff && diff > 0) {
                minDiff = diff;
                List<Character> copy = new ArrayList<>(data);
                ans = copy;
            }
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (index == 0 && list.get(i) > 2) {
                continue;
            }
            else if (index == 1) {
                if (data.get(data.size() - 1) == '2' && list.get(i) >= 4) {
                    continue;
                }
            }
            else if (index == 2 && list.get(i) > 5) {
                continue;
            }
            data.add((char) ('0' + list.get(i)));
            dfs(list, index + 1, time, data);
            data.remove(data.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution681 solution681 = new Solution681();
        String      ans         = solution681.nextClosestTime("23:59");
        System.out.println(ans);
    }

}
