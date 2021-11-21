package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/10
 * @time 8:26 PM
 */
public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int last=-1;

        int ans=0;
        for (int start:timeSeries){
            int end=start+duration-1;
            if (start>last){
                ans+=duration;
                last=end;
            }else{
                ans+=(end-last);
                last=Math.max(last,end);
            }
        }

        return ans;
    }
    public static void main(String[] args){
        Solution495 solution495=new Solution495();
        int ans=solution495.findPoisonedDuration(new int[]{1,2,3,4,5},5);
        System.out.println(ans);
    }

}
