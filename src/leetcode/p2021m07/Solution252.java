package leetcode.p2021m07;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 11:04 AM
 */
public class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int end=intervals[0][1];
        for (int i=1;i<intervals.length;i++){
            if (intervals[i][0]<=end){
                return false;
            }
            end=intervals[i][1];
        }

        return true;
    }

    public static void main(String[] args){
        Solution252 solution252=new Solution252();
        boolean ans=solution252.canAttendMeetings(new int[][]{{7,10},{2,4}});
        System.out.println(ans);
    }
}
