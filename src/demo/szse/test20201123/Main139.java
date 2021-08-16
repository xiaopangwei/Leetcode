package demo.szse.test20201123;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/11/23
 * @time 11:30 AM
 */
public class Main139 {
    public static void main(String[] args){
        List<String> wordDict= Arrays.asList("apple", "pen");
        String s="applepenapple";
        Main139 main139=new Main139();
        System.out.println(main139.wordBreak(s,wordDict));

    }


    public boolean wordBreak(String s, List<String> wordDict) {

      boolean[] dp=new boolean[s.length()+1];
      dp[0]=true;

      for (int i=1;i<=s.length();i++){
          dp[i]=false;
      }
      for (int i=1;i<=s.length();i++){
          //计算dp[i]
          final int index=i;
          for (int j=0;j<index;j++){
              //dp[j]=dp[i] && check(j,i)

              String subStr=s.substring(j,i);
//              System.out.println("("+j+","+index+")"+" "+subStr);
              if (dp[j] && wordDict.contains(subStr)){
                  dp[index]=true;
                  break;
              }

          }

      }

      return dp[s.length()];


    }



}
