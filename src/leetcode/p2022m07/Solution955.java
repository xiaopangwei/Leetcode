package leetcode.p2022m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/21
 * @time 9:29 PM
 */
public class Solution955 {
    public int minDeletionSize(String[] strs) {

        int       ans     = 0;
        boolean[] visited = new boolean[strs.length];
        for (int j = 0; j < strs[0].length(); j++) {
            boolean isNeedToDelete = false;
            for (int i = 1; i < strs.length; i++) {
                if (visited[i]) {
                    continue;
                }
                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
                    ans++;
                    isNeedToDelete = true;
                    break;
                }
            }

            if (!isNeedToDelete) {
                for (int i = 1; i < strs.length; i++) {
                    //一定要大于
                    if (strs[i].charAt(j) > strs[i - 1].charAt(j)) {
                        visited[i] = true;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution955 solution955 = new Solution955();
        //["xga","xfb","yfa"]
        int         ans         = solution955.minDeletionSize(new String[]{"xga","xfb","yfa"});
        System.out.println(ans);
    }
}
