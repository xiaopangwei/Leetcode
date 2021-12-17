package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/1
 * @time 7:00 PM
 */
public class Solution1446 {
    public int maxPower(String s) {

        int i=0;
        int len=s.length();
        int maxLen=0;
        while (i<len){
            char ch=s.charAt(i);
            int j=i+1;
            while (j<len && s.charAt(j)==ch){j++;}
            maxLen=Math.max(maxLen,j-i);
            i=j;
        }
        return maxLen;
    }
    public static void main(String[] args){
        Solution1446 solution1446=new Solution1446();
        int max=solution1446.maxPower("tourist");
        System.out.println(max);
    }
}
