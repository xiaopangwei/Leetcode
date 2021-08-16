package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 10:53 AM
 */
public class Solution7 {
    public int reverse(int x) {

        if (x==0){
            return 0;
        }
        int m=x;
        boolean flag=true;
        if (x<0){
            flag=false;
            m=-x;
        }
        int sum=0;
        while (m!=0){
            if (sum < Integer.MIN_VALUE / 10 || sum > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int a=m%10;
            int b=m/10;

            sum=sum*10+a;
            System.out.println(sum);
            m=b;
        }
        if (flag){
            return sum;
        }
        return -sum;
    }

    public static void main(String[] args){
        Solution7 solution7=new Solution7();
        int ans=solution7.reverse(
                1534236469);
        System.out.println(ans);
    }

}
