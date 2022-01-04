package leetcode.p2021m06.p20210628;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 1:56 PM
 */
public class Solution157 extends Reader4{



    public int read(char[] buf, int n) {

        int offset=0;
        char[] array=new char[4];
        while (true){
            int ret=read4(array);
            if (ret>0)
            {
                if (ret+offset>n){
                    System.arraycopy(array, 0, buf, offset, n-offset);
                    return n;
                }else {
                    System.arraycopy(array, 0, buf, offset, ret);
                    offset += ret;
                    if (ret < 4) {
                        return offset;
                    }
                }

            }else{
                return offset;
            }
        }

    }

    public static void main(String[] args){
        Solution157 solution157=new Solution157();
        char[] res=new char[1024];
        int count=solution157.read(res,9);
        System.out.println("count:"+count);
        for (int i=0;i<count;i++){
            System.out.println(res[i]);
        }

    }

    @Override
    public int read4(char[] buf4) {
        buf4[0]='A';
        buf4[1]='B';
        buf4[2]='C';
        buf4[3]='D';
        return 4;
    }
}
