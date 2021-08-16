package leetcode.p20210614;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/18
 * @time 1:34 PM
 */
public class Solution171 {

    public int titleToNumber(String s) {

        char[] array=s.toCharArray();
        int ans=0;
        int base=1;
        for (int i=array.length-1;i>=0;i--){
            char digit=array[i];
            ans+=(digit-'A'+1)*base;
            base*=26;
        }
        return ans;
    }

    public static void main(String[] args){
        Solution171 solution171=new Solution171();
        System.out.println(solution171.titleToNumber("ZY"));
        System.out.println(solution171.titleToNumber("A"));
    }
}
