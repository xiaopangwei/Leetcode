package leetcode.p2022m06.day0628;

import common.ListNode;

import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/4
 * @time 11:17 PM
 */
public class Solution382 {
    ListNode head;
    public Solution382(ListNode head) {
        this.head=head;
    }

    public int getRandom() {
        int count=0;
        ListNode p=head;
        int ans=-1;
        while (p!=null){
            count++;
            int r=new Random().nextInt(count);
            if (r==0){
                ans=p.val;
            }
            p=p.next;
        }
        return ans;
    }
}
