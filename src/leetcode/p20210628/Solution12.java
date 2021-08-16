package leetcode.p20210628;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 2:21 PM
 */
public class Solution12 {
    public String intToRoman(int num) {

        Map<Integer,String> dict=new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        dict.put(1,"I");
        dict.put(4,"IV");
        dict.put(5,"V");
        dict.put(9,"IX");
        dict.put(10,"X");
        dict.put(40,"XL");
        dict.put(50,"L");
        dict.put(90,"XC");
        dict.put(100,"C");
        dict.put(400,"CD");
        dict.put(500,"D");
        dict.put(900,"CM");
        dict.put(1000,"M");
        int base=num;
        StringBuilder builder=new StringBuilder();
        while (base!=0) {
            for (Map.Entry<Integer, String> entry : dict.entrySet()) {
                if (entry.getKey() > base) {
                    continue;
                }else {
                    builder.append(entry.getValue());
                    base -= entry.getKey();
                    break;
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Solution12 solution12=new Solution12();
        System.out.println(solution12.intToRoman(58));
        System.out.println(solution12.intToRoman(3));
        System.out.println(solution12.intToRoman(9));
    }
}
