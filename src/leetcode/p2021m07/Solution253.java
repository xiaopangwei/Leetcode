package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 11:15 AM
 */
public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        for (int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if (!queue.isEmpty()){
                int[] temp=queue.peek();
                if (start>=temp[1]){
                    queue.poll();
                    queue.add(new int[]{start,end});
                }else{
                    queue.add(new int[]{start,end});
                }
            }else{
                queue.add(new int[]{start,end});
            }

        }

        return queue.size();
    }

    public static void main(String[] args){
        Solution253 solution253=new Solution253();
        int[][] array=new int[][]{{7,10},{2,4}};
        int ans=solution253.minMeetingRooms(array);
        System.out.println(ans);
    }
}
