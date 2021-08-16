package leetcode.p2021m06.p20210629;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 4:37 PM
 */
public class Solution433 {
    public static void main(String[] args){
        Solution433 solution433=new Solution433();
//        System.out.println(solution433.minMutation("AACCGGTT","AAACGGTA",
//                new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
//
//        System.out.println(solution433.minMutation("AAAAACCC","AACCCCCC",
//                new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));


        System.out.println(solution433.minMutation("AACCGGTT","AACCGGTA",
                new String[]{"AACCGGTA"}));

    }
    public int minMutation(String start, String end, String[] bank) {
        Queue<String>       queue1 =new LinkedList<>();
        Queue<String>       queue2 =new LinkedList<>();
        Map<String,Integer> map1   =new HashMap<>();
        Map<String,Integer> map2   =new HashMap<>();
        queue1.add(start);
        queue2.add(end);
        map1.put(start,0);
        map2.put(end,0);

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            if (queue1.size()<=queue2.size()){
                String temp=queue1.poll();
                if (map2.containsKey(temp))
                {return map1.get(temp)+map2.get(temp);}
                for (String item:bank){
                    if(isValidChange(temp,item)){
                        if (!map1.containsKey(item)) {
                                queue1.add(item);
//                                System.out.println("A "+item);
                                map1.put(item,map1.get(temp)+1);

                        }
                    }
                }
            }else{
                String temp=queue2.poll();
                if (map1.containsKey(temp)) {
                    return map2.get(temp) + map1.get(temp);
                }
                for (String item:bank){
                    if(isValidChange(temp,item)){

                        if (!map2.containsKey(item)) {
                                queue2.add(item);
//                                 System.out.println("B "+item);
                                map2.put(item,map2.get(temp)+1);
                        }

                    }
                }
            }
        }
        return  -1;

    }

    private boolean isValidChange(String s1,String s2){
        char[] charArray1=s1.toCharArray();
        char[] charArray2=s2.toCharArray();
        int count=0;
        for (int i=0;i<8;i++){
                if (charArray1[i]!=charArray2[i]){
                    count++;
                    if (count>=2){
                        return false;
                    }
                }

        }
        return count==1;
    }
}
