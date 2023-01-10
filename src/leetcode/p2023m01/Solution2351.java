package leetcode.p2023m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/5
 * @time 8:11 PM
 */
public class Solution2351 {
    public char repeatedCharacter(String s) {
        boolean[] visited=new boolean[26];
        for (int i=0;i<s.length();i++){
            int index=s.charAt(i)-'a';
            if (visited[index]){
                return s.charAt(i);
            }else{
                visited[index]=true;
            }
        }
        return 'a';
    }
}
