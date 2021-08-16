package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 2:17 PM
 */
public class Codec {

    //26+26+10
    static char[] originalTable = new char[62];

    //<缩写,全写>
    Map<String, String> convertMap = new HashMap<>();

    static {
        int k = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            originalTable[k++] = ch;
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            originalTable[k++] = ch;
        }
        for (char ch = '0'; ch <= '9'; ch++) {
            originalTable[k++] = ch;
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encoded = null;
        while (true) {
            encoded = getRandom();
            if (!convertMap.containsKey(encoded)) {
                break;
            }
        }
        convertMap.put(encoded, longUrl);
        return "http://tinyurl.com/" + encoded;
    }

    private String getRandom() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int idx = new Random().nextInt(62);
            builder.append(originalTable[idx]);
        }
        return builder.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        String encoded = shortUrl.replace("http://tinyurl.com/", "");
        return convertMap.get(encoded);
    }

    public static void main(String[] args) {
        Codec  codec = new Codec();
        String temp  = codec.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(temp);
        String decoded = codec.decode(temp);
        System.out.println(decoded);

        temp  = codec.encode("https://leetcode.com/problems/design-tinyurl1");
        System.out.println(temp);
        decoded = codec.decode(temp);
        System.out.println(decoded);
    }
}
