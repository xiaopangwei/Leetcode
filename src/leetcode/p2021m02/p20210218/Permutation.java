package leetcode.p2021m02.p20210218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/19
 * @time 6:28 PM
 */
public class Permutation {


    public void permutation(final int[] array,int startIndex,int endIndex,
                            List<String> resultList){
        if (startIndex==endIndex){
            System.out.println(Arrays.toString(array));
            System.out.println();
        }
        for (int i=startIndex;i<=endIndex;i++){
            swap(array,startIndex,i);
            permutation(array,startIndex+1,endIndex,resultList);
            swap(array,i,startIndex);
        }


    }


    public void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void main(String[] args){
        Permutation permutation=new Permutation();
        permutation.permutation(new int[]{1,2,3},0,2,new ArrayList<>());
    }
}
