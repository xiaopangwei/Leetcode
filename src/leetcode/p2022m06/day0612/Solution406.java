package leetcode.p2022m06.day0612;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/16
 * @time 10:58 PM
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            list.add(index, people[i]);
        }

        return list.toArray(new int[people.length][2]);
    }
}
