package leetcode.dp;

/**
 * @author Excalibur
 * @date 2022/3/23 15:21
 * @IDE IntelliJ IDEA
 */
public class NumDistinct {
    public int numDistinct(String s, String t) {
        //dp 为前s前i和t前j的串匹配的个数;
        int[][] dp=new int[t.length()+1][s.length()+1];
        //长度为0 即空串 空串是所以串的子串
        for (int i = 0; i <s.toCharArray().length ; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <=s.length() ; j++) {
                //状态转移方程
                //前面i-1串的结果+i串的结果 就是所有结果 这个结果是递归的
                if (t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
