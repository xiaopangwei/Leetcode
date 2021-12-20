package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/19
 * @time 9:00 PM
 */
public class Solution309 {


    private Map<BiKey,Integer> cached=new HashMap<>();
    public int maxProfit(int[] prices) {

        int maxVal = getMax(prices, 0, false);

        return maxVal;
    }

    static class BiKey {
        boolean key1;
        int     key2;

        public BiKey(boolean key1, int key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BiKey key = (BiKey) o;

            if (key1 != key.key1) return false;
            return key2 == key.key2;
        }

        @Override
        public int hashCode() {
            int result = (key1 ? 1 : 0);
            result = 31 * result + key2;
            return result;
        }
    }

    //-1 买
    //0 不做
    //1 卖
    private int getMax(int[] prices, int index, boolean holdOrNot) {

        BiKey key=new BiKey(holdOrNot,index);
        if (cached.containsKey(key)){
            return cached.get(key);
        }
        if (index >= prices.length) {
            return 0;
        }

        int tMax = 0;

        int t1 = getMax(prices, index + 1, holdOrNot);
        tMax = Math.max(tMax, t1);
        if (holdOrNot) {
            int t2 = prices[index] + getMax(prices, index + 2, !holdOrNot);
            tMax = Math.max(tMax, t2);
        } else {

            int t2 = -prices[index] + getMax(prices, index + 1, !holdOrNot);
            tMax = Math.max(tMax, t2);

        }
        cached.put(key,tMax);
        return tMax;
    }

    public static void main(String[] args) {
        Solution309 solution309 = new Solution309();
        int         max         = solution309.maxProfit(new int[]{1, 2, 3, 0, 2});
        System.out.println(max);
    }
}
