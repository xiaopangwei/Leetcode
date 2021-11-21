package leetcode.p2021m11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 3:56 PM
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {

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


        for (int i=0;i<intervals.length;i++){
            System.out.println(Arrays.toString(intervals[i]));
        }

        int maxEnd = intervals[0][1];

        int count=0;

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= maxEnd) {
                maxEnd = intervals[i][1];
//                System.out.println(i+" "+maxEnd+ Arrays.toString(intervals[i]));
            }else{
                count++;
                maxEnd=Math.min(maxEnd,intervals[i][1]);
//                System.out.println("add count: "+i+" "+maxEnd+" "+count +" "+Arrays.toString(intervals[i]));
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        int         ans         = solution435.eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}});
        System.out.println(ans);
    }
}
