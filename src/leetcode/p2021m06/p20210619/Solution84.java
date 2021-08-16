package leetcode.p2021m06.p20210619;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 1:29 PM
 */
public class Solution84 {
    class Pair{
        public int index;
        public int height;

        public Pair(int index,int height){
            this.index=index;
            this.height=height;
        }
    }
    public int largestRectangleArea(int[] heights) {

        int maxArea=0;
        Stack<Pair> stack=new Stack<>();


        int[] newHeight=new int[heights.length+2];
        newHeight[0]=0;
        for (int i=1;i<heights.length+1;i++){
            newHeight[i]=heights[i-1];
        }
        newHeight[heights.length+1]=0;
//        System.out.println(Arrays.toString(heights));
        heights=newHeight;
//        System.out.println(Arrays.toString(heights));

        for (int i=0;i<heights.length;i++){
            if (stack.isEmpty()){
                stack.push(new Pair(i,heights[i]));
            }
            else {
                Pair top = stack.peek();
                if (heights[i] >= top.height) {
                    stack.push(new Pair(i, heights[i]));
                } else {
                    while (heights[i] < stack.peek().height) {

                        Pair temp = stack.pop();
                        int  area = temp.height * (i - stack.peek().index-1);
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    }
                    stack.push(new Pair(i, heights[i]));
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        int[] array=new int[]{2,1,2};
        Solution84 solution84=new Solution84();
        System.out.println(solution84.largestRectangleArea(array));
    }
}
