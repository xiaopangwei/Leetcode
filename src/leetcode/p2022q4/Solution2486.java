package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/28
 * @time 9:01 PM
 */
public class Solution2486 {
    public int appendCharacters(String s, String t) {

        int i=0;
        int j=0;
        while (i<s.length() && j<t.length()){
            if (s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return t.length()-j;
    }
    public static void main(String[] args){
        Solution2486 solution2486=new Solution2486();
        System.out.println(solution2486.appendCharacters("z","abcde"));
    }
}
