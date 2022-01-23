package leetcode.p2022m01;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/20
 * @time 10:02 PM
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        List<String> deadList = new ArrayList<>();
        for (String item : deadends) {
            deadList.add(item);
        }

        Map<String, Integer> step1 = new HashMap<>();
        Map<String, Integer> step2 = new HashMap<>();

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        queue1.add("0000");
        queue2.add(target);

        step1.put("0000", 0);
        step2.put(target, 0);


        while (!queue1.isEmpty() && !queue2.isEmpty()) {

            if (queue1.size() < queue2.size()) {
                String       t1       = queue1.poll();
                List<String> nextList = getNext(t1);
                for (String next : nextList) {
                    if (step1.containsKey(next)||deadList.contains(next)) {
                        continue;
                    }
                    queue1.add(next);
                    step1.put(next, step1.get(t1) + 1);
                    if (step2.containsKey(next)) {
                        return step1.get(next) + step2.get(next);
                    }
                }
            } else {
                String       t2      = queue2.poll();
                List<String> nextList = getNext(t2);
                for (String next : nextList) {
                    if (step2.containsKey(next)||deadList.contains(next)) {
                        continue;
                    }
                    queue2.add(next);
                    step2.put(next, step2.get(t2) + 1);
                    if (step1.containsKey(next)) {
                        return step1.get(next) + step2.get(next);
                    }
                }
            }
        }
        return -1;
    }




    private List<String> getNext(String src) {
        char[]       array = src.toCharArray();
        List<String> ans   = new ArrayList<>();
        for (int i = 0; i < src.length(); i++) {

            char[] cloned1 = array.clone();
            char[] cloned2 = array.clone();

            if (array[i] == '0') {
                cloned1[i] = '9';
                cloned2[i] = '1';
            } else if (array[i] == '9') {
                cloned1[i] = '8';
                cloned2[i] = '0';
            } else {
                cloned1[i] = (char) (array[i] - 1);
                cloned2[i] = (char) (array[i] + 1);
            }

            ans.add(new String(cloned1));
            ans.add(new String(cloned2));
        }
        return ans;
    }

    public static void main(String[] args){
        Solution752 solution752=new Solution752();
        int ans=solution752.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888");
        System.out.println(ans);
    }
}
