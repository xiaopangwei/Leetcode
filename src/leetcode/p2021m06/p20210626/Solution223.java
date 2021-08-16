package leetcode.p2021m06.p20210626;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/25
 * @time 11:07 PM
 */
public class Solution223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {

        if (In(by2,ay1,ay2) && In(bx1,ax1,ax2)){

        }else if(In(ay2,by1,by2) && In(bx1,ax1,ax2)) {

        }

        return 0;

    }

    private boolean In(int v1,int start,int end){
        return start<=v1 && end>=v1;
    }
}
