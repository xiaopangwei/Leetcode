package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 8:18 PM
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0) {
                    cnt++;
                }
            }

            if (cnt % 3 != 0) {
                ret += mask;
            }
//            System.out.println(cnt+":"+mask+" "+ret);
        }
        return ret;
    }

    public static void main(String[] args){
        Solution137 solution137=new Solution137();
        //3N或者3N+1
        //1100
        //1100
        //1100
        //1001

        //1001
        //1001
        //1001
        //1100
        //4 1 0 3
        int ans=solution137.singleNumber(new int[]{9,9,12,9});
        System.out.println(ans);

    }
}
