package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 10:48 AM
 */
public class Solution670 {
    public int maximumSwap(int num) {

        int[]  lastPos = new int[10];
        char[] arr     = String.valueOf(num).toCharArray();

        for (int i = 0; i < arr.length; i++) {
            lastPos[arr[i] - '0'] = i;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 9; j >= 1; j--) {
                if (lastPos[j] > i && j > arr[i]-'0') {
                    //i lastPos[j]
                    char temp = arr[i];
                    arr[i] = arr[lastPos[j]];
                    arr[lastPos[j]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        Solution670 solution670=new Solution670();
        int ans=solution670.maximumSwap(9973);
        System.out.println(ans);
    }
}
