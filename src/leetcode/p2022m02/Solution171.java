package leetcode.p2022m02;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 8:30 AM
 */
public class Solution171 {
    //AB=>26^0*2+26^1
    public int titleToNumber(String s) {
        int base = 1;
        int ans  = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += base * (s.charAt(i) - 'A' + 1);
            base*=26;
        }
        return ans;
    }

    public static void main(String[] args){
        Solution171 solution171=new Solution171();
        int ans=solution171.titleToNumber("ZY");
        System.out.println(ans);
    }
}
