package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/10
 * @time 8:56 PM
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] != o1[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int              len  = people.length;
        ArrayList<int[]> list = new ArrayList<>(len);
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }


        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }


        return res;
    }

    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        int[][]     res         = solution406.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});

        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }


    }
}
