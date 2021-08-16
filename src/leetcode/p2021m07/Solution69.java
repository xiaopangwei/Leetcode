package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 6:24 PM
 */
public class Solution69 {
    public int mySqrt(int x) {

        if (x==0){
            return 0;
        }
        int N=x;
        double idx=x*1.0;
        while (true){
            double newIndex=0.5*(idx+N*1.0/idx);
            if (Math.abs(newIndex-idx)<=0.00001){
                break;
            }
//            System.out.println(newIndex);
            idx=newIndex;
        }

        return Math.abs((int)idx);
    }

    public static void main(String[] args){
        Solution69 solution69=new Solution69();
//        for (int i=0;i<100;i++){
            System.out.println(solution69.mySqrt(2147395599));
//        }
    }
}
