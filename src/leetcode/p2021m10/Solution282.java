package leetcode.p2021m10;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/16
 * @time 10:00 AM
 */
public class Solution282 {
    List<String> ans = new ArrayList<>();

    int target;

    public List<String> addOperators(String num, int target) {

        this.target=target;
        dfs(num, 0, 0, 0, new ArrayList<>());

        return ans;
    }

    private void dfs(String s, int index, long accumulation, long prevVal, List<String> path) {
//        System.out.println(path);
        if (index >= s.length()) {
            if (accumulation == target) {
                ans.add(String.join("", path));
            }
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (sub.length() >= 2 && sub.startsWith("0")) {
                continue;
            }
            long current = Long.parseLong(sub);
            if (index == 0) {

                path.add(sub);
                dfs(s, i + 1, current, current, path);
                path.remove(path.size() - 1);
            } else {

                path.add("+");
                path.add(sub);
                dfs(s, i + 1, accumulation + current, current, path);
                path.remove(path.size() - 1);
                path.remove(path.size() - 1);


                path.add("-");
                path.add(sub);
                dfs(s, i + 1, accumulation - current, -current, path);
                path.remove(path.size() - 1);
                path.remove(path.size() - 1);


                path.add("*");
                path.add(sub);
                long t = accumulation - prevVal + prevVal * current;
                dfs(s, i + 1, t, prevVal * current, path);
                path.remove(path.size() - 1);
                path.remove(path.size() - 1);
            }


        }

    }

    public static void main(String[] args) {
        Solution282  solution282 = new Solution282();
        List<String> ans         = solution282.addOperators("00", 0);
        System.out.println(ans);
    }
}
