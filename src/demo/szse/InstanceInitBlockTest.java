package demo.szse;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/8
 * @time 3:50 PM
 */
public class InstanceInitBlockTest {

    static class Son{
        private String name;

        static{
            CONST=6786;
            System.out.println("<clinit> demo.thread:"+Thread.currentThread().getName()
                    +"==>constructor");
        }

        public static Integer CONST=123;
        public Son(String name){
            this.name=name;
            System.out.println("demo.thread:"+Thread.currentThread().getName()
                            +"==>constructor");

        }

        {
            System.out.println("NORMAL 1:demo.thread:"+Thread.currentThread().getName()+"==>"
                    +this.name+"==>CONST:="+CONST);
        }

        {

            System.out.println("NORMAL 2:demo.thread:"+Thread.currentThread().getName()+"==>"
                    +this.name+"==>CONST:="+CONST);
        }

    }

    public static void main(String[] args){
        System.out.println(Son.CONST);
        Son son1=new Son("S1");
        Son son2=new Son("S2");
    }
}
