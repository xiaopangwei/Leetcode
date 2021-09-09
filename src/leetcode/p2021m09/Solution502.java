package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/8
 * @time 5:21 PM
 */
public class Solution502 {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int         length = Profits.length;
        List<int[]> list   = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new int[]{Profits[i], Capital[i]});
        }

        //成本排序从小到大排序
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //利润通过大根堆实现


        int i = 0;
        while (k-- > 0) {
            while (i < length && list.get(i)[1] <= W) {
                pq.add(list.get(i));
                i++;
            }
            if (pq.isEmpty()) {
                break;
            }
            W += pq.poll()[0];
        }


        return W;
    }

    public static void main(String[] args) {
        //{1,2,3}
        //{0,1,1}
        int[]       profits     = new int[]{1, 2, 3};
        int[]       capital     = new int[]{0, 1, 2};
        Solution502 solution502 = new Solution502();
        int         ans         = solution502.findMaximizedCapital(3, 0, profits, capital);
        System.out.println(ans);
    }
}
