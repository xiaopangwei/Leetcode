package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 4:29 PM
 */
public class Solution277 {
    public int findCelebrity(int n) {
        int start=0;
        for (int i=1;i<n;i++){
            if (knows(start,i)){
                start=i;
            }else{
                //start保持原样
            }
        }


        // 上面for循环结束后，ans 所代表的人不一定是明星
        // 只能代表有人（注意：不是所有人）认识他(ans)
        // 所以下面的for循环要做两个判断，确保ans不认识任何人，同时任何人都认识ans
        for (int i=0;i<n;i++){
            if (start==i){
                continue;
            }
            if (knows(start,i)||!knows(i,start)){
                return -1;
            }
        }
        return start;
    }

    public boolean knows(int a, int b){
        return true;
    }
}
