package leetcode.p2021m11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/23
 * @time 9:23 PM
 */
public class Solution423 {
    public String originalDigits(String s) {

//        String[] eng = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//        //    w               v    x         g     n
//        //one two three four five six seven eight nine
//        String[] charArray = new String[]{"e", "g", "f", "i", "h", "o", "n", "s", "r", "u", "t", "w", "v", "x", "z"};
//
//        Map<Character, List<String>> map = new HashMap<>();
//
//        for (String ch : charArray) {
//            char c = ch.charAt(0);
//            for (String item : eng) {
//                if (item.contains(ch)) {
//                    if (!map.containsKey(c)) {
//                        map.put(c, new ArrayList<>());
//                    }
//                    map.get(c).add(item);
//                }
//            }
//        }
        int[]                   cnt       = new int[10];
        char[]                  charArray = s.toCharArray();
        Map<Character, Integer> freq      = new HashMap<>();
        for (char ch : charArray) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        cnt[0]=freq.getOrDefault('z',0);
        cnt[8]=freq.getOrDefault('g',0);
        cnt[4]=freq.getOrDefault('u',0);
        cnt[2]=freq.getOrDefault('w',0);
        cnt[6]=freq.getOrDefault('x',0);

        cnt[5]=freq.getOrDefault('f',0)-cnt[4];
        cnt[7]=freq.getOrDefault('v',0)-cnt[5];
        cnt[3]=freq.getOrDefault('h',0)-cnt[8];
        cnt[1]=freq.getOrDefault('o',0)-cnt[2]-cnt[4]-cnt[0];
        cnt[9]=(freq.getOrDefault('n',0)-cnt[1]-cnt[7])/2;


        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<10;i++){
            for (int j=0;j<cnt[i];j++){
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Solution423 solution423 = new Solution423();
        String ans=solution423.originalDigits("zerozero");
        System.out.println(ans);
    }
}
