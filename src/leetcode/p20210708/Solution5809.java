package leetcode.p20210708;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/11
 * @time 9:49 PM
 */
public class Solution5809 {
    public int countPalindromicSubsequence(String s) {

        char[] charArray=s.toCharArray();

        int length=charArray.length;


        int[][] dp=new int[length][length];
        for (int i=0;i<length-2;i++){
            if (charArray[i]==charArray[i+2]){
                dp[i][i+2]=1;
            }else{
                dp[i][i+2]=0;
            }
        }


        for (int i=4;i<=length;i++){
            for (int j=0;j<length;j++){

                int minIndex=j;
                int maxIndex=j+i-1;
                if (maxIndex>=length){
                    continue;
                }
                int left=dp[minIndex][maxIndex-1];
                char current=charArray[maxIndex];

                Set<Character> characterSet =new HashSet<>();

                int indexOfCurrent=s.indexOf(current,minIndex);
                if (indexOfCurrent!=-1 && indexOfCurrent!=maxIndex) {
                    for (int k = indexOfCurrent+1; k < maxIndex; k++) {
                        if (charArray[k]!=current ) {
                                characterSet.add(charArray[k]);
                        }
                    }
                }


                dp[minIndex][maxIndex]=left+characterSet.size();
                System.out.println(s.substring(minIndex,maxIndex+1)+" () "+minIndex+","+maxIndex+" ==> "+left+" "+characterSet+" result:"+dp[minIndex][maxIndex]);
            }
        }

        return dp[0][length-1];
    }

    public static void main(String[] args){
        Solution5809 solution5809=new Solution5809();
        System.out.println(solution5809.countPalindromicSubsequence("aabca"));
        System.out.println(solution5809.countPalindromicSubsequence("adc"));
        System.out.println(solution5809.countPalindromicSubsequence("bbcbaba"));
    }
}
