package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 12:16
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year= scanner.nextInt();
        if(year%4==0&&year%100!=0||year%400==0) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}
