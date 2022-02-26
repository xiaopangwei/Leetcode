package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 8:04 PM
 */
public class SolutionJZOffer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            int t = n & 1;
            ans += t;
            n >>>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = -6;
        System.out.println(n >> 1);
        System.out.println(n >>> 1);
//        SolutionJZOffer15 solutionJZOffer15=new SolutionJZOffer15();
//        int ans=solutionJZOffer15.hammingWeight(-3);
//        System.out.println(ans);
    }
}
