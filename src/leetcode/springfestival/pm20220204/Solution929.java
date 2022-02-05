package leetcode.springfestival.pm20220204;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 11:47 PM
 */
public class Solution929 {
    public int numUniqueEmails(String[] emails) {

        Set<String> sets = new HashSet<>();
        for (String item : emails) {
            String[] array = item.split("@");
            String localName=process(array[0]);
            sets.add(localName+"@"+array[1]);
        }

        return sets.size();
    }


    private String process(String local) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < local.length(); i++) {
            char ch = local.charAt(i);
            if (ch == '.') {

            } else if (ch == '+') {
                break;
            } else {
                builder.append(local.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        Solution929 solution929=new Solution929();
        int ans=solution929.numUniqueEmails(new String[]{"a@leetcode.com","b@leetcode.com","c@leetcode.com"});
        System.out.println(ans);
    }
}
