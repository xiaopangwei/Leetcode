package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/31
 * @time 3:08 PM
 */
public class Solution1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {

        int[] ans=new int[n];
        for (int i=0;i<bookings.length;i++){
          int l=bookings[i][0]-1;
          int r=bookings[i][1];

          int val=bookings[i][2];
          ans[l]+=val;
          if (r<n) {
              ans[r] -= val;
          }
        }

        for (int i=1;i<ans.length;i++){
            ans[i]+=ans[i-1];
        }
        return ans;
    }

    public static void main(String[] args){
        Solution1109 solution1109=new Solution1109();
        int[] ans=solution1109.corpFlightBookings(new int[][]{{1,2,10},{2,2,15}},2);
        System.out.println(Arrays.toString(ans));

    }
}
