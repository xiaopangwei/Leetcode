package leetcode.p2021m11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/27
 * @time 2:13 PM
 */
public class Solution519 {
    Set<Integer> sets   = new HashSet<>();
    Random       random = new Random();
    int m;
    int n;
    int cnt;

    public Solution519(int m, int n) {
        this.m = m;
        this.n = n;
        this.cnt = m * n;
    }

    public int[] flip() {

        int index = random.nextInt(cnt);
        if (!sets.contains(index)) {
            sets.add(index);
            return new int[]{index / n, index % n};
        } else {
            int i = index - 1;
            while (i >= 0 && sets.contains(i)) {
                i--;
            }

            if (i >= 0) {
                sets.add(i);
                return new int[]{i / n, i % n};
            }

            int j = index + 1;
            while (j < cnt && sets.contains(j)) {
                j++;
            }
            sets.add(j);
            return new int[]{j / n, j % n};

        }

    }

    public void reset() {
        sets.clear();
    }

    public static void main(String[] args) {
        Solution519 solution519 = new Solution519(10, 10);

    }
}
