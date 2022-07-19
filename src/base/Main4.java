package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 13:25
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int max = 0;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < l; i++) {
            int next = sc.nextInt();

            if(next>max||i==0)
                max=next;
            if(next<min||i==0)
                min=next;
            sum+=next;
        }
        System.out.println(max+"\n"+min+"\n"+sum);
    }
}
