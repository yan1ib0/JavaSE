package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 21:26
 */
public class Main17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] arr = new int[a][a];
        int[][] arr1 =new int[a][a];
        //input
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                arr[i][j] = sc.nextInt();
                arr1[i][j] = arr[i][j];
            }
        }
        int[][] result = new int[a][a];
        if (b == 0) {
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    arr[i][j] = (i == j ? 1 : 0);
                }
            }
        }
        while (b >= 2)//矩阵2次幂以上需要做运算
        {
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    int k = a;
                    while (k > 0) {
                        result[i][j] += arr[i][k - 1] * arr1[k - 1][j];
                        k--;
                    }
                }
            }
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    arr[i][j] = result[i][j];
                    result[i][j] = 0;
                }
            }
            b--;
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
