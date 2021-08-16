package leetcode.p20210214;

import com.sun.tools.javac.code.Attribute;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TestJavaClass {





    public static void main(String[] args) throws Exception{

        Class a=int[].class;

        Class b=Integer[].class;
        Class c=Integer.TYPE;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

//        Field[] fields=a.getDeclaredFields();
//        for (Field field:fields){
//            System.out.println(field.getName());
//        }


        int[] array=(int[])Array.newInstance(int.class,3);
        array[0]=1;
        array[1]=2;
        System.out.println(array[0]+" "+array[1]);

        System.out.println(Array.getInt(array,0));

        Class<?> arrClass=Class.forName("[I");

        System.out.println(arrClass.isArray());
        System.out.println(arrClass.getComponentType());


//        Object obj=arrClass.newInstance();
//        System.out.println(obj);

//      Class.forName("[I")

    }
}
