package base.recursion;

import java.util.Scanner;

/**
 * @author Excalibur
 * @date 2022/3/22 18:49
 * @IDE IntelliJ IDEA
 */
public class _T1590 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        float w=0;
        float l=0;
        for (char c:s.toCharArray()) {
            if (c=='W')
                w++;
            else l++;
        }
        float v = w / (l + w);
        System.out.printf("%.2f",v);
    }
}
