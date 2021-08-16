package leetcode.p2021m02.p20210214;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TemplateMain {
    public static void main(String[] args) throws Exception{

        Son   son   =new Son<String,Integer,Short>();

        Arrays.stream(son.getClass().getTypeParameters()).forEach(item->System.out.println(item));

        Field field =son.getClass().getDeclaredField("map");

        System.out.println(field.getType());


        System.out.println(field.getGenericType());

        ParameterizedType type=(ParameterizedType) field.getGenericType();


        System.out.println(type.getRawType());
        System.out.println(type.getOwnerType());
        Arrays.stream(type.getActualTypeArguments()).forEach(item->System.out.println(item));





    }
}
