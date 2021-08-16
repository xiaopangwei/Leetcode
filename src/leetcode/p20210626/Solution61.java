package leetcode.p20210626;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 2:08 PM
 */
public class Solution61 {
    public boolean isStraight(int[] nums) {

        boolean[] temp=new boolean[14];
        int zeroCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                temp[nums[i]]=true;
            }else {
                zeroCount++;
            }
        }

        for (int i=1;i<temp.length;i++){
            if (temp[i]){
                int start=i;
                for (int j=1;j<=4;j++){
                    if (start+j>=14){
                        if (5-j>zeroCount) {
                            return false;
                        }else{
                            zeroCount--;
                        }
                    }else {
                        if (!temp[start + j]) {
                            if (zeroCount <= 0) {
                                return false;
                            } else {
                                zeroCount--;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution61 solution61=new Solution61();
//        System.out.println(solution61.isStraight(new int[]{1,2,3,4,5}));
//        System.out.println(solution61.isStraight(new int[]{1,2,0,0,5}));
//        System.out.println(solution61.isStraight(new int[]{1,2,3,4,6}));
//        0,12,11,11,0
//        11,10,0,0,12
        System.out.println(solution61.isStraight(new int[]{0,0,0,11,12}));
    }
}
