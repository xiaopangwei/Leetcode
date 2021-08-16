package leetcode.p20210627;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/27
 * @time 10:11 PM
 */
public class SolutionLCP06 {
    public int minCount(int[] coins) {

        int times=0;
        for (int coin:coins){
            while (coin>0){
                coin-=2;
                times++;
            }
        }
        return times;
    }

    public static void main(String[] args){
        SolutionLCP06 solutionLCP06=new SolutionLCP06();
        System.out.println(solutionLCP06.minCount(new int[]{2,3,10}));
        System.out.println(solutionLCP06.minCount(new int[]{4,2,1}));
    }
}
