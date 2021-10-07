package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/6
 * @time 10:37 PM
 */
public class Solution269 {
    public String alienOrder(String[] words) {


        if (words.length==0){
            return "";
        }
        if (words.length==1){
           StringBuilder builder=new StringBuilder();
           Set<Character> sets=new HashSet<>();
           int len=words[0].length();
           for (int i=0;i<len;i++){
               if (sets.contains(words[0].charAt(i))){
                   continue;
               }
               sets.add(words[0].charAt(i));
               builder.append(words[0].charAt(i));
           }

           return builder.toString();
        }
        Map<Character, Set<Character>> prevDegreeMap = new HashMap<>();
        Map<Character, Set<Character>> nextDegreeMap = new HashMap<>();
        Set<Character>                 alpha         = new HashSet<>();
        int                            len           = words.length;
        for (int i = 0; i < len; i++) {


            int j = i + 1;
            if (j >= len) {
                continue;
            }
            int k      = 0;
            int minLen = Math.min(words[i].length(), words[j].length());
            while (k < minLen && words[i].charAt(k) == words[j].charAt(k)) {
                k++;
            }
            char[] arr1 = words[i].toCharArray();
            char[] arr2 = words[j].toCharArray();
            for (char ch : arr1) {
                alpha.add(ch);
            }
            for (char ch : arr2) {
                alpha.add(ch);
            }
            if (k < minLen) {
                char prevChar = arr1[k];
                char nextChar = arr2[k];

                if (!prevDegreeMap.containsKey(nextChar)) {
                    prevDegreeMap.put(nextChar, new HashSet<>());
                }
                prevDegreeMap.get(nextChar).add(prevChar);


                if (!nextDegreeMap.containsKey(prevChar)) {
                    nextDegreeMap.put(prevChar, new HashSet<>());
                }
                nextDegreeMap.get(prevChar).add(nextChar);

            }else{
                if (arr1.length>arr2.length){
                    return "";
                }
            }
        }


        String ans = this.topologySort(prevDegreeMap, nextDegreeMap, alpha);
        if (ans != null) {
            return ans;
        }

        return "";
    }


    public String topologySort(Map<Character, Set<Character>> prevDegreeMap,
                               Map<Character, Set<Character>> nextDegreeMap, Set<Character> alpha) {


        List<Character> lists = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        int           size    = alpha.size();
        for (int i = 0; i < size; i++) {
            boolean flag = false;
            for (char ch : alpha) {
                if (lists.contains(ch)) {
                    continue;
                }
                Set<Character> sets = prevDegreeMap.get(ch);
                if (sets == null || sets.isEmpty()) {
                    lists.add(ch);
                    builder.append(ch);
                    flag = true;
                    Set<Character> temp = nextDegreeMap.get(ch);
                    if (temp != null && !temp.isEmpty()) {
                        for (char a : temp) {
                            if (prevDegreeMap.get(a) != null) {
                                prevDegreeMap.get(a).remove(ch);
                            }
                        }
                    }
                    prevDegreeMap.remove(ch);
                    break;
                }
            }

            if (!flag) {
                return null;
            }
        }


        return builder.toString();
    }


    public static void main(String[] args) {
        Solution269 solution269 = new Solution269();
//        String      ans         = solution269.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        String ans = solution269.alienOrder(new String[]{"abc"});
        System.out.println(ans);
    }
}
