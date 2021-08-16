package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/3
 * @time 1:51 PM
 */
class Relation {
    boolean knows(int a, int b) {
        return true;
    }
}

public class Solution277 extends Relation {
    public int findCelebrity(int n) {
        int[] outDegree = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (this.knows(i, j)) {
                    count++;
                }
            }
            outDegree[i] = count;
        }

        for (int i = 0; i < n; i++) {
            if (outDegree[i] == 1) {
                int count = 0;
                for (int row = 0; row < n; row++) {
                    if (knows(row, i)) {
                        count++;
                    }
                }
                if (count == n) {
                    return i;
                }
            }
        }
        return -1;
    }

}
