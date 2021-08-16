package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * O(N*LOG(N))
 * @author weihuang
 * @date 2021/7/26
 * @time 11:28 AM
 */
public class LongestIncreasingSubString {
    public int  getLIS(int[] num){
        int[] tail=new int[num.length];
        tail[0]=num[0];
        int end=0;

        for (int i=1;i<num.length;i++){
            int target=num[i];
            if (target>tail[end]) {
                end++;
                tail[end] = num[i];
            }

            int left=0;
            int right=end;
            while (left<=right){
                int mid=(left+right)/2;
                if (tail[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

            //left>right
            tail[left]=target;
        }
        return end+1;
    }

    public static void main(String[] args){
        LongestIncreasingSubString longestIncreasingSubString=new LongestIncreasingSubString();
        int ans=longestIncreasingSubString.getLIS(new int[]{100,12,13,4});
        System.out.println(ans);

    }

}
