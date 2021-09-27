package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/26
 * @time 10:05 AM
 */
public class Solution371 {
    public int getSum(int a, int b) {

        while (b!=0){
            int carry=(a&b)<<1;
            a=a^b;
            b=carry;
        }

        return a;
    }

    public static void main(String[] args){
        Solution371 solution371=new Solution371();
        int ans=solution371.getSum(3,-2);
        System.out.println(ans);
    }
}
