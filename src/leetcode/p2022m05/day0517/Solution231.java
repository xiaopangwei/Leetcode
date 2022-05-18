package leetcode.p2022m05.day0517;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/17
 * @time 8:33 PM
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n<=0){
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args){
        Solution231 solution231=new Solution231();
        System.out.println(solution231.isPowerOfTwo(5));
    }
}
