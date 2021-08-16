package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 11:13 PM
 */
public class Solution412 {
    public List<String> fizzBuzz(int n) {

        List<String> ans=new ArrayList<>();
        for (int i=0;i<=n;i++){
            if (i%15==0){
                ans.add("FizzBuzz");
            }else if (i%3==0){
                ans.add("Fizz");
            }else if (i%5==0){
                ans.add("Buzz");
            }else {
                ans.add(String.valueOf(n));
            }
        }
        return ans;
    }
}
