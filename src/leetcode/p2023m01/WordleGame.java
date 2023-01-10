package leetcode.p2023m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/7
 * @time 5:33 PM
 */
public class WordleGame {
    public String getColor(String target, String source) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (target.contains(String.valueOf(source.charAt(i)))) {
                    stringBuilder.append("Y");
                } else {
                    stringBuilder.append("B");
                }
            } else {
                stringBuilder.append("G");
            }
        }
        return stringBuilder.toString();
    }

    public String getColor2(String target, String source) {
        char[]                  array  = new char[target.length()];
        Map<Character, Integer> posMap = new HashMap<>();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                array[i] = 'G';
            } else {
                array[i] = 'B';
                posMap.put(target.charAt(i), posMap.getOrDefault(target.charAt(i), 0) + 1);
            }
        }

        for (int i = 0; i < source.length(); i++) {
            if (array[i] == 'B') {
                char ch  = source.charAt(i);
                int  pos = posMap.getOrDefault(ch, 0);
                if (pos > 0) {
                    array[i] = 'Y';
                    if (pos - 1 > 0) {
                        posMap.put(ch, pos - 1);
                    } else {
                        posMap.remove(ch);
                    }
                }

            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        WordleGame wordleGame = new WordleGame();
        String     target     = "HAPPY";
//        BBGGG
        String src = "PUPPY";
        System.out.println(wordleGame.getColor2(target, src));
    }
}
