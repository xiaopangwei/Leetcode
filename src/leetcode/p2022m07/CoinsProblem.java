package leetcode.p2022m07;

import common.uaf.UnionAndFind;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/24
 * @time 9:16 PM
 */
public class CoinsProblem {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int item : nums) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Iterator<Map.Entry<Integer, Integer>> iterator = freq.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> t = iterator.next();
            if (pq.size() < k) {
                pq.add(t);
            } else {
                if (pq.peek().getValue() < t.getValue()) {
                    pq.poll();
                    pq.add(t);
                }
            }
        }

        int[] ans   = new int[k];
        int   index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().getKey();
        }
        return ans;

    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int          n            = graph.length;
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    int px = unionAndFind.find(i);
                    int py = unionAndFind.find(j);
                    if (px != py) {
                        unionAndFind.union(px, py);
                    }
                }
            }
        }

        Arrays.sort(initial);
        int maxComponent = 0;
        int maxItem      = initial[0];
        for (int i = 0; i < initial.length; i++) {
            int     item   = initial[i];
            int     parent = unionAndFind.find(item);
            boolean flag   = true;
            for (int j = 0; j < initial.length; j++) {
                if (i == j) {
                    continue;
                }
                if (unionAndFind.find(initial[j]) == parent) {
                    flag = false;
                    break;
                }
            }
            if (flag) {

                int temp = unionAndFind.rank[parent];
                if (temp > maxComponent) {
                    maxComponent = temp;
                    maxItem = item;
                }
            }
        }
        return maxItem;
    }


    int[] candidates;
    int   target;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        this.candidates = candidates;
        Arrays.sort(candidates);
        dfs(new ArrayList<>(), 0, 0);
        return result;
    }

    private void dfs(List<Integer> list, int sum, int startIndex) {

        if (startIndex >= candidates.length || sum > target) {
            return;
        }

        if (sum == target) {
//            System.out.println(list);
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            result.add(temp);
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (candidates[i] + sum <= target) {
                list.add(candidates[i]);
                dfs(list, sum + candidates[i], i);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }

    }


    public static void main(String[] args) {
        CoinsProblem coinsProblem = new CoinsProblem();

        System.out.println(coinsProblem.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
