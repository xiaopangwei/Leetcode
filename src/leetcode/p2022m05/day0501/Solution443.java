package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 3:46 PM
 */
public class Solution443 {
    public int compress(char[] chars) {
        StringBuilder builder = new StringBuilder();
        int           i       = 0;
        while (i < chars.length) {
            int j = i + 1;
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }
            int len = j - i;
            if (len <= 1) {
                builder.append(chars[i]);
            } else {
                builder.append(chars[i]);
                builder.append(String.valueOf(len));
            }
            i=j;
        }

        for (int t=0;t<builder.length();t++){
            chars[t]=builder.charAt(t);
        }
        return builder.length();
    }

    public static void main(String[] args){
        Solution443 solution443=new Solution443();
        int ans=solution443.compress("abbbbbbbbbbbb".toCharArray());
        System.out.println(ans);
    }
}
