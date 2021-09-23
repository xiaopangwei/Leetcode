package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 4:05 PM
 */
public class Solution255 {
    public boolean verifyPreorder(int[] preorder) {

        return dfs(preorder,0,preorder.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean dfs(int[] preOrder,int start,int end,int lowerBound,int upperBound){
//        System.out.println(start+" "+end+" "+lowerBound+" "+upperBound);
        if (start>end){
            return true;
        }

        if (preOrder[start]<=lowerBound || preOrder[start]>=upperBound){
//            System.out.println(start+" "+preOrder[start]+" false");
            return false;
        }
        int idx=-1;
        for (int i=start;i<=end;i++){
            if (preOrder[i]>preOrder[start]){
                idx=i;
                break;
            }
        }
        if (idx!=-1) {
            return dfs(preOrder, start + 1, idx - 1,  lowerBound, preOrder[start])
                    && dfs(preOrder, idx, end, preOrder[start], upperBound);
        }else{
            return dfs(preOrder, start + 1, end, lowerBound, preOrder[start]);
        }

    }

    public static void main(String[] args){

        int[] array=new int[]{5,2,1,3,6};
        Solution255 solution255=new Solution255();
        boolean ans=solution255.verifyPreorder(array);
        System.out.println(ans);
    }
}
