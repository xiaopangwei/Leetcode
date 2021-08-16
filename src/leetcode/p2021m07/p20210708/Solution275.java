package leetcode.p2021m07.p20210708;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/12
 * @time 1:03 PM
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        int length=citations.length;
        int ans=0;
        for (int i=citations.length-1;i>=0;i--){
            int pivot=citations[i];
            if (pivot>=length-i){
                ans++;
            }else{
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution275 solution275=new Solution275();
        System.out.println(solution275.hIndex(new int[]{0,1,3,5,6}));
        System.out.println(solution275.hIndex(new int[]{0,1,4,5,6}));
        System.out.println(solution275.hIndex(new int[]{0}));
    }
}
