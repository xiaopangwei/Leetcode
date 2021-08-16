package leetcode.p2021m07.p20210714;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/14
 * @time 6:04 PM
 */
public class Solution1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] arr=new int[]{1,6,8,10};

        int index=this.binarySearch(arr,7);
        System.out.println(index);

        return index;

    }


    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            System.out.println(low+" "+high+" "+mid);
            if (rec[mid] < target) {
                low = mid + 1;
            } else if (rec[mid] > target){
                high = mid-1;
            }else{
                return mid;
            }
        }
        return low;
    }


    public static void main(String[] args){
        Solution1818 solution1818=new Solution1818();
        System.out.println(solution1818.binarySearch(new int[]{0,4,8,10,14},14));
    }


}
