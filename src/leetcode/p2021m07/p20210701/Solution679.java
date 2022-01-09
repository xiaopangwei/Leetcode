package leetcode.p2021m07.p20210701;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/2
 * @time 4:13 PM
 */
public class Solution679 {
    public boolean judgePoint24(int[] cards) {

        List<Double> candidates = new ArrayList<>(cards.length);
        for (int item : cards) {
            candidates.add((double) item * 1.0);
        }

        return dfs(candidates);

    }

    private boolean dfs(List<Double> candidates) {

        if (candidates.size() == 1) {
            if (Math.abs(candidates.get(0) - 24.0) < 0.00000001) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < candidates.size(); i++) {
            for (int j = i + 1; j < candidates.size(); j++) {

                double a = candidates.get(i);
                double b = candidates.get(j);


                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < candidates.size(); k++) {
                    if (k != i && k != j) {
                        newList.add(candidates.get(k));
                    }
                }


                double c1 = a + b;
                double c2 = a * b;
                double c3 = b - a;
                double c4 = a - b;

                List<Double> temp = new ArrayList<>();
                temp.add(c1);
                temp.add(c2);
                temp.add(c3);
                temp.add(c4);
                if (a != 0) {
                    temp.add(b / a);
                }
                if (b != 0) {
                    temp.add(a / b);
                }

                for (double item : temp) {
//                    System.out.println("add "+item);
                    newList.add(item);
                    boolean flag = dfs(newList);
                    if (flag) {
//                        System.out.println(true);
                        return true;
                    }
                    newList.remove(item);

                }

            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution679 solution679 = new Solution679();
//        List<Integer> ans         = new ArrayList<>(5);
//        ans.add(10);
//        ans.add(3);
//        ans.add(0);
//        ans.add(100);
//        ans.add(80);
//
//        //1,2
//        System.out.println(ans);
//        //删除3
//        int val1 = ans.remove(1);
//        System.out.println(val1);
//        //删除3
//        int val2 = ans.remove(1);
//        System.out.println(val2);
        boolean flag = solution679.judgePoint24(new int[]{7,7,8,9});
        System.out.println(flag);
    }


}
