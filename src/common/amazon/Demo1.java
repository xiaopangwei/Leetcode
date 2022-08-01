package common.amazon;

import common.uaf.UnionAndFind;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/6
 * @time 11:06 PM
 */
public class Demo1 {
    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        TreeMap<Long, Integer> freq = new TreeMap<>();
        for (String log : logs) {
            String[] array = log.split(" ");
            long     u1    = Long.parseLong(array[0]);
            long     u2    = Long.parseLong(array[1]);

            freq.put(u1, freq.getOrDefault(u1, 0) + 1);
            if (u1 != u2){
                freq.put(u2, freq.getOrDefault(u2, 0) + 1);
            }
        }

        Iterator<Map.Entry<Long, Integer>> iterator = freq.entrySet().iterator();
        List<String>                       list     = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry<Long, Integer> entry = iterator.next();
            if (entry.getValue() >= threshold) {
                list.add(String.valueOf(entry.getKey()));
            }
        }

        return list;

    }

    public static int countGroups(List<String> related) {
        int          len          = related.size();
        int[][]      grid         = new int[len][len];
        UnionAndFind unionAndFind = new UnionAndFind(len);
        for (int i = 0; i < related.size(); i++) {
            for (int j = 0; j < related.get(i).length(); j++) {
                grid[i][j] = related.get(i).charAt(j) - '0';
            }
        }


        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1 && grid[j][i] == 1) {
                    if (unionAndFind.find(i) != unionAndFind.find(j)) {
                        unionAndFind.union(i, j);
                    }
                }

            }
        }


        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (unionAndFind.find(i) == i) {
                ans++;
            }
        }
        return ans;

    }
}
