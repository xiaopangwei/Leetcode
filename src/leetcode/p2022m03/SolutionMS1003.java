package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/2
 * @time 9:07 PM
 */
public class SolutionMS1003 {

    public int search(int[] arr, int target) {
        if(arr[0]==target)
            return 0;
        int l=0;
        int r=arr.length-1;
        int mid=0;
        while(l<=r){
            mid=l+(r-l)/2;
            //mid值==target,则继续往左搜寻，找到最小的索引，最小索引一定不为0
            if(arr[mid]==target){
                while(mid>0&&arr[mid-1]==arr[mid])  mid--;
                return mid;
            }
            //说明mid~r是递增序列，判读target是否在中间
            if(arr[mid]<arr[r]){
                if(arr[mid]<target&&target<=arr[r]) l=mid+1;
                else    r=mid-1;
            }
            //说明 l~mid 是递增序列，判读target是否在中间
            else if(arr[mid]>arr[r]){
                if(arr[l]<=target&&target<arr[mid]) r=mid-1;
                else l=mid+1;
            }
            //arr[mid]==arr[r]说明要么r~0~mid都相等，要么mid~r都相等，无论哪种r 都可以舍去
            else{
                r--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        [1,1,1,1,1,2,1,1,1]
//        2
        int[]          array          = new int[]{5,5,5,1,2,3,4,5};
        SolutionMS1003 solutionMS1003 = new SolutionMS1003();
        int            ans            = solutionMS1003.search(array, 5);
        System.out.println(ans);
    }

}
