package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/17
 * @time 10:04 PM
 */
public class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {

        int bottleCnt=numBottles;
        int topCnt=0;

        int ans=0;
        while (true){
            if (bottleCnt==0 && topCnt<numExchange){
                break;
            }

            ans+=bottleCnt;
            topCnt+=bottleCnt;
            bottleCnt=0;

            int a=topCnt/numExchange;
            int b=topCnt%numExchange;

            bottleCnt+=a;
            topCnt=b;

//            System.out.println(bottleCnt+" "+topCnt);

        }

        return ans;

    }

    public static void main(String[] args){
        Solution1518 solution1518=new Solution1518();
        int ans=solution1518.numWaterBottles(9,3);
        System.out.println(ans);

    }
}
