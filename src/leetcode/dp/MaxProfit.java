package leetcode.dp;

/**
 * @author Excalibur
 * @date 2022/3/18 17:48
 * @IDE IntelliJ IDEA
 *  买股票
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        //判空
        if (prices == null || prices.length == 0)
            return 0;
        //状态保存 1是持股的收益 0是未持股的收益
//        int[][] dp=new int[prices.length][2];
//        dp[0][1]=-prices[0];
        // 空间复杂度 优化
        int nohold=0;
        int hold=-prices[0];
        for (int i = 1; i <prices.length ; i++) {
            nohold=Math.max(nohold,hold+prices[i]);
            hold=Math.max(hold,-prices[i]);
        }
        return nohold;
    }
}
