package leetcode.p2021m02.p20210216;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,Map<Character,Integer>> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        List<String> resultKeyList=new ArrayList<>();
        for (String s:strs){
            char[] charArray=s.toCharArray();
            Map<Character,Integer> inner=new HashMap<>();
            map.put(s,inner);
            for (char c:charArray){
                if (!inner.containsKey(c)){
                    inner.put(c,1);
                }
                else{
                    inner.put(c,inner.get(c)+1);
                }
            }

            String key=getGroupKey(inner);

            int index=resultKeyList.indexOf(key);
            if (index<0){
                resultKeyList.add(key);
                List<String> newTypeList=new ArrayList<>();
                newTypeList.add(s);
                result.add(newTypeList);
            }
            else{
                List<String> listTemp=result.get(index);
                listTemp.add(s);
            }

        }



        return result;

    }


    public String getGroupKey(Map<Character,Integer> map){
        StringBuilder stringBuilder=new StringBuilder();
        for(char c='a';c<='z';c++){
            if (map.containsKey(c)) {
                stringBuilder.append(c);
                stringBuilder.append("#");
                stringBuilder.append(map.get(c));
                stringBuilder.append("#");
            }

        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) throws Exception{
        String[] array=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        Solution49 solution329 =new Solution49();
        System.out.println(solution329.groupAnagrams(array));





    }
}
