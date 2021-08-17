package common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 4:14 PM
 */
public class ArraysUtils {

    public static void arrayToList(final int[] array, List<Integer> list) {
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
    }


    public static void arrayToList(final int[][] array, List<List<Integer>> list) {
        for (int i = 0; i < array.length; i++) {
            List<Integer> line = new ArrayList<>();
            arrayToList(array[i], line);
            list.add(line);
        }
    }


    public static void listToArray(final List<Integer> list, int[] array) {
        int k = 0;
        for (int item : list) {
            array[k++] = item;
        }
    }

    public static void listToArray(final List<List<Integer>> list, int[][] array) {
        int k = 0;
        for (List<Integer> line : list) {
            int[] temp = new int[line.size()];
            listToArray(line, temp);
            array[k++] = temp;
        }
    }


    public static <T> T[] listToArrayWithOneDimension(List<T> list, Class<T> clz) {
        T[] array = (T[]) Array.newInstance(clz, list.size());
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }


    public static <T> T[][] listToArrayWithTwoDimension(List<List<T>> list, Class<T> clz, int cols) {
        T[][] ans = (T[][]) Array.newInstance(clz, list.size(), cols);

        for (int i = 0; i < list.size(); i++) {
            ans[i] = listToArrayWithOneDimension(list.get(i), clz);
        }
        return ans;
    }

    public static <T> List<T> arrayToList(T[] array) {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        return list;
    }


    public static <T> List<List<T>> arrayToList(T[][] array) {

        List<List<T>> ans = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            ans.add(arrayToList(array[i]));
        }
        return ans;
    }


    public static void main(String[] args) {
//        int[]   oneDArray = new int[]{1, 2, 3, 6, 5465};
//        int[][] twoDArray = new int[][]{{1, 2}, {4, 7, 0}, {1}, {}};
//
//        List<Integer> list1 = new ArrayList<>();
//        ArraysUtils.arrayToList(oneDArray, list1);
//        System.out.println(list1);
//
//        List<List<Integer>> list2 = new ArrayList<>();
//        ArraysUtils.arrayToList(twoDArray, list2);
//        System.out.println(list2);
//
//        int[] a1 = new int[list1.size()];
//        ArraysUtils.listToArray(list1, a1);
//        System.out.println(Arrays.toString(a1));
//
//        int[][] a2 = new int[list2.size()][3];
//        ArraysUtils.listToArray(list2, a2);
//        for (int i = 0; i < a2.length; i++) {
//            System.out.print(Arrays.toString(a2[i]) + " ");
//        }

        String[]     oneDArray = new String[]{"wabw", "wdefw", "wddseww"};
        String[][]   twoDArray = new String[][]{{"0abv", "def", "ddsew"}, {"2abv", "2def", "2ddsew"}};
        List<String> oneDlist  = Arrays.asList("abv", "def", "ddsew");
        List<List<String>> twoDlist = Arrays.asList(Arrays.asList("0abv", "def", "ddsew"),
                Arrays.asList("1abv", "1def", "1ddsew"),
                Arrays.asList("2abv", "2def", "2ddsew"));

        String[] ans = ArraysUtils.listToArrayWithOneDimension(oneDlist, String.class);
//        System.out.println(Arrays.toString(ans));


        String[][] res = ArraysUtils.listToArrayWithTwoDimension(twoDlist, String.class, 3);


        System.out.println(ArraysUtils.arrayToList(oneDArray));
        System.out.println(ArraysUtils.arrayToList(twoDArray));

    }

}
