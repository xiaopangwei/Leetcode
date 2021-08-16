package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 2:22 PM
 */
public class Solution334 {
    public boolean increasingTriplet(int[] nums) {

        if (nums.length<3){
            return false;
        }
        int[] tail=new int[nums.length];
        tail[0]=nums[0];
        int end=0;
        for (int i=1;i< nums.length;i++){
            if (nums[i]>tail[end]){
                end++;
                if (end==2){
                    return true;
                }
                tail[end]=nums[i];
            }else{

                for (int j=0;j<=end;j++){
                    if (nums[i]<tail[j] ){
                        if (j>0 && nums[i]>tail[j-1]) {
                            tail[j] = nums[i];
                            break;
                        }else if (j<=0){
                            tail[j] = nums[i];
                            break;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Solution334 solution334=new Solution334();
        //1,2,1,2,1,2,1,2,1,2
        System.out.println(solution334.increasingTriplet(new int[]{1,2,1,2,1,2,1,2,1,2}));
    }
}
