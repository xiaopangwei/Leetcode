package demo.test20210120;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/3
 * @time 11:35 AM
 */
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int day = 0, id = 0, n = events.length, res = 0;
        while(id < n || !queue.isEmpty()){
            if(queue.isEmpty()){
                queue.add(events[id][1]);
                day = events[id++][0];
            }
            //queue结束时间
            //day开始时间
            while(id < n && events[id][0] <= day){
                queue.add(events[id++][1]);
            }
            if(queue.peek() >= day){
                day++;
                res++;
            }
            queue.poll();
        }
        return res;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.maxEvents(new int[][]{{1,2},{2,3},{3,4},{1,2}}));
    }
}

