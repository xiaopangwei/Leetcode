package demo;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 11:09 PM
 */
public class MatchSolution {
    int minGap;
    int maxGap;

    public boolean isExist(int[] nums, int minGap, int maxGap) {
        this.minGap = minGap;
        this.maxGap = maxGap;
        return dfs(nums, new boolean[nums.length], 0);
    }

    private boolean dfs(int[] nums, boolean[] visited, int count) {
        if (count == nums.length / 2) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (Math.abs(nums[i] - nums[j]) >= minGap || nums[i] + nums[j] < maxGap) {
                    continue;
                }
                visited[j] = true;
                if (dfs(nums, visited, count + 1)) {
                    return true;
                }
                visited[j] = false;
            }
            visited[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        MatchSolution solution = new MatchSolution();
        boolean       ans      = solution.isExist(new int[]{10, 20, 30, 50, 40, 50}, 19, 20);
        System.out.println(ans);
    }
}
