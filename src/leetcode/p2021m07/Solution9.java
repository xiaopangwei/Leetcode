package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 2:31 PM
 */
public class Solution9 {
    public boolean isPalindrome(int x) {

        if (x<0){
            return false;
        }else if (x==0){
            return true;
        }

        int base=1;
        int m=x;
        while (m/10!=0){
            base*=10;
            m/=10;

        }

        m=x;
        //121
        while (m!=0){
            int last=m%10;
            int first=(x/base)%10;
            if (last!=first){
                return false;
            }
            m=m/10;
            base/=10;
        }
        return true;
    }

    public static void main(String[] args){
        Solution9 solution9=new Solution9();
        boolean ans=solution9.isPalindrome(12);
        System.out.println(ans);
    }
}
