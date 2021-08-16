package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/26
 * @time 10:18 AM
 */
public class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()][text2.length()];
        for (int i=0;i<text1.length();i++){
            char lastChar=text1.charAt(i);
            for (int j=0;j<text2.length();j++){

                if (lastChar==text2.charAt(j)){
                    dp[i][j]=get(dp,i-1,j-1,1);
                }else{
                    dp[i][j]=Math.max(get(dp,i,j-1,0),get(dp,i-1,j,0));
                }
            }
        }
        return dp[text1.length()-1][text2.length()-1];
    }

    private int get(int[][] dp,int i,int j,int delta){
        if (i<0 || j<0){
            return delta;
        }
        return dp[i][j]+delta;
    }

    public static void main(String[] args){
        Solution1143 solution1143=new Solution1143();
        System.out.println(solution1143.longestCommonSubsequence("habe","hbeg"));
    }
}
