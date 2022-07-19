package base.dp;

import java.util.Scanner;

/**
 * @author Excalibur
 * @date 2022/3/23 20:18
 * @IDE IntelliJ IDEA
 */
public class _T3000 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[][] nums=new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <len ; j++) {
                nums[i][j]= sc.nextInt();
            }
        }
        int l=0;
        int up=0;
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j <len ; j++) {
                up=i<=0?0:nums[i-1][j];
                l=j<=0?0:nums[i][j-1];
                nums[i][j]=Math.max(up, l)+nums[i][j];
            }
        }
        System.out.println(nums[len-1][len-1]);
    }
}
