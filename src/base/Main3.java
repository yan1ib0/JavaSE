package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 12:43
 * 利用字母可以组成一些美丽的图形，下面给出了一个例子：
 * <p>
 * ABCDEFG
 * <p>
 * BABCDEF
 * <p>
 * CBABCDE
 * <p>
 * DCBABCD
 * <p>
 * EDCBABC
 * <p>
 * 这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char c = 'A';
        char nowout;
        for (int i = 0; i < n; i++) {
            int count = 0;
            nowout= (char) (c+i);
            while (nowout > c&&count < m) {
                count++;
                System.out.print(nowout--);
            }
            while (count < m) {
                count++;
                System.out.print(nowout++);
            }
            System.out.println();
        }
    }
}
