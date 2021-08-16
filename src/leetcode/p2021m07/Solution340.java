package leetcode.p2021m07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 10:07 AM
 */
public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k==0){
            return 0;
        }
        int left=0;
        int right=0;
        int length=s.length();
        Map<Character,Integer> freq=new HashMap<>();
        int maxLength=-1;

        while (right<length){
            if (!freq.containsKey(s.charAt(right))){
                while (freq.keySet().size() >= k) {
//                    System.out.println("删除 " + s.charAt(left) + " " + left);
                    char charLeft=s.charAt(left);
                    int times=freq.get(charLeft);
                    if (times>1){
                        freq.put(charLeft,times-1);
                    }else{
                        freq.remove(charLeft);
                    }
                    left++;
                }
            }
            freq.put(s.charAt(right),freq.getOrDefault(s.charAt(right),0)+1);
//            System.out.println("添加 "+s.charAt(right)+" "+right);
            int width = right - left + 1;
            maxLength=Math.max(maxLength,width);
//            System.out.println("最大长度 "+maxLength+" left:"+left+" right:"+right+" "+s.substring(left,right+1));
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args){
        Solution340 solution340=new Solution340();
        int ans=solution340.lengthOfLongestSubstringKDistinct("abacbab",2);
        System.out.println(ans);
    }
}
