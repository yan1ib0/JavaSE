package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 14:56
 */
public class Main9 {
    public static void main(String[] args) {
        int num = 10000;
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        while (num<1000000) {
            char[] c = Integer.toString(num).toCharArray();
            boolean is = true;
            int sum1 = 0;
            for (int i = 0; i < c.length; i++) {
                sum1 += Integer.parseInt(String.valueOf(c[i]));
                if (c[i] != c[c.length - 1 - i]) {
                    is = false;
                    break;
                }
            }
//            System.out.println(sum1);
            if (is && sum == sum1) {
                System.out.println(num);
            }
            num++;
        }
    }
}
