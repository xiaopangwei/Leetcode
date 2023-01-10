package leetcode.p2023m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/7
 * @time 10:27 PM
 */
public class PurchaseSystem {

    int[] remained;
    int   remainedGold;

    public PurchaseSystem(int[] remained, int remainedGold) {
        this.remained = remained;
        this.remainedGold = remainedGold;
    }

    public boolean canPurchase(int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            if (remained[i] < cost[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canPurchase2(int[] cost) {
        int[] tempRemained     = remained.clone();
        int   tempRemainedGold = remainedGold;

        for (int i = 0; i < cost.length; i++) {
            if (tempRemained[i] + tempRemainedGold < cost[i]) {
                return false;
            }
            if (tempRemained[i] >= cost[i]) {
                tempRemained[i] -= cost[i];
            } else {
                tempRemained[i] = 0;
                remainedGold -= (cost[i] - tempRemained[i]);
            }
        }
        return true;
    }

    public void purchase(int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            remained[i] -= cost[i];
        }
    }



    public void purchase2(int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            if (remained[i] >= cost[i]) {
                remained[i] -= cost[i];
            } else {
                remained[i] = 0;
                remainedGold -= (cost[i] - remained[i]);
            }
        }
    }


}
