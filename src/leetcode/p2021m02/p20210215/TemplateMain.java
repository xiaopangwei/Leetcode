package leetcode.p2021m02.p20210215;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TemplateMain {

    static class Fruit {}
    static class Apple extends Fruit {}
    static class Jonathan extends Apple {}
    static class Orange extends Fruit {}

    public static void main(String[] args) throws Exception{

        List<? super Apple> superList3 = new ArrayList<>();
        superList3.add(new Apple());
        superList3.add(new Jonathan());

        List<? extends Apple> extendList=new ArrayList<>();

        Apple apple1=extendList.get(0);
        Fruit fruit1=extendList.get(0);

        Collections.copy(superList3,extendList);






    }
}
