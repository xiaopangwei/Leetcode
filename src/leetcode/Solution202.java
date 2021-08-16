package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 10:13 PM
 */
public class Solution202 {
    public boolean isHappy(int n) {

        long       m=n;
        List<Long> state=new ArrayList<>();
        while (true){
            long newVal=squareSum(m);
            if (newVal==1){
                return true;
            }else{
                m=newVal;
//                System.out.println(m);
                if (!state.contains(m)) {
                    state.add(m);
                }else{
                    return false;
                }
            }
        }
    }

    public long squareSum(long n){
        int sum=0;
        while (n!=0){
            long temp=n%10;
            sum+=(temp*temp);
            n=n/10;
        }
        return sum;
    }

    public static void main(String[] args){
        Solution202 solution202=new Solution202();
        boolean ans=solution202.isHappy(2);
        System.out.println(ans);
    }
}
