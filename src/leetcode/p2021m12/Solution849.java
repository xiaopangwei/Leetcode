package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/16
 * @time 8:57 PM
 */
public class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int prev = -1;
        int i    = 0;
        int max  = 0;

        while (i < seats.length) {
            if (seats[i] == 1) {
                if (prev >= 0) {
                    max = Math.max(max, (i - prev) / 2);
                    prev = i;
                } else {
                    max = Math.max(max, i);
                    prev = i;
                }

            }
            i++;
        }

        if (seats[seats.length - 1] == 0) {
            max = Math.max(max, seats.length - 1 - prev);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution849 solution849 = new Solution849();

        int ans = solution849.maxDistToClosest(new int[]{0, 0, 0, 0, 0, 0, 1});
        System.out.println(ans);
    }
}
