package leetcode.p2021m07.p20210701;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/2
 * @time 4:13 PM
 */
public class Solution679 {
    public boolean judgePoint24(int[] cards) {
        boolean[] visited=new boolean[cards.length];
//        if (cards[0]==8 && cards[1]==1 && cards[2]==6 && cards[3]==6){
//            return true;
//        }
//        if (cards[0]==3 && cards[1]==4 && cards[2]==6 && cards[3]==7){
//            return false;
//        }
        return dfs(0,visited,cards,0);

    }

    private boolean dfs(double prevValue,boolean[] visited,final int[] cards,int index) {
        if (index == 4) {
            if (Math.abs(prevValue - 24) < 0.001) {
                return true;
            } else {
//                System.out.println("失败:" + prevValue);
                return false;
            }
        }
        System.out.println(prevValue+" "+Arrays.toString(visited));
        for (int i = 0; i < cards.length;i++){

            for (int idx1 = 0; idx1 < cards.length; idx1++) {
                for (int idx2 = 0; idx2 < cards.length; idx2++) {
                    if (idx1 != idx2 && !visited[idx1] && !visited[idx2]) {
                        System.out.println("双选择 " + cards[idx1] + " " + cards[idx2] + " preVal=>" + prevValue + " " + cards[idx1] + " " + cards[idx2]);
                        visited[idx1] = true;
                        visited[idx2] = true;

                        if (index==0){
                            boolean flag1 = dfs(prevValue + (cards[idx1] + cards[idx2]), visited, cards, index + 2);
                            if (flag1) {
                                return true;
                            }
                            boolean flag2 = dfs(prevValue + (cards[idx1] - cards[idx2]), visited, cards, index + 2);
                            if (flag2) {
                                return true;
                            }

                            boolean flag3 = dfs(prevValue + (cards[idx1] * cards[idx2]), visited, cards, index + 2);
                            if (flag3) {
                                return true;
                            }

                            boolean flag4 = dfs(prevValue + (cards[idx1] * 1.0 / cards[idx2]), visited, cards, index + 2);
                            if (flag4) {
                                return true;
                            }
                        }else {
                            boolean flag1 = dfs(prevValue + (cards[idx1] + cards[idx2]), visited, cards, index + 2);
                            if (flag1) {
                                return true;
                            }
                            boolean flag2 = dfs(prevValue + (cards[idx1] - cards[idx2]), visited, cards, index + 2);
                            if (flag2) {
                                return true;
                            }

                            boolean flag3 = dfs(prevValue + (cards[idx1] * cards[idx2]), visited, cards, index + 2);
                            if (flag3) {
                                return true;
                            }

                            boolean flag4 = dfs(prevValue + (cards[idx1] * 1.0 / cards[idx2]), visited, cards, index + 2);
                            if (flag4) {
                                return true;
                            }
                            boolean flag5 = dfs(prevValue - (cards[idx1] + cards[idx2]), visited, cards, index + 2);
                            if (flag5) {
                                return true;
                            }
                            boolean flag6 = dfs(prevValue - (cards[idx1] - cards[idx2]), visited, cards, index + 2);
                            if (flag6) {
                                return true;
                            }

                            boolean flag7 = dfs(prevValue - (cards[idx1] * cards[idx2]), visited, cards, index + 2);
                            if (flag7) {
                                return true;
                            }
                            boolean flag8 = dfs(prevValue - (cards[idx1] * 1.0 / cards[idx2]), visited, cards, index + 2);
                            if (flag8) {
                                return true;
                            }

                            boolean flag9 = dfs(prevValue * (cards[idx1] + cards[idx2]), visited, cards, index + 2);
                            if (flag9) {
                                return true;
                            }

                            boolean flag10 = dfs(prevValue * (cards[idx1] - cards[idx2]), visited, cards, index + 2);
                            if (flag10) {
                                return true;
                            }

                            boolean flag11 = dfs(prevValue * (cards[idx1] * cards[idx2]), visited, cards, index + 2);
                            if (flag11) {
                                return true;
                            }
                            boolean flag12 = dfs(prevValue * (cards[idx1] * 1.0 / cards[idx2]), visited, cards, index + 2);
                            if (flag12) {
                                return true;
                            }
                            boolean flag13 = dfs(prevValue / (cards[idx1] + cards[idx2]), visited, cards, index + 2);
                            if (flag13) {
                                return true;
                            }
                            boolean flag14 = dfs(prevValue / (cards[idx1] - cards[idx2]), visited, cards, index + 2);
                            if (flag14) {
                                return true;
                            }
                            boolean flag15 = dfs(prevValue / (cards[idx1] * cards[idx2]), visited, cards, index + 2);
                            if (flag15) {
                                return true;
                            }
                            boolean flag16 = dfs(prevValue / (cards[idx1] * 1.0 / cards[idx2]), visited, cards, index + 2);
                            if (flag16) {
                                return true;
                            }
                        }
                        System.out.println("双删除" + cards[idx1] + " " + cards[idx2] + " =>" + prevValue + " " + cards[i]);
                        visited[idx1] = false;
                        visited[idx2] = false;
                    }//end else
                }//end if
            }//end for 1

            if (!visited[i]) {

                visited[i] = true;


                System.out.println("单选择 " + cards[i] + " " + " =>" + prevValue + cards[i]);
                boolean flag1 = dfs(prevValue + cards[i], visited, cards, index + 1);
                if (flag1) {
                    return true;
                }


                boolean flag2 = dfs(prevValue - cards[i], visited, cards, index + 1);
                if (flag2) {
                    return true;
                }



                boolean flag3 = dfs(prevValue * cards[i], visited, cards, index + 1);
                if (flag3) {
                    return true;
                }



                boolean flag4 = dfs(prevValue * 1.0 / cards[i], visited, cards, index + 1);
                if (flag4) {
                    return true;
                }


                System.out.println("删除" + cards[i] + " " + " =>" + prevValue + cards[i]);
                visited[i] = false;
            }

        }//end for
        return false;
    }

    public static void main(String[] args){
        Solution679 solution679=new Solution679();
        boolean flag=solution679.judgePoint24(new int[]{3,4,6,7});
        System.out.println(flag);
    }




}
