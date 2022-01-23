package leetcode.p2022m01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/19
 * @time 9:19 PM
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        LinkedList<int[]> list = new LinkedList<>();

        list.addLast(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int lastIndex = list.size() - 1;
            int s         = list.get(lastIndex)[0];
            int e         = list.get(lastIndex)[1];
            if (intervals[i][0] > e) {
                list.add(intervals[i]);
            } else {
                list.set(lastIndex, new int[]{s, Math.max(e, intervals[i][1])});
            }
        }


        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][]    ans        = solution56.merge(new int[][]{{1, 4}, {4, 5}, {0, 1}});
        for (int[] item : ans) {
            System.out.println(Arrays.toString(item));
        }
    }
}
