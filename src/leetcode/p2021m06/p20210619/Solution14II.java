package leetcode.p2021m06.p20210619;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/24
 * @time 4:26 PM
 */
public class Solution14II {
    public int cuttingRope(int n) {
      if (n==2) return 1;
      if (n==3) return 2;
      //if (n==4) return 4;

      long product=1;
      int len=n;
      while (len>4){
          product*=3;
          product%=1000000007;
          len-=3;
      }
      return (int)(product*len%1000000007);

//        if(n == 2)
//            return 1;
//        if(n == 3)
//            return 2;
//        long res = 1;
//        while(n > 4){
//            res *= 3;
//            res = res % 1000000007;
//            n -= 3;
//        }
//        return (int)(res * n % 1000000007);
    }



    public static void main(String[] args){
        Solution14II solution14 =new Solution14II();
//        System.out.println(solution14.cuttingRope(3));
//        System.out.println(solution14.cuttingRope(5));
//        System.out.println(solution14.cuttingRope(9));
//        System.out.println(solution14.cuttingRope(10));
//        System.out.println(solution14.cuttingRope(11));
        System.out.println(solution14.cuttingRope(127));
    }
}
