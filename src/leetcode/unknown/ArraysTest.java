package leetcode.unknown;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/12
 * @time 8:40 PM
 */
public class ArraysTest {
    public static void main(String[] args){
        ArraysTest arraysTest=new ArraysTest();
        int[] array=new int[]{1,2,3,4,5,6,7};
        int[] res=Arrays.copyOfRange(array,1,3);
        System.out.println(Arrays.toString(res));
    }
}
