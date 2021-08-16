package leetcode.p20210223;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/23
 * @time 11:22 AM
 */
public class Solution131 {

    private List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {

        dfs(s,new ArrayList<>());
        return res;
    }

    public boolean isValid(String s){
        if (s.length()<1) {return false;}
        else if (s.length()==1) {return true;}

        for (int i=0;i< s.length() >>> 1;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    private void dfs(String s,List<String> list){
        if (s.length()==0)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int len=1;len<=s.length();len++) {
            String selectedStr = s.substring(0, len);
            if (isValid(selectedStr)){
                list.add(selectedStr);
//                System.out.println("Before "+list);
                dfs(s.substring(len),list);
                list.remove(list.size()-1);
//                System.out.println("After "+list);
            }
        }
    }
    public static void main(String[] args){
        Solution131 solution77 =new Solution131();


        List<List<String>> ans        =solution77.partition("aa");
        System.out.println(ans);

    }
}
