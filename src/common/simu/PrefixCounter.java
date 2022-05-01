package common.simu;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/4/27
 * @time 9:43 PM
 */
public class PrefixCounter {

    public int counting(String[] array, String target) {
        Map<String, Integer> freq = new HashMap<>();
        for (String item : array) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        System.out.println(freq);
        int ans=0;
        for (int i = 1; i < target.length(); i++) {
            String left  = target.substring(0, i);
            String right = target.substring(i);
            ans+=(freq.getOrDefault(left,0)*freq.getOrDefault(right,0));
        }
        return ans;
    }

    public static void main(String[] args){
        PrefixCounter prefixCounter=new PrefixCounter();
        int cnt=prefixCounter.counting(new String[]{"aa","aa","a","b","b","bb"},"aab");
        System.out.println(cnt);

    }
}
