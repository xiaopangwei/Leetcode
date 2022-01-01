package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/28
 * @time 10:02 PM
 */
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean flag1 = true;
                if (i == 0) {
                    flag1 = true;
                } else if (i - 1 >= 0 && flowerbed[i - 1] == 0) {
                    flag1 = true;
                } else {
                    flag1 = false;
                }

                boolean flag2 = true;
                if (i == flowerbed.length - 1) {
                    flag2 = true;
                } else if (i + 1 < flowerbed.length && flowerbed[i + 1] == 0) {
                    flag2 = true;
                } else {
                    flag2 = false;
                }

                if (flag1 && flag2) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return n<=0?true:false;
    }

    public static void main(String[] args) {
        Solution605 solution605 = new Solution605();
        boolean     ans         = solution605.canPlaceFlowers(new int[]{1,0,1,0,1,0,1}, 0);
        System.out.println(ans);

    }
}
