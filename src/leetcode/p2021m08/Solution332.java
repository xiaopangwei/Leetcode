package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/10
 * @time 10:58 AM
 */
public class Solution332 {

    private List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> map     = new TreeMap<>();
        Map<String, Boolean>      visited = new HashMap<>();
        for (List<String> list : tickets) {
            String key = list.get(0);
            String val = list.get(1);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(val);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
        }
        List<String> list = new ArrayList<>();
        list.add("JFK");
        dfs(map, "JFK", list, tickets.size() + 1, visited);

        return ans;
    }

    private boolean dfs(final Map<String, List<String>> map,
                        String start, List<String> res, final int total, Map<String, Boolean> visited) {
        System.out.println(start);
        if (res.size() == total) {
            for (String item : res) {
                ans.add(item);
            }
            return true;
        }
        List<String> list = map.get(start);
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {

            String next = list.get(i);
            String key  = start + "#" + i;
            if (visited.containsKey(key)) {
                continue;
            }
            res.add(next);
            visited.put(key, true);
            boolean flag = dfs(map, next, res, total, visited);
            if (flag) {
                return true;
            }
            res.remove(res.size() - 1);
            visited.remove(key);
        }
        return false;

    }

    public static void main(String[] args) {
        Solution332 solution332 = new Solution332();
        String[][] array = {{"EZE", "AXA"}, {"TIA", "ANU"}, {"ANU", "JFK"}, {"JFK", "ANU"}, {"ANU", "EZE"}, {"TIA", "ANU"},
                {"AXA", "TIA"}, {"TIA", "JFK"}, {"ANU", "TIA"}, {"JFK", "TIA"}};

        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            String[] temp = array[i];
            list.add(Arrays.asList(temp[0], temp[1]));
        }
        List<String> output = solution332.findItinerary(list);
        System.out.println(output);
    }
}
