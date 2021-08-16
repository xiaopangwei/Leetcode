package leetcode.p20210217;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/17
 * @time 10:31 AM
 */
public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans=-1;
        for (int i=0;i<gas.length;i++){
            final int j=i;
            if (canCompleteCircuit(gas, cost,i,0,j)){
                return j;
            }
        }
        return ans;
    }

    public boolean canCompleteCircuit(int[] gas, int[] cost,int gasIndex,int remained,final int startIndex) {
        if (remained+gas[gasIndex]<cost[gasIndex])
        {return false;}
        else{
            int nextIndex=(gasIndex+1)%cost.length;
            if (nextIndex==startIndex){
                return true;
            }
            int newGas=remained+gas[gasIndex]-cost[gasIndex];
            return canCompleteCircuit(gas, cost, nextIndex, newGas,startIndex);
        }
    }



    public static void main(String[] args) throws Exception{
        Solution134 solution134=new Solution134();
        System.out.println(solution134.canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }
}
