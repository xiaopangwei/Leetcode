package leetcode.p2023m01;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/5
 * @time 9:44 PM
 */
public class Solution1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {

        int mod=1000000007;
        PriorityQueue<int[]> buyPq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });


        PriorityQueue<int[]> sellPq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < orders.length; i++) {

            int amount = orders[i][1];
            int price  = orders[i][0];
            //卖
            if (orders[i][2] == 1) {
                while (!buyPq.isEmpty() && buyPq.peek()[0] >= price && amount > 0) {
                    int[] temp = buyPq.poll();
                    int matchCnt = Math.min(amount, temp[1]);
                    temp[1] -= matchCnt;
                    amount-=matchCnt;
                    if (temp[1]>0){
                        buyPq.add(new int[]{temp[0],temp[1]});
                    }
                }
                if (amount>0){
                    sellPq.add(new int[]{price,amount});
                }
            }else{
                while (!sellPq.isEmpty() && sellPq.peek()[0] <= price && amount > 0) {
                    int[] temp = sellPq.poll();
                    int matchCnt = Math.min(amount, temp[1]);
                    temp[1] -= matchCnt;
                    amount-=matchCnt;
                    if (temp[1]>0){
                        sellPq.add(new int[]{temp[0],temp[1]});
                    }
                }
                if (amount>0){
                    buyPq.add(new int[]{price,amount});
                }
            }
        }


        long unMatchCnt=0;
        for (int[] t:buyPq){
            unMatchCnt+=(long) t[1];
        }
        for (int[] t:sellPq){
            unMatchCnt+=(long) t[1];
        }
        return (int) (unMatchCnt%mod);
    }

    public static void main(String[] args){
//        [[7,1000000000,1],[15,3,0],[5,999999995,0],[5,1,1]]
        Solution1801 solution1801=new Solution1801();
        int ans=solution1801.getNumberOfBacklogOrders(new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}});
        System.out.println(ans);
    }
}
