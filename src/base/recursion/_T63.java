package base.recursion;

import java.util.Scanner;

/**
 * @author Excalibur
 * @date 2022/3/22 17:22
 * @IDE IntelliJ IDEA
 */
public class _T63 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(f(n));
//        System.out.println((int)'A');
    }

    private static String f(int n) {
        StringBuilder stringBuilder=new StringBuilder("");
        if (n==1) return stringBuilder.append((char)(64+n)).toString();
        stringBuilder.append(f(n-1));
        String s=stringBuilder.toString();
        stringBuilder.append((char)(64+n));
        stringBuilder.append(s);
        return stringBuilder.toString();
    }


}
