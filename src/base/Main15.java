package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 20:31
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        if (str1.length() == str2.length()) {
            if (str2.equals(str1)) {
                System.out.println(2);
                return;
            }
            str2 = str2.toLowerCase();
            str1 = str1.toLowerCase();
            if (str2.equals(str1)) {
                System.out.println(3);
                return;
            }
            System.out.println(4);

        } else
            System.out.println(1);
    }

}
