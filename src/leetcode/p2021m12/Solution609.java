package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/9
 * @time 10:19 PM
 */
public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String,List<String>> map=new HashMap<>();
        for (String path:paths){
            String[] array=path.split(" ");
            String basePath=array[0];

            for (int i=1;i<array.length;i++){
                String t=array[i];
                int startIndex=t.indexOf("(");
                String content=t.substring(startIndex+1,t.length());
                if (!map.containsKey(content)){
                    map.put(content,new ArrayList<>());
                }
                map.get(content).add(basePath+"/"+t.substring(0,startIndex));
            }
        }

        List<List<String>> ans=new ArrayList<>();
        for (Map.Entry<String,List<String>> entry:map.entrySet()){
            if (entry.getValue().size()>1){
                ans.add(entry.getValue());
            }
        }

        return ans;
    }

    public static void  main(String[] args){
        Solution609 solution609=new Solution609();
        List<List<String>>  ans=solution609.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"});
        System.out.println(ans);


    }
}
