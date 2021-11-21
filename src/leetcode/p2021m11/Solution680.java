package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 3:00 PM
 */
public class Solution680 {
    public boolean validPalindrome(String s) {

        int left=0;
        int right=s.length()-1;
        while (left<=right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
               if (isPalindrome(s.substring(left+1,right+1)) ||
                   isPalindrome(s.substring(left,right))){
                   return true;
               }else{
                   return false;
               }
            }
        }
        return true;
    }

    private boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while (i<=j){
            if (s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution680 solution680=new Solution680();
        boolean ans=solution680.validPalindrome("abc");
        System.out.println(ans);
    }
}
