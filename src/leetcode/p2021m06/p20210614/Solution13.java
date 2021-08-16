package leetcode.p2021m06.p20210614;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/18
 * @time 3:09 PM
 */
public class Solution13 {
    private Map<Character,Integer> valueMap=new HashMap<>();




    public int romanToInt(String s) {
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
        char[] charArray=s.toCharArray();
        char prev=charArray[0];
        int res=0;
        for (int i=1;i<charArray.length;i++){
            char ch=charArray[i];
            if (valueMap.get(prev)<valueMap.get(ch)){
                res=(res-valueMap.get(prev));
            }else{
                res=(res+valueMap.get(prev));
            }
            prev=ch;
        }

        res+=(valueMap.get(prev));

        return res;
    }

    public static void main(String[] args){
        Solution13 solution13=new Solution13();
        System.out.println(solution13.romanToInt("MCMXCIV"));
    }
}
