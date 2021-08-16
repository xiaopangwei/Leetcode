package demo.test20210120;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/20
 * @time 10:04 PM
 */
public class TestException {
    public static void main(String[] args) throws Exception{

//        Thread t=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("A1");
//                throw new RuntimeException("123");
//            }
//        });
//
//        t.start();
//
//        System.out.println("A2");
////        t.join();
//        while (true);

//                System.out.println("1 ----------------");
//        String a="abc";
//        String b="def";
//        final String c="ab";
//
//        System.out.println(c+"c"==a);
//
//        String a = "a1";
//        String b = "a" + 1;
//        System.out.println((a == b));

//        System.out.println("2 ----------------");
//        String a = "ab";
//        String bb = "b";
//        String b = ("a" + bb).intern();
//        System.out.println((a == b));


//        String c1=new String("huangxiaowei");
//        String c2=c1.intern();
//        String c3="huangxiaowei";
//        System.out.println(c1==c2);
//        System.out.println(c1=="huangxiaowei");
//        System.out.println(c2==c3);


//        String total="abcdef";
//
//        String c=a+b;
//        String d="abc"+"def";
//        System.out.println("abcdef"=="abc"+"def");
//        System.out.println("abcdef"==a+b);
//        System.out.println("abc"+"def"==d);
//
//
        System.out.println("----------------");
////
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);
////
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);
//
//        String s1 = new String("1");
//        System.out.println(s1.intern() == s1);

////
        String s1 = new String("1") + new String("1");
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);

    }
}
