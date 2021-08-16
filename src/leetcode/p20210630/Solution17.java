package leetcode.p20210630;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 9:39 PM
 */
public class Solution17 {
    private List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        char[] charArray=digits.toCharArray();
        int len=digits.length();
        if (digits.isEmpty()){
            return ans;
        }
        dfs(new ArrayList<>(),0,len,charArray);

        return ans;
    }

    private void dfs(List<String> res,int index,final int maxLen,final char[] charArray){
        if (index==maxLen){
            ans.add(String.join("",res));
            return;
        }

        List<Character> characters=getCharList(charArray[index]-'0');
        for (Character eng:characters) {
                res.add(String.valueOf(eng));
                dfs(res, index + 1, maxLen, charArray);
                res.remove(res.size() - 1);
            }

    }

    private List<Character> getCharList(int num){
        if (num==7){
            return Arrays.asList('p','q','r','s');
        }
        if (num==8){
            return Arrays.asList('t','u','v');
        }
        if (num==9){
            return Arrays.asList('w','x','y','z');
        }
        int temp=(num-2)*3;
        return Arrays.asList((char)(temp+'a'),(char)(temp+1+'a'),(char)(temp+2+'a'));
    }

    public static void main(String[] args){
        Solution17 solution17=new Solution17();
        System.out.println(solution17.letterCombinations("7"));
    }
}
