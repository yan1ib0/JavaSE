package leetcode.string;

/**
 * @author Excalibur
 * @date 2022/3/27 20:48
 * @IDE IntelliJ IDEA
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int max=1;
        int start=0;
        int len=s.length();
        boolean[][] dp=new boolean[len][len];
        //left right指针
        if (s.length()<2)return s;
        for(int i=1;i<len;i++){
            for (int j = 0; j <i ; j++) {
                if (s.charAt(j) != s.charAt(i))
                    continue;
                if (i == j)
                    dp[j][i] = true;
                else if (i - j <= 2)
                    //类似于"aa"和"aba"，也是回文子串
                    dp[j][i] = true;
                else
                    //类似于"a******a"，要判断他是否是回文子串，只需要
                    //判断"******"是否是回文子串即可
                    dp[j][i] = dp[j + 1][i - 1];

                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    start = j;
                }

            }

        }
        return s.substring(start, max+start);
    }
}
