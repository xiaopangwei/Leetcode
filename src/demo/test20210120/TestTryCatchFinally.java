package demo.test20210120;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/20
 * @time 10:04 PM
 */
public class TestTryCatchFinally {

    private int aa;
    private static int bb;
    private static final int  cc=1;
    private final int  dd=1;
    public static void main(String[] args){

//            try {
//                // dosomething
//                System.out.println("enter try block");
//                System.out.println(1/0);
//                throw new RuntimeException();
//            } catch (IllegalArgumentException e) {
//                System.out.println("enter catch block");
//                System.out.println(2/0);
//            } finally {
//                System.out.println("enter finally block");
//            }
        TestTryCatchFinally testTryCatchFinally=new TestTryCatchFinally();
        System.out.println(testTryCatchFinally.test1());
        System.out.println(testTryCatchFinally.test2());
        System.out.println(testTryCatchFinally.test3());
//        System.out.println(testTryCatchFinally.test4());
        System.out.println(testTryCatchFinally.test5());
//        System.out.println(testTryCatchFinally.test4());
    }

    public  int test1(){
        int a = 9;
        try {
            a = 8;
            return a;
        }catch (Exception e){
            a = 7;
            return a;
        }finally {
            a = 6;
        }
    }

    public  int test2(){
        int a = 9;
        try {
            a = 8;
            int b = 1/0;
            return a;
        }catch (Exception e){
            a = 7;
            return a;
        }finally {
            a = 6;
        }
    }

    public  int test3(){
        int a = 9;
        try {
            a = 8;
            return a;
        }catch (Exception e){
            a = 7;
            return a;
        }finally {
            a = 6;
            return a;
        }
    }


    public  int test4(){
        int a = 9;
        try {
            a = 8;
            return a;
        }catch (Exception e){
            a = 7;
            return a;
        }finally {
            a = 6;
            throw new RuntimeException();
        }
    }

    public  int test5(){
        int a = 9;
        try {
            a = 8;
            int c=1/0;
            return a;
        }catch (IllegalArgumentException e){
            a = 7;
        }finally {
            a = 6;
        }
        return -1;
    }
}
