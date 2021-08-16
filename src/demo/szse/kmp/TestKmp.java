package demo.szse.kmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/3
 * @time 11:05 AM
 */
public class TestKmp {
    public static void main(String[] args){
        int[] array=new int[]{10,4,3,6,7,1};
        int len=array.length;
        System.out.println("len:"+len);
//        int[]         result   =Arrays.copyOfRange(array,2,len);
        List<Integer> dataList =Arrays.asList(1,2,3,4);
        System.out.println(dataList.getClass());
        List<String> strList=new ArrayList<>();

//        System.out.println(strList);
//        strList.add("1");
//        strList.add("2");
//        strList.add("3");
//        strList.add("2");
//        for(String s:strList) {
//            strList.remove(s);
//        }



        System.out.println(strList);

//        System.out.println(Reflection.getCallerClass());

    }
}
