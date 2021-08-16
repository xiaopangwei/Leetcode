package demo.test20210120;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/19
 * @time 11:23 PM
 */
public class TestClonable {

    static class Bag implements Cloneable{
        String color="R";

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    static class Father{
        protected String name;
    }

    static class Son extends Father implements Cloneable{
        int age;
        String className="G1";
        Bag bag=new Bag();
        @Override
        public Object clone() throws CloneNotSupportedException {

            Son son=(Son)super.clone();
            Bag bag=(Bag) this.bag.clone();
            son.bag=bag;
            return son;

        }
    }
    public static void main(String[] args) throws Exception{
//        Integer a=10;
//        Integer b=200;
//        System.out.println(b==200);
//        System.out.println(a==200);
//
//        int c=10;
//        long d=10L;
//        double e=11.0;
//        System.out.println(c==d);
//        System.out.println(c==e);
//
//        WeakReference<Integer> integerWeakReference=new WeakReference<Integer>(a);
//
//        Son son =new Son();
//        son.age=12;
//        son.name="Huangwei";
//
//        Son son1=(Son)son.clone();
//
//        System.out.println(son.bag==son1.bag);
////
//        System.out.println(son.age+" "+son.name+" "+son.className+" "+son.bag.color);
//        System.out.println(son1.age+" "+son1.name+" "+son.className+" "+son1.bag.color);

//        son.age=123;
//
//        System.out.println(son.age+" "+son.name+" "+son.className);
//        System.out.println(son1.age+" "+son1.name+" "+son.className);

//        System.out.println(son.className==son1.className);
//        System.out.println(son.className.equals(son1.className));
//
//
//        System.out.println(son.bag==son1.bag);
//
//
//
//        son.name="weiweizi";
//        son.className="CMS";
//        son.bag.color="G";
//
//        System.out.println(son.age+" "+son.name+" "+son.className+" "+son.bag.color);
//        System.out.println(son1.age+" "+son1.name+" "+son1.className+" "+son1.bag.color);
//
//        System.out.println(son.className==son1.className);
//        System.out.println(son.className.equals(son1.className));

        int[] a1=new int[]{1,2,3};
        int[] a2=a1.clone();

        a1[1]=100;

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));




    }
}
