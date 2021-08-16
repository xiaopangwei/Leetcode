package demo.test20210120;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution187 {

    private Set<String> cached=new HashSet<>();
    private List<String> ans=new ArrayList<>();
    public List<String> findRepeatedDnaSequences(String s) {
        for (int i=0;i<s.length();i++){
            if (i+9<s.length()){
                String sub=s.substring(i,i+10);
                if (!cached.contains(sub)){
                    cached.add(sub);
                }
                else{
                    if (!ans.contains(sub)) {
                        ans.add(sub);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Solution187 solution187=new Solution187();

        System.out.println(solution187.findRepeatedDnaSequences("AAAAAAAAAAA"));

    }
}
