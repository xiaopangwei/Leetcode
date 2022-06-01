package demo.discuss;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/17
 * @time 10:04 PM
 */
public class Discuss233 {

    public boolean solve(int[] nums1, int[] nums2) {
//        [6 3 4] 321 [8 5 3] 321
        int[][] t1 = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            t1[i] = new int[]{i, nums1[i]};
        }
        int[][] t2 = new int[nums2.length][2];
        for (int i = 0; i < nums2.length; i++) {
            t2[i] = new int[]{i, nums2[i]};
        }

        Arrays.sort(t1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        Arrays.sort(t2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            if (t1[i][0] != t2[i][0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Discuss233 discuss233=new Discuss233();
        boolean ans=discuss233.solve(new int[]{6,4,3},new int[]{8,5,3});
        System.out.println(ans);
    }
}
