package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 10:26 AM
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int ans=0;
        int i=1;

        while (i<prices.length){
            ans=Math.max(ans,prices[i]-minPrice);
            if (prices[i]<minPrice){
                minPrice=prices[i];
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args){
        Solution121 solution121=new Solution121();
        int ans=solution121.maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(ans);
    }
}
