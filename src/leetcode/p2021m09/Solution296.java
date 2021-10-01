package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/30
 * @time 10:33 PM
 */
public class Solution296 {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int           ans  = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

//        Collections.sort(rows);
        Collections.sort(cols);

        int middleX = rows.get(rows.size() / 2);
        int middleY = cols.get(cols.size() / 2);


        for (int i = 0; i < rows.size(); i++) {
            ans += Math.abs(rows.get(i) - middleX);
        }

        for (int i = 0; i < cols.size(); i++) {
            ans += Math.abs(cols.get(i) - middleY);
        }

        return ans;
    }
}
