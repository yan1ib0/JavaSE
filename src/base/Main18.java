package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/4 16:50
 */
public class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1,y1,x2,y2;
        x1=sc.nextDouble();
        y1=sc.nextDouble();
        x2=sc.nextDouble();
        y2=sc.nextDouble();
        double x3,y3,x4,y4;
        x3=sc.nextDouble();
        y3=sc.nextDouble();
        x4=sc.nextDouble();
        y4=sc.nextDouble();
        double a1,b1,a2,b2;
        a1=Math.max(Math.min(x1,x2),Math.min(x3, x4));
        b1=Math.max(Math.min(y1,y2),Math.min(y3, y4));
        a2=Math.min(Math.max(x1,x2),Math.max(x3, x4));
        b2=Math.min(Math.max(y1,y2),Math.max(y3, y4));
        if (a1<a2&&b1<b2) {
            System.out.printf("%.2f",(a2-a1)*(b2-b1));
        } else
            System.out.println("0.00");
    }

}
