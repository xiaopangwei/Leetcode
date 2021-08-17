package leetcode.p2021m08;

import common.uaf.UnionAndFindWithWeight;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 3:08 PM
 */
public class Solution399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Integer>   map                    = new HashMap<>();
        UnionAndFindWithWeight unionAndFindWithWeight = new UnionAndFindWithWeight(21);
        int                    idx                    = 0;

        for (int i = 0; i < equations.size(); i++) {

            List<String> equation = equations.get(i);
            String       a        = equation.get(0);
            String       b        = equation.get(1);


            int left  = -1;
            int right = -1;
            if (map.containsKey(a)) {
                left = map.get(a);
            } else {
                map.put(a, idx);
                left = idx++;
            }

            if (map.containsKey(b)) {
                right = map.get(b);
            } else {
                map.put(b, idx);
                right = idx++;
            }

            unionAndFindWithWeight.union(left, right, values[i]);
        }


        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> equation = queries.get(i);
            String       a        = equation.get(0);
            String       b        = equation.get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                ans[i] = -1.0;
            } else {
                int temp1 = map.get(a);
                int temp2 = map.get(b);

                if (unionAndFindWithWeight.find(temp1) != unionAndFindWithWeight.find(temp2)) {
                    ans[i] = -1.0;
                } else {
                    ans[i] = unionAndFindWithWeight.weight[temp1] / unionAndFindWithWeight.weight[temp2];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution399 solution399 = new Solution399();
        String[][]  a1          = new String[][]{{"a","b"},{"b","c"}};
        double[]    vals        = new double[]{2.0,3.0};
        String[][]  a2          = new String[][]{{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};

        List<List<String>> list1 = new ArrayList<>();
        for (String[] item : a1) {
            List<String> a3 = new ArrayList<>();
            for (String p : item) {
                a3.add(p);
            }
            list1.add(a3);
        }


        List<List<String>> list2 = new ArrayList<>();
        for (String[] item : a2) {
            List<String> a3 = new ArrayList<>();
            for (String p : item) {
                a3.add(p);
            }
            list2.add(a3);
        }


        System.out.println(Arrays.toString(solution399.calcEquation(list1, vals, list2)));

    }

}
