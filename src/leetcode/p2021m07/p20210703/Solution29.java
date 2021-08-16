package leetcode.p2021m07.p20210703;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/5
 * @time 3:00 PM
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {


        boolean dividendSign=dividend>0;
        boolean dividorSign=divisor>0;

        int a=0;
        if (dividend<0 && Math.abs(dividend)<0) {
            a = Integer.MAX_VALUE;
        }else{
            a=Math.abs(dividend);
        }
        int b=Math.abs(divisor);

        int base=0;
        int count=0;

        if (a==0) {return 0;}
        else if (a<b)  {return 0;}
        boolean flag=false;
        while (base<=a){
            base+=b;
            if (a-base<b){
                flag=true;
                break;
            }
            count++;
        }
        if (flag){
            count++;
        }
        else if (!flag && base>dividend){
            count--;
        }

        int ans=count;
        if (dividendSign!=dividorSign){
            ans=-ans;
        }
        return ans;
    }


    public static void main(String[] args){
        Solution29 solution29=new Solution29();
        int ans=solution29.divide(3,3);
        System.out.println(ans);

//        System.out.println(Math.abs(Integer.MAX_VALUE));
//        System.out.println(Math.abs(Integer.MIN_VALUE));
    }
}
