package leetcode.p2022m05.day0510;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 9:06 PM
 */
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });
//        for (int i = 0; i < people.length; i++) {
//            System.out.println(Arrays.toString(people[i]));
//        }
//        System.out.println("-----");
        List<int[]> list = new ArrayList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][]     array       = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        Solution406 solution406 = new Solution406();
        int[][] ans=solution406.reconstructQueue(array);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }


//        List<Integer> list=new ArrayList<>();
//
//        for (int i=0;i<5;i++){
//            list.add(-1);
//        }
//
//        System.out.println(list);
//
//        list.add(2,0);
//        System.out.println(list);
//        list.add(2,1);
//        System.out.println(list);
//        list.add(2,2);
//        System.out.println(list);

    }
}
