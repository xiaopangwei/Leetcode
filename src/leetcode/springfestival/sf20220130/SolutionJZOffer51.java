package leetcode.springfestival.sf20220130;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 10:07 AM
 */
public class SolutionJZOffer51 {
    int ans = 0;

    public int reversePairs(int[] nums) {

        if (nums.length<=1){
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, mid + 1, end);
    }

    private void merge(int[] nums1, int s1, int e1, int s2, int e2) {
        int[] temp = new int[e2 - s1 + 1];
        int   i    = s1;
        int   j    = s2;
        int   idx  = 0;

        while (i <= e1 && j <= e2) {
            if (nums1[i] == nums1[j]) {
                temp[idx++] = nums1[i++];
//                temp[idx++] = nums1[j++];
            } else if (nums1[i] < nums1[j]) {
                temp[idx++] = nums1[i++];
            } else {
                ans += (e1 - i + 1);
                temp[idx++] = nums1[j++];
            }
        }

        while (i <= e1) {
            temp[idx++] = nums1[i];
            i++;
        }

        while (j <= e2) {
            temp[idx++] = nums1[j];
            j++;
        }

        for (int t = 0; t < temp.length; t++) {
            nums1[s1 + t] = temp[t];
        }
    }

    public static void main(String[] args) {
        SolutionJZOffer51 solutionJZOffer51 = new SolutionJZOffer51();
        int               ans               = solutionJZOffer51.reversePairs(new int[]{1,3,2,3,1});
        System.out.println(ans);
    }
}
