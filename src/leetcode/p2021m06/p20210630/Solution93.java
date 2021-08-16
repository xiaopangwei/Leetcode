package leetcode.p2021m06.p20210630;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 10:17 AM
 */
public class Solution93 {
    private List<String> ans=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        char[] charArray=s.toCharArray();
        for (char ch:charArray){
            if (!(ch>='0' && ch<='9')){
                return ans;
            }
        }
        dfs(s,new ArrayList<>());
        return ans;
    }

    private void dfs(String source,List<String> res){
        if (res.size()==4 && source.length()==0){
            ans.add(String.join(".",res));
        }
        if (res.size()>4||source.length()<=0){
            return;
        }
        char firstChar=source.charAt(0);
            if (firstChar=='0') {
                res.add("0");
                dfs(source.substring(1), res);
                res.remove(res.size() - 1);
                return;
            }else{
                res.add(String.valueOf(firstChar));
                dfs(source.substring(1),res);
                res.remove(res.size()-1);
            }
            if (source.length()>=2){
                res.add(String.valueOf(new char[]{firstChar,source.charAt(1)}));
                dfs(source.substring(2),res);
                res.remove(res.size()-1);
            }
            if (source.length()>=3 && (firstChar=='1'||firstChar=='2')){
                int thiNumber=Integer.valueOf(String.valueOf(new char[]{firstChar,source.charAt(1),source.charAt(2)}));
                if (thiNumber>=100 && thiNumber<=255){
                    res.add(String.valueOf(thiNumber));
                    dfs(source.substring(3),res);
                    res.remove(res.size()-1);
                }
            }
        }

    public static void main(String[] args){
        Solution93 solution93=new Solution93();
        List<String> temp=solution93.restoreIpAddresses("111");
        System.out.println(temp);
    }
    }

