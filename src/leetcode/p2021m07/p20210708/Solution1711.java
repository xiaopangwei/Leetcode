package leetcode.p2021m07.p20210708;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/7
 * @time 10:05 AM
 */
public class Solution1711 {

    public int countPairs(int[] deliciousness) {

        final int MOD=1000000007;


        int maxDelicious=Arrays.stream(deliciousness).max().getAsInt();

        Map<Integer,Integer> map=new HashMap<>();
        maxDelicious=maxDelicious*2;
        int cnt=0;
        for (int item:deliciousness){
                int base = 1;
                while (base <= maxDelicious) {
                    int leftNumber=base-item;
                    if (leftNumber >= 0 && map.containsKey(leftNumber)) {
                        System.out.println(item + " + " + leftNumber+" => "+map.get(leftNumber));
                        cnt = (cnt + map.get(leftNumber)) % MOD;
                    }
                    base = base << 1;
                }
                map.put(item,map.getOrDefault(item,0)+1);
        }

        return cnt%MOD;
    }

    public static void main(String[] args){
        Solution1711 solution1711=new Solution1711();
//        149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234
        solution1711.reformat();
        System.out.println(solution1711.countPairs(new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234}));
    }

//        107 + 149
//        63 + 1
//        0 + 1
//        1 + 1
//        1 + 63
//        1325 + 6867
//        2581 + 5611
//        89 + 39
//        18 + 46
//        20 + 12
//        234 + 22

//            149+107
//            1+63
//            1+0
//            1+1
//            63+1
//            0+1
//            6867+1325
//            5611+2581
//            39+89
//            46+18
//            12+20
//            22+234
    public void reformat(){
        int[] array=new int[]{149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234};
        Set<Integer> sets=new HashSet<>();
        int base=1;
        for (int i=0;i<=21;i++){
            sets.add(base);
            base*=2;
        }
        for (int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if (sets.contains(array[i]+array[j])){
                    System.out.println(array[i]+"+"+array[j]);
                }
            }
        }

    }

}
