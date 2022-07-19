package base;

import java.util.Scanner;

public class Class03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        double a= Math.PI * Math.pow(r,2);
        System.out.printf("%.7f",a);
    }

}
