package leetcode.p20210626;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/25
 * @time 1:43 PM
 */
public class Solution752 {


    public int openLock(String[] deadends, String target) {

        List<String> deadEndList=new ArrayList<>();
        for (String item:deadends){
            deadEndList.add(item);
        }
        Queue<String> queue1=new LinkedList<>();
        Queue<String> queue2=new LinkedList<>();

        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();

        if (!deadEndList.contains("0000") && !deadEndList.contains(target))
        {
            queue1.add("0000");
            queue2.add(target);

            map1.put("0000",0);
            map2.put(target,0);
        }



        while (!queue1.isEmpty() && !queue2.isEmpty()){

            if (queue1.size()<=queue2.size()){
                String temp=queue1.poll();
                if (map2.containsKey(temp)){
                    return map2.get(temp)+map1.get(temp);
                }
                Set<String> candidates=getTempString(temp,deadEndList);
                for (String item:candidates){
                    if (!map1.containsKey(item)){
                        map1.put(item,map1.get(temp)+1);
                        queue1.add(item);
                    }
                }

            }else{
                String temp=queue2.poll();
                if (map1.containsKey(temp)){
                    return map1.get(temp)+map2.get(temp);
                }
                Set<String> candidates=getTempString(temp,deadEndList);
                for (String item:candidates){
                    if (!map2.containsKey(item)){
                        map2.put(item,map2.get(temp)+1);
                        queue2.add(item);
                    }
                }
            }
        }

        return -1;
    }



    public Set<String> getTempString(String src,final List<String> deadendsList){
        Set<String> ret=new HashSet<>();
        char[] array=src.toCharArray();
        for (int i=0;i<array.length;i++){
            char ch=array[i];
            String before=src.substring(0,i);
            String after=src.substring(i+1);
            String next=before+ getNextChar(ch) + after;
            String prev=before+ getPrevChar(ch) + after;

            if (!deadendsList.contains(next))
            {
                ret.add(next);
            }

            if (!deadendsList.contains(prev))
            {
                ret.add(prev);
            }
        }
//        System.out.println(src+" deadendsList "+ret);
        return ret;
    }

    private String getNextChar(char ch){
        if (ch>='1' && ch<='8')
        {
            return String.valueOf((char)(ch+1));
        }
        else if(ch=='0')
        {
            return "1";
        }else{
            return "0";
        }
    }


    private String getPrevChar(char ch){
        if (ch>='1' && ch<='8')
        {
            return String.valueOf((char)(ch-1));
        }
        else if(ch=='0')
        {
            return "9";
        }else{
            return "8";
        }
    }


    public static void main(String[] args){
        Solution752 solution752=new Solution752();
//        //9203
        System.out.println(solution752.openLock(
                new String[]{"0201","0101","0102","1212","2002"},"0202"));

        System.out.println(solution752.openLock(
                new String[]{"8888"},"0009"));

        System.out.println(solution752.openLock(
                new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));

        System.out.println(solution752.openLock(
                new String[]{"0000"},"8888"));
    }

}
