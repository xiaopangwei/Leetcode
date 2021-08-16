package leetcode.p2021m06.p20210614;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/17
 * @time 2:47 PM
 */
public class SolutionWater {
    public int trap(int[] height) {
        if (height.length<=0){
            return 0;
        }
        int count=0;
        int[] left=getLeft(height);
        int[] right=getRight(height);
        for (int i=0;i<height.length;i++){
            count+=Math.min(left[i],right[i])-height[i];
        }
        return count;
    }

    private int[] getLeft(int[] height){
        int[] left=new int[height.length];
        left[0]=height[0];
        int max=height[0];
        for (int i=1;i<height.length;i++){
           if (max>=height[i]){
               left[i]=max;

           }else{
               max=height[i];
               left[i]=max;
           }
        }
        return left;
    }

    private int[] getRight(int[] height){
        int[] right=new int[height.length];
        int maxIndex=height.length-1;
        right[maxIndex]=height[maxIndex];
        int max=height[maxIndex];
        for (int i=maxIndex-1;i>=0;i--){
            if (max>=height[i]){
                right[i]=max;
            }else{
                max=height[i];
                right[i]=max;
            }
        }
        return right;
    }

    public static void main(String[] args){
        SolutionWater solutionWater=new SolutionWater();
        int ans=solutionWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(ans);
    }
}
