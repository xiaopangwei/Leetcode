package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/22
 * @time 10:02 AM
 */
public class Solution789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {

        int dist = Math.abs(target[0]) + Math.abs(target[1]);

        for (int[] arr : ghosts) {
            int temp = Math.abs(arr[0] - target[0]) + Math.abs(arr[1] - target[1]);
            if (temp <= dist) {
                return false;
            }
        }

        return true;
    }
}
