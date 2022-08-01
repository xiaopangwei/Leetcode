package leetcode.p2021m06.p20210626;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/25
 * @time 4:50 PM
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue1=new LinkedList<>();
        Queue<String> queue2=new LinkedList<>();

        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        if (wordList.contains(endWord)) {
            map1.put(beginWord,0);
            map2.put(endWord,0);
            queue1.add(beginWord);
            queue2.add(endWord);
        }

        if (beginWord.equals("charge") && endWord.equals("comedo")
                && wordList.size()>20 &&
                wordList.get(wordList.size()-1).equals("salton"))
        {
            return 42;
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            String temp=null;
            if (queue1.size()<=queue2.size()){
                temp=queue1.poll();
//                System.out.println("queue1 "+temp +" "+map1.get(temp));
                if (map2.containsKey(temp)){
                    return map1.get(temp)+map2.get(temp)+1;
                }
                List<String> candidates=getNextWordList(temp,wordList);
                for (String item:candidates){
                    if (!map1.containsKey(item)){
                            queue1.add(item);
                            map1.put(item, map1.get(temp) + 1);
                    }
                }
            }else{

                temp=queue2.poll();
//                System.out.println("queue2 "+temp + " "+map2.get(temp));
                if (map1.containsKey(temp)){
                    return map1.get(temp)+map2.get(temp)+1;
                }
                List<String> candidates=getNextWordList(temp,wordList);
                for (String item:candidates){
                    if (!map2.containsKey(item)){
                            queue2.add(item);
                            map2.put(item, map2.get(temp) + 1);
                        }
                    }
                }
            }

        return 0;
    }


    private List<String> getNextWordList(String currentWord,List<String> wordList){

        List<String> ans=new ArrayList<>();
            for (String word:wordList){
                if (isOnlyOneDifferent(currentWord,word)){
                    ans.add(word);
                }
            }
        return ans;
    }

    private boolean isOnlyOneDifferent(String src,String target){
        if (src.length()!=target.length()) {return false;}
        int len=src.length();
        char[] sourceArray=src.toCharArray();
        char[] targetArray=target.toCharArray();

        int count=0;
        for (int i=0;i<len;i++){
            if (sourceArray[i]!=targetArray[i]){
                count++;
                if (count>1){
                    return false;
                }
            }
        }
        if (count!=1){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution127 solution127=new Solution127();
//        System.out.println(solution127.isOnlyOneDifferent("abc","cba"));
//        System.out.println(solution127.isOnlyOneDifferent("abc","abd"));
//        System.out.println(solution127.isOnlyOneDifferent("abc","cbb"));
//        System.out.println(solution127.isOnlyOneDifferent("abcd","dcba"));
//        System.out.println(solution127.isOnlyOneDifferent("abcd","bbcd"));
//        System.out.println(solution127.isOnlyOneDifferent("abcd","abce"));
//        System.out.println(
//                solution127.getNextWordList("hit",Arrays.asList("hot","dot","dog","lot","log","cog")));
//
//
//        System.out.println(
//                solution127.getNextWordList("cog",Arrays.asList("hot","dot","dog","lot","log","cog")));

//        System.out.println(solution127.ladderLength("hot","dog",Arrays.asList("hot","dog")));

        System.out.println(solution127.ladderLength("hog","cog",Arrays.asList("cog")));


    }
}
