package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 11:15 AM
 */
public class Solution179 {
    public String largestNumber(int[] nums) {

        if (nums.length==1){
            return String.valueOf(nums[0]);
        }

        List<Integer> list=new ArrayList<>();
        for (int a:nums){
            list.add(a);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return compareXY(o1,o2);
            }
        });

        if (list.get(0)==0){
            return "0";
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int item:list){
            stringBuilder.append(String.valueOf(item));
        }


        return stringBuilder.toString();

    }


    private int compareXY(final int x, final int y){
        long a=1;
        if (x==0){
            a=10;
        }else {
            int xx = x;
            while (xx != 0) {
                a *= 10;
                xx /= 10;
            }
        }


        long b=1;
        if (y==0){
            b=10;
        }else {
            int yy = y;
            while (yy != 0) {
                b *= 10;
                yy /= 10;
            }
        }

        long temp1=x*b+y;
        long temp2=y*a+x;

//        System.out.println(temp1+" "+temp2);
        if (temp1==temp2){
            return 0;
        }
        else if (temp1>=temp2){
            return -1;
        }
        return 1;

    }


    public static void main(String[] args){
        Solution179 solution179=new Solution179();
        System.out.println(solution179.largestNumber(new int[]{98,4,6,100}));
    }
}
