package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/8
 * @time 9:20 PM
 */
public class SparseVector {

    List<int[]> list;

    SparseVector(int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i=0;
        int j=0;

        int s=0;
        while (i<this.list.size() && j<vec.list.size()){
            if (this.list.get(i)[0]==this.list.get(j)[0]){
                s+=this.list.get(i)[1]*this.list.get(j)[1];
                i++;
                j++;
            }else if (this.list.get(i)[0]<this.list.get(j)[0]){
                i++;
            }else {
                j++;
            }
        }
        return s;
    }
}
