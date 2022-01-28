package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/24
 * @time 10:14 PM
 */
public class SolutionJZOffer33 {
    public boolean verifyPostorder(int[] postorder) {

        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int rootVal = postorder[end];

        int i = start;

        int j = -1;
        while (i <= end) {
            if (postorder[i] < rootVal) {
                i++;
            } else {
                j = i;
                break;
            }
        }

        while (j >= 0 && j < end) {
            if (postorder[j] < rootVal) {
                return false;
            } else {
                j++;
            }
        }


        return dfs(postorder, start, j - 1) && dfs(postorder, j, end - 1);
    }

    public static void main(String[] args) {
        SolutionJZOffer33 solutionJZOffer33 = new SolutionJZOffer33();
        boolean           ans               = solutionJZOffer33.verifyPostorder(new int[]{1,2,3});
        System.out.println(ans);
    }
}
