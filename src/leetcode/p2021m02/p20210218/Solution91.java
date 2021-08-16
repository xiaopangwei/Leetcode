package leetcode.p2021m02.p20210218;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:17 AM
 */
public class Solution91 {


    private Map<String,Integer> cached=new HashMap<>();
    public int numDecodings(String s) {
        return innerNumDecodings(s);
    }

    public int innerNumDecodings(String s) {
        if (cached.containsKey(s)){
            return cached.get(s);
        }
        if (s.length()==0){
            return 1;
        }
       if (s.length()==1){
           if (s.charAt(0)=='0'){
               return 0;
           }
           return 1;
       }

       //len>=2
       //第一个字符
       char first=s.charAt(0);

       if (first=='0'){
           return 0;
       }
       int ans=0;
       String right=s.substring(1);
       ans+=innerNumDecodings(right);

       char second=s.charAt(1);
       if (isValid(new char[]{first,second})){
           ans+=innerNumDecodings(s.substring(2));
       }

       if (!cached.containsKey(s)){
           cached.put(s,ans);
       }
       return ans;

    }


    private boolean isValid(char[] array){

        if (array[0]=='0'){
            return false;
        }
        int temp=Integer.parseInt(String.valueOf(array));
        if (temp >=10 && temp<=26){
            return true;
        }
        return false;
    }

    public int numDecodingsStand(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < n; i++){

            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <'7'){
                //如果是20、10
                if(s.charAt(i) == '0') dp[i + 1] = dp[i - 1];
                    //如果是11-19、21-26
                else dp[i + 1] = dp[i] + dp[i - 1];
            }else if(s.charAt(i) == '0'){
                //如果是0、30、40、50
                return 0;
            }else{
                //i-1和i无法构成一个字母
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }



    public static void main(String[] args){
        Solution91 solution38 =new Solution91();
//        System.out.println(solution38.numDecodings("2"));
//        System.out.println(solution38.numDecodings("02"));
//        System.out.println(solution38.numDecodings("12"));
        System.out.println(solution38.numDecodings("126231"));
        System.out.println(solution38.numDecodingsStand("126231"));

//        System.out.println(solution38.numDecodingsStand("22623"));

    }


}
