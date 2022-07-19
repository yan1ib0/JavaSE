package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 20:14
 */
public class Main14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int h=0;
        int m=0;
        int s=0;
        if(num>=60*60){
            h=num/(60*60);
            num%=60*60;
        }
        if(num>=60){
            m=num/60;
            num%=60;
        }
        s=num;
        System.out.printf("%d:%d:%d",h,m,s);

    }
}
