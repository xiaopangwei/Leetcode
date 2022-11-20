package leetcode.p2022q4;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/10/9
 * @time 8:36 PM
 */
public class PRAC20221010 {

    public int[][] imageSmoother(int[][] img) {
        int     m   = img.length;
        int     n   = img[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = avg(img, i, j);
            }
        }
        return ans;
    }


    private int avg(int[][] img, int x, int y) {

        int sum = 0;
        int cnt = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i < img.length && i >= 0 && j < img[0].length && j >= 0) {
                    sum += img[i][j];
                    cnt++;
                }
            }
        }
        if (cnt == 0 || sum == 0) {
            return 0;
        }
        return (int) Math.floor(sum / cnt);
    }

    public String reverseStr(String s, int k) {
        return dfs(s, 0, k);
    }


    private String dfs(String src, int startIndex, int k) {
        if (startIndex >= src.length()) {
            return src;
        }
        int    maxLen         = src.length();
        int    nextStartIndex = Math.min(maxLen, startIndex + 2 * k);
        int    t              = Math.min(startIndex + k, src.length());
        String temp           = new StringBuilder(src.substring(startIndex, t)).reverse().toString() + src.substring(t, Math.min(maxLen, t + k));
        int    leftLen        = maxLen - nextStartIndex;
        if (leftLen < k) {
            return temp + new StringBuilder(src.substring(nextStartIndex, maxLen)).reverse().toString();

        } else if (leftLen < 2 * k) {
            return temp + new StringBuilder(src.substring(nextStartIndex, nextStartIndex + k)).reverse().toString() + src.substring(nextStartIndex + k, maxLen);
        } else {
            return temp + dfs(src, nextStartIndex, k);
        }
    }


    Map<Integer, Integer> cached = new HashMap<>();

    public int numDecodings(String s) {
        return dfs(s, 0);
    }

    private int dfs(String s, int startIndex) {
        if (cached.containsKey(startIndex)) {
            return cached.get(startIndex);
        }
        if (startIndex >= s.length()) {
            cached.put(startIndex, 1);
            return 1;
        }
        char first = s.charAt(startIndex);
        if (first == '0') {
            cached.put(startIndex, 0);
            return 0;
        }
        int ans = dfs(s, startIndex + 1);
        if (startIndex + 1 < s.length()) {
            char second = s.charAt(startIndex + 1);
            if (first == '1' || (first == '2' && second >= '0' && second <= '6')) {
                ans += dfs(s, startIndex + 2);
            }
        }
        cached.put(startIndex, ans);
        return ans;
    }


    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> subProcessMap = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int pp = ppid.get(i);
            if (!subProcessMap.containsKey(pp)) {
                subProcessMap.put(pp, new ArrayList<>());
            }
            subProcessMap.get(pp).add(pid.get(i));
        }
        List<Integer>  ans   = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(kill);
        ans.add(kill);
        while (!queue.isEmpty()) {
            int           temp  = queue.poll();
            List<Integer> tList = subProcessMap.get(temp);
            if (tList != null) {
                for (int t : tList) {
                    if (!ans.contains(t)) {
                        queue.add(t);
                        ans.add(t);
                    }
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        PRAC20221010 prac20221010 = new PRAC20221010();
        System.out.println(prac20221010.numDecodings("111111111111111111111111111111111111111111111"));
//        System.out.println(prac20221010.reverseStr("abcd", 2));
//        int[][]      ans          = prac20221010.imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}});
//        for (int i = 0; i < ans.length; i++) {
//            System.out.println(Arrays.toString(ans[i]));
//        }

    }

}
