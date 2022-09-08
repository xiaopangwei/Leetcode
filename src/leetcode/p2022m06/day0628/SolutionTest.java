package leetcode.p2022m06.day0628;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/7
 * @time 9:38 PM
 */
public class SolutionTest {
    public String gcdOfStrings(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());

        String shortStr = null;
        String longStr  = null;
        if (str1.length() > str2.length()) {
            shortStr = str2;
            longStr = str1;
        } else {
            shortStr = str1;
            longStr = str2;
        }


        int i = minLen;
        while (i >= 0) {
            String sub = shortStr.substring(0, i);
            if (count(shortStr, sub) && count(longStr, sub)) {
                return sub;
            } else {
                i--;
            }
        }
        return "";
    }


    private boolean count(String original, String target) {
        if (original.length() == 0 || target.length() == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < original.length()) {
            if (original.charAt(i) != target.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
                if (j == target.length()) {
                    j = 0;
                }
            }
        }
        return j == 0;
    }


    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[]      flags = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) != '(') {
                        flags[i] = true;
                    } else {
                        stack.pop();
                    }
                } else {
                    flags[i] = true;
                }
            }
        }

        while (!stack.isEmpty()) {
            flags[stack.pop()] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                if (!flags[i]) {
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, Integer> map1   = new HashMap<>();
        Queue<String>        queue1 = new LinkedList<>();
        Map<String, Integer> map2   = new HashMap<>();
        Queue<String>        queue2 = new LinkedList<>();

        map1.put(beginWord, 0);
        queue1.add(beginWord);
        map2.put(endWord, 0);
        queue2.add(endWord);


        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() < queue2.size()) {
                String temp = queue1.poll();
                if (map2.containsKey(temp)) {
                    return map1.get(temp) + map2.get(temp)+1;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    String w = wordList.get(i);
                    if (isSimilar(w, temp) && !map1.containsKey(w)) {
                        queue1.add(w);
                        map1.put(w, map1.get(temp) + 1);
                    }
                }
            } else {
                String temp = queue2.poll();
                if (map1.containsKey(temp)) {
                    return map1.get(temp) + map2.get(temp)+1;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    String w = wordList.get(i);
                    if (isSimilar(w, temp) && !map2.containsKey(w)) {
                        queue2.add(w);
                        map2.put(w, map2.get(temp) + 1);
                    }
                }
            }
        }
        return 0;
    }

    public boolean isSimilar(String str1, String str2) {

        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SolutionTest solutionTest = new SolutionTest();

        boolean flag=solutionTest.isSimilar("aee","abd");
        System.out.println(flag);

        int ans = solutionTest.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ans);

    }
}
