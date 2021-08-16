package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 10:45 PM
 */
public class Solution50 {
    public double myPow(double x, int n) {
        long N=n;

        if (N==0){
            return 1;
        }
        if (Math.abs(x-1.0)<=0.0001){
            return 1;
        }


        boolean flag=N>0?true:false;
        long newN=flag?N:-N;
        double ans=power(x,newN);
        if (flag){
            return ans;
        }else{
            return 1.0/ans;
        }
    }

    private double power(final double x,long n){
        if (n==1){
            return x;
        }
        double half=power(x,n/2);
        if (n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }


    public static void main(String[] args){
        Solution50 solution50=new Solution50();
        double ans=solution50.myPow(2.0,-2147483647);
        System.out.println(ans);
    }
}
