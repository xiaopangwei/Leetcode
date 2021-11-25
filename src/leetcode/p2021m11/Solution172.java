package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 9:16 PM
 */
public class Solution172 {
    public int trailingZeroes(int n) {

        int count=0;
        while (n>0){
            count+=n/5;
            n/=5;
        }

        return count;
    }
}
