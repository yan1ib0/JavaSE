package base.recursion;

import java.util.Scanner;

/**
 * @author Excalibur
 * @date 2022/3/22 17:38
 * @IDE IntelliJ IDEA
 */
public class _T62 {
    private static String[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //剪枝 免得重复
        //先求An
        ans = new String[n];
        an(n);
        //再求Sn
        System.out.println(sn(n, 1));
    }

    //递归函数 // 公式 An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
    private static void an(int n) {
        if (n < 1) return;
        if(n==1) {
            ans[n-1]="sin(1)";
            return;
        }
        StringBuilder sb = new StringBuilder("");
        if (n % 2 == 0) {
            if (ans[n - 2] == null)
                an(n - 1);
            sb.append(ans[n - 2]);
            sb.insert(sb.length() - n + 1, "+sin("+n+")");
            ans[n-1]=sb.toString();
        } else {
            if (ans[n - 2] == null)
                an(n - 1);
            sb.append(ans[n - 2]);
            sb.insert(sb.length() - n + 1, "-sin("+n+")");
            ans[n-1]=sb.toString();
        }
    }

    // 公式 Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
    private static String sn(int n, int s) {
        if (n < 1) return "";
        if (n == 1) return "sin(1)+" +s;
        StringBuilder sb = new StringBuilder("");
        sb.append("(");
        sb.append(sn(n - 1, s + 1));
        sb.append(")");
        sb.append(ans[n - 1]);
        sb.append("+");
        sb.append(s);
        return sb.toString();
    }
}
