package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 6:04 PM
 */
public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        if (n==0){
            return 0;
        }
        int count=0;
        while (n!=0){
            n=n &(n-1);
            count++;
        }
        return  count;
    }
}
