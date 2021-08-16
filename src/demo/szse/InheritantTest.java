package demo.szse;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/8
 * @time 5:17 PM
 */
public class InheritantTest {

    static class Father{
        protected String name;
        private Father(){
            System.out.println("Father xxxx");
        }
        public Father(String name){
            System.out.println("Father yyyy");
            this.name=name;
        }
    }
    static class Son extends Father{
        int age=100;
        String ref="67890";
        {
            System.out.println("Block1");
            System.out.println("12345 age:"+age);
            System.out.println("12345 ref:"+ref);
        }
        public Son(String name,int age){
            super(name);
            this.age=age;
            System.out.println("Father yyyy");

        }
    }

    static class Grand{
        static {
            System.out.println("Static Block");
        }

        int x=get();
        {
            System.out.println("11:"+x);
            x=2;
            System.out.println("33:"+x);
        }


        {
            x=100;
        }


        public Grand(){

            System.out.println("Constructor");
            System.out.println("22:"+x);
            x=4;
            System.out.println("44:"+x);
        }


        public int get(){
            System.out.println("get method");
            return 203;
        }
    }

    public static void main(String[] args){
        Grand grand=new Grand();
    }
}
