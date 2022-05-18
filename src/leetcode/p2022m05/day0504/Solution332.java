package leetcode.p2022m05.day0504;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 9:13 PM
 */
public class Solution332 {
    List<String> ans = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> srcAndTarget = new HashMap<>();
        int                       n            = tickets.size();
        for (int i = 0; i < n; i++) {
            String source = tickets.get(i).get(0);
            String target = tickets.get(i).get(1);
            if (!srcAndTarget.containsKey(source)) {
                srcAndTarget.put(source, new LinkedList<>());
            }
            srcAndTarget.get(source).add(target);
        }

        for (String key : srcAndTarget.keySet()) {
            Collections.sort(srcAndTarget.get(key));
        }
        dfs("JFK", n, srcAndTarget, new LinkedList<>());
        return ans;

    }

    private boolean dfs(String start, int n, Map<String, List<String>> srcAndTarget, List<String> visited) {
        if (visited.size() == n) {
            ans.add("JFK");
            for (String item : visited) {
                String[] array = item.split("#");
                ans.add(array[1]);
            }
            return true;
        }

        List<String> nextList = srcAndTarget.get(start);
        if (nextList == null || nextList.isEmpty()) {
            return false;
        }
        for (int i = 0; i < nextList.size(); i++) {
            String next  = nextList.get(i);
            String biKey = start + "#" + next;
            if (!visited.contains(biKey)) {
                visited.add(biKey);
                if (dfs(next, n, srcAndTarget, visited)) {
                    return true;
                }
                visited.remove(visited.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //[["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        String[][]         array = new String[][]{{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        List<List<String>> list  = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(Arrays.asList(array[i][0], array[i][1]));
        }
        Solution332 solution332 = new Solution332();
        System.out.println(solution332.findItinerary(list));

    }
}
