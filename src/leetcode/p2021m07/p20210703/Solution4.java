package leetcode.p2021m07.p20210703;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/5
 * @time 3:55 PM
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1=nums1.length;
        int len2=nums2.length;
        int totalLen=len1+len2;
        if (totalLen%2==0){
            int a=findKthNumber(nums1,nums2,totalLen/2+1);
            int b=findKthNumber(nums1,nums2,totalLen/2);
            return (a+b)*1.0/2;
        }else{
            return findKthNumber(nums1,nums2,(totalLen+1)/2);
        }
    }

    private int findKthNumber(int[] nums1, int[] nums2,int k){
        int len1=nums1.length;
        int len2=nums2.length;

        int index1=0;
        int index2=0;

        while (true){
            if (index1>=len1){
                return nums2[index2+k-1];
            }
            if (index2>=len2){
                return nums1[index1+k-1];
            }
            if (k==1){
                   return Math.min(nums1[index1],nums2[index2]);
            }
            int half=k/2;
            int newIndex1=Math.min(index1+half-1,len1-1);
            int newIndex2=Math.min(index2+half-1,len2-1);
            if (nums1[newIndex1]<=nums2[newIndex2]){
                int len=newIndex1-index1+1;
                index1=newIndex1+1;
                k-=len;
            }else{
                int len=newIndex2-index2+1;
                index2=newIndex2+1;
                k-=len;
            }
        }
    }

    public static void main(String[] args){
        Solution4 solution4=new Solution4();
        //第七个 [6]
        //2
        int[] a=new int[]{1,2};
        //7
        int[] b=new int[]{11 ,12, 13, 14 ,15 ,16 ,17};
        System.out.println(solution4.findMedianSortedArrays(a,b));
    }
}
