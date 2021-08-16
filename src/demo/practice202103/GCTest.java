package demo.practice202103;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/4
 * @time 10:32 AM
 */
public class GCTest {

    public static void main(String[] args){
            byte[] placeHolder=new byte[3*1024*1024];
            placeHolder=null;
            System.gc();
    }
}
