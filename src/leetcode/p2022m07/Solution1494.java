//package leetcode.p2022m07;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * <p>Description: </p>
// * <p>Company: Harbin Institute of Technology</p>
// *
// * @author weihuang
// * @date 2022/7/21
// * @time 8:31 PM
// */
//public class Solution1494 {
//    int[]                       indegree;
//    int[]                       outDegree;
//    Map<Integer, List<Integer>> nextList;
//    int k = 0;
//
//    public int minNumberOfSemesters(int n, int[][] relations, int k) {
//        indegree = new int[n + 1];
//        outDegree = new int[n + 1];
//        nextList = new HashMap<>();
//
//        for (int[] item : relations) {
//            int x = item[0];
//            int y = item[1];
//            indegree[y]++;
//            outDegree[x]++;
//            if (!nextList.containsKey(x)) {
//                nextList.put(x, new ArrayList<>());
//            }
//            nextList.get(x).add(y);
//        }
//
//        List<Integer> candidates = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            if (indegree[i] == 0) {
//                candidates.add(i);
//            }
//        }
//
//
//        return 0;
//    }
//
//    private int dfs(final int n, boolean[] visited, List<Integer> candidates) {
////        //
////
////        for (int i=1;i<=n;i++){
////            if (visited[i]||!candidates.contains(i)){
////                continue;
////            }
////
////            candidates.remove((Integer)i);
////            visited[i]=true;
////
////            for (int j=i+1;j<=n;j++){
////                if (visited[j]||!candidates.contains(j)){
////                    continue;
////                }
////                candidates.remove((Integer)j);
////                visited[j]=true;
////            }
////        }
////
////
////    }
//
//
//    public static void main(String[] args) {
//        int[][]      array        = new int[][]{{12, 8}, {2, 4}, {3, 7}, {6, 8}, {11, 8}, {9, 4}, {9, 7}, {12, 4}, {11, 4}, {6, 4}, {1, 4}, {10, 7}, {10, 4}, {1, 7}, {1, 8}, {2, 7}, {8, 4}, {10, 8}, {12, 7}, {5, 4}, {3, 4}, {11, 7}, {7, 4}, {13, 4}, {9, 8}, {13, 8}};
//        Solution1494 solution1494 = new Solution1494();
//        int          ans          = solution1494.minNumberOfSemesters(13, array, 9);
//        System.out.println(ans);
//    }
//}
