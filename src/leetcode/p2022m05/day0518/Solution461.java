package leetcode.p2022m05.day0518;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/18
 * @time 8:15 PM
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        if (x==y){
            return 0;
        }
        int cnt = 0;
        while (x != 0 && y != 0) {
            int a = x & 1;
            int b = y & 1;

            if (a != b) {
                cnt++;
            }

            x >>= 1;
            y >>= 1;
        }

        while (x!=0){
            int a = x & 1;
            if (a==1) {
                cnt++;
            }
            x >>= 1;
        }

        while (y!=0){
            int a = y & 1;
            if (a==1) {
                cnt++;
            }
            y >>= 1;
        }
        return cnt;
    }

    public static void main(String[] args){
        Solution461 solution461=new Solution461();
        int ans=solution461.hammingDistance(3,3);
        System.out.println(ans);
    }
}
