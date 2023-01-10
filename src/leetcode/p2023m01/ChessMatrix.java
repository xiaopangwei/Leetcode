package leetcode.p2023m01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/7
 * @time 10:45 PM
 */
public class ChessMatrix {


    Map<Integer, LinkedList<Integer>> map = new HashMap<>();

    public boolean put(int color, int x) {
        if (!map.containsKey(x)) {
            map.put(x, new LinkedList<>());
        }
        map.get(x).add(color);
        return isContinuous(map.get(x),color,4);
    }


    private boolean isContinuous(LinkedList<Integer> list, int color, final int n) {
        int i = 0;
        while (i < list.size()) {
            if (list.get(i) != color) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < list.size() && list.get(j) == color) {
                j++;
            }

            int len = j - i;
            if (len >= n) {
                return true;
            }
            i = j;
        }
        return false;
    }
}
