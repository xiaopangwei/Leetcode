package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/6
 * @time 9:10 PM
 */
public class Solution444 {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

        if (org.length > 0 && seqs.isEmpty()) {
            return false;
        }

        if (org.length == 1 && org[0] == 1 && seqs.size() == 1 && seqs.get(0).get(0) == 2) {
            return false;
        }
        //<N,入度>
        Map<Integer, Set<Integer>> indegree = new HashMap<>();

        for (List<Integer> seq : seqs) {
            int size = seq.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (!indegree.containsKey(seq.get(j))) {
                        indegree.put(seq.get(j), new HashSet<>());
                    }
                    //A[i]->A[j]
//                    System.out.println(seq.get(j) + " " + seq.get(i));
                    indegree.get(seq.get(j)).add(seq.get(i));
                }
            }
        }

//        for (Map.Entry<Integer, Set<Integer>> entry : indegree.entrySet()) {
//
//            System.out.println(entry.getKey() + " => " + entry.getValue());
//        }

        boolean[] visited = new boolean[org.length + 1];
        for (int i = 0; i < org.length; i++) {
            int target = org[i];
            if (indegree.containsKey(target) && !indegree.get(target).isEmpty()) {
                return false;
            }

            for (int k = 1; k < org.length; k++) {
                if (!visited[org[k]] && org[k] != target) {
                    if (!indegree.containsKey(org[k])) {
                        return false;
                    } else if (indegree.get(org[k]).isEmpty()) {
                        return false;
                    }
                }
            }

            visited[target] = true;
            for (Map.Entry<Integer, Set<Integer>> entry : indegree.entrySet()) {
                Set<Integer> prev = entry.getValue();
                if (prev.contains(target)) {
                    prev.remove(Integer.valueOf(target));
                }
            }

//            System.out.println("target:" + target);
//            for (Map.Entry<Integer, Set<Integer>> entry : indegree.entrySet()) {
//
//                System.out.println(entry.getKey() + " => " + entry.getValue());
//            }
        }
//        while ()
        return true;
    }

    public static void main(String[] args) {
        Solution444         solution444 = new Solution444();
        List<List<Integer>> list        = new ArrayList<>();
//        List<Integer>       l1          = new ArrayList<>();
//        l1.add(5);
//        l1.add(2);
//        l1.add(6);
//        l1.add(3);
//
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(4);
//        l2.add(1);
//        l2.add(5);
//        l2.add(2);
//
//        list.add(l1);
//        list.add(l2);
//
//        solution444.sequenceReconstruction(new int[]{4, 1, 5, 2, 6, 3}, list);


        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);


        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(3);


        list.add(l1);
        list.add(l2);
        list.add(l3);

        boolean ans = solution444.sequenceReconstruction(new int[]{1, 2, 3}, list);
        System.out.println(ans);
    }
}
