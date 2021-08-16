package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/26
 * @time 3:26 PM
 */
public class Solution132 {
    public int minCut(String s) {

        if (isValid(s,0,s.length()-1)){
            return 0;
        }
        int len=s.length();
        int[] dp=new int[s.length()];

        for (int i=0;i<len;i++){
            dp[i]=len;
        }

        dp[0]=0;
        for (int i=1;i<s.length();i++){
            //[0,i-1]
            if (isValid(s,0,i)){
                dp[i]=0;
            }else {
                for (int j = 0; j < i; j++) {
                    //[j+1,i]
                    if (j+1<len && j+1<=i) {
                        if (isValid(s, j + 1, i)) {
                            dp[i] = Math.min(dp[i], dp[j] + 1);
                            System.out.println("i:"+i+" dp[i]:"+dp[i]+" substring:"+s.substring(j+1,i+1));
                        }
                    }
                }

            }
        }

        return dp[len-1];

    }

    private boolean isValid(String src,int start,int end){

        if (end-start<0){
            return false;
        }
        if (end-start==0){
            return true;
        }
        int i=start;
        int j=end;

        while (i<=j) {
            if (src.charAt(i) != src.charAt(j)) {

                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        Solution132 solution132=new Solution132();
        String src="abagba";
//        System.out.println(solution132.isValid(src,0,src.length()-1));
        System.out.println(solution132.minCut(src));
    }
}
