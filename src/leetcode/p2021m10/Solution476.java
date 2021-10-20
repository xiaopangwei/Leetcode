package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/18
 * @time 8:27 PM
 */
public class Solution476 {
    public int findComplement(int num) {
        int base=1;
        int sum=0;
        while(num!=0){
            int t=num & 1;
            if(t==0){
                sum+=base;
            }
            num = num >> 1;
            base=base << 1;
        }
        return sum;
    }


    public static void main(String[] args){
        Solution476 solution476=new Solution476();
        int t=solution476.findComplement(5);
        System.out.println(t);
    }
}
