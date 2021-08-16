package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 5:33 PM
 */
public class Solution5 {
    public String longestPalindrome(String s) {

        int len=s.length();
        int[][] dp=new int[len][len];

        for (int i=0;i<len;i++){
            dp[i][i]=1;
        }
        int maxPalindromeLength=1;
        boolean flag=false;
        int beginPos=0;

        for (int i=0;i<len-1;i++){
            if (s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=2;
                flag=true;
                beginPos=i;

            }else{
                dp[i][i+1]=0;
            }
        }

        if (flag){
            maxPalindromeLength=2;
        }
        for (int k=3;k<=len;k++)
        {
            for (int begin=0;begin<len;begin++){

                 int end=begin+k-1;
//                 System.out.println(begin+" "+end);
                 if (end>=len){
                     continue;
                 }
                 if (s.charAt(begin)==s.charAt(end) && dp[begin+1][end-1]!=0) {
                     int maxLen = dp[begin + 1][end - 1] + 2;
                     if (maxLen > dp[begin][end]) {
                         dp[begin][end] = maxLen;
//                         System.out.println(s.substring(begin,end+1) +" Length:"+maxLen);
                     }
                     if (maxLen > maxPalindromeLength) {
                         maxPalindromeLength = maxLen;
                         beginPos = begin;
//                         System.out.println("maxLen:" + maxLen + " beginPos:" + beginPos);
                     }
                 }else{
                     dp[begin][end] = 0;
//                     System.out.println(s.substring(begin,end+1) +" Length:"+0);
                 }
            }
        }

//        System.out.println(maxPalindromeLength);
        return s.substring(beginPos,beginPos+maxPalindromeLength);
    }

    public static void main(String[] args){
        Solution5 solution5=new Solution5();
        String ans=solution5.longestPalindrome("ac");
        System.out.println(ans);
    }
}
