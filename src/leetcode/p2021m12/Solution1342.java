package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/28
 * @time 9:43 PM
 */
public class Solution1342 {
    Map<Integer,Integer> cached=new HashMap<>();
    public int numberOfSteps(int num) {

        if (cached.containsKey(num)){
            return  cached.get(num);
        }
        if (num==0){
            return 0;
        }
        if (num%2==0){
            int t= numberOfSteps(num/2)+1;
            cached.put(num,t);
            return t;
        }
        int t= numberOfSteps(num-1)+1;
        cached.put(num,t);
        return t;
    }

    public static void main(String[] args){
        Solution1342 solution1342=new Solution1342();
        int ans=solution1342.numberOfSteps(14);
        System.out.println(ans);
    }
}
