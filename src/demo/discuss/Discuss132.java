package demo.discuss;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/9
 * @time 10:19 PM
 */
public class Discuss132 {

    public void reorder(int[] array) {
        int i = 0;
        int j = array.length - 1;

        int n = array.length;

        while (i < j) {

            while (j >= 0 && array[j] % 2 == 0) {
                j--;
            }

            while (i < n && array[i] % 2 != 0) {
                i++;
            }

            if (i < j) {
                swap(array, i, j);
                i++;
                j--;
            } else {
                break;
            }
        }
    }


    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {

        int[] array = new int[]{0,2,3, 4, 1, 10, 101,0, 5, 6, 11, 2};
        System.out.println(Arrays.toString(array));
        Discuss132 discuss132 = new Discuss132();
        discuss132.reorder(array);
        System.out.println(Arrays.toString(array));
    }
}
