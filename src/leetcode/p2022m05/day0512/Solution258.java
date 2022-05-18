package leetcode.p2022m05.day0512;

import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:13 PM
 */
public class Solution258 {
    public int addDigits(int num) {
        if (num<10){
            return num;
        }

        int s=0;
        while (num!=0){
            s+=num%10;
            num/=10;
        }
        return addDigits(s);
    }

    public static void main(String[] args){
        Solution258 solution258=new Solution258();
        int ans=solution258.addDigits(0);
        System.out.println(ans);
    }
}
