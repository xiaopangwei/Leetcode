package leetcode.p2022m02;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/7
 * @time 10:01 PM
 */
public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end   = intervals[i][1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        int curr = 0;
        int max  = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            curr += entry.getValue();
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args){
        Solution253 solution253=new Solution253();
        //[[0,30],[5,10],[15,20]]
        int ans=solution253.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}});
        System.out.println(ans);
    }
}
