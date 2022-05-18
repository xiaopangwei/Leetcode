package leetcode.p2022m05.day0505;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 10:32 PM
 */
public class Solution679 {
    public boolean judgePoint24(int[] cards) {

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            list.add(cards[i] * 1.0);
        }
        return dfs(list);
    }

    private boolean dfs(List<Double> result) {
        if (result.size() == 1) {
            if (Math.abs(result.get(0) - 24) < 1e-6) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                double a = result.get(i);
                double b = result.get(j);

                List<Double> temp = new ArrayList<>();
                temp.add(a + b);
                temp.add(a - b);
                temp.add(b - a);
                temp.add(a * b);
                if (Math.abs(b) < 1e-6) {
                    temp.add(a / b);
                }
                if (Math.abs(a) < 1e-6) {
                    temp.add(b / a);
                }


                List<Double> list = new ArrayList<>();

                for (int t = 0; t < result.size(); t++) {
                    if (t != i && t != j) {
                        list.add(result.get(t));
                    }
                }

                for (Double item : temp) {
                    list.add(item);
                    if (dfs(list)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution679 solution679 = new Solution679();
        System.out.println(solution679.judgePoint24(new int[]{1,2,1,2}));
    }
}
