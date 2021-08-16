package leetcode.p2021m06.p20210630;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 1:28 PM
 */
public class Solution1716 {
    public int totalMoney(int n) {

        int base=1;
        int current=1;

        int sum=0;
        for (int i=1;i<=n;i++){
            if ((i-1)%7==0){
                sum+=base;
                current=base;
                base++;
            }else{
                current+=1;
                sum+=current;
            }
        }

        return sum;
    }

    public static void main(String[] args){
        Solution1716 solution1716=new Solution1716();
        System.out.println(solution1716.totalMoney(4));
        System.out.println(solution1716.totalMoney(10));
        System.out.println(solution1716.totalMoney(20));
    }
}
