package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 3:56 PM
 */
public class Solution149 {
    public int maxPoints(int[][] points) {

        if (points.length<=2){
            return points.length;
        }
        int ans=-1;
        for (int i=0;i<points.length;i++){
            for (int j=i+1;j<points.length;j++){

                //point[i] point[j]
                if (points[i][0]==points[j][0]){
                    int count=2;
                    for (int p=0;p<points.length;p++){
                        if (p!=i && p!=j){
                            if (points[p][0]==points[i][0]){
                                count++;
                            }
                        }
                    }
                    ans=Math.max(ans,count);
                }else if (points[i][1]==points[j][1]){
                    int count=2;
                    for (int p=0;p<points.length;p++){
                        if (p!=i && p!=j){
                            if (points[p][1]==points[i][1]){
                                count++;
                            }
                        }
                    }
                    ans=Math.max(ans,count);
                }else{
                    int count=2;
                    for (int p=0;p<points.length;p++){
                        if (p!=i && p!=j){

                            long x=(points[i][1]-points[j][1])*(points[p][0]-points[i][0]);
                            long y=(points[i][0]-points[j][0])*(points[p][1]-points[i][1]);

                            if (x==y){
                                count++;
                            }
                        }
                    }
                    ans=Math.max(ans,count);
                }

            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution149 solution149=new Solution149();
//        {1,1},{3,2},{5,3},{4,1},{2,3},{1,4}
//        {{1,1},{2,2},{3,3}}
//        [[5151,5150],[0,0],[5152,5151]]
        int max=solution149.maxPoints(new int[][]{{5151,5150},{0,0},{5152,5151}});
        System.out.println(max);
    }
}
