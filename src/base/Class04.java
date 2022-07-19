package base;
import java.util.Scanner;

public class Class04 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        System.out.println(fibo(i)[i-1]);

    }
    private static int[] fibo(int n){
//栈溢出
//        if(i<3) return 1;
//        return fibo(i-1)+fibo(i-2);
        if(n<3)return new int[]{1,1};
        int [] f=new int[n];
         f[0]=1;
         f[1]=1;
         for(int i=2;i<f.length;i++){
             f[i]=f[i-1]+f[i-2];
             if(f[i]>10007) f[i]-=10007;
         }
         return f;
    }
}
