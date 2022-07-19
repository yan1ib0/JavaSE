package base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 20:42
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = sc.nextInt();
        int high = sc.nextInt();
        List<Integer> sushu = new ArrayList<>();
        sushu.add(2);
        for (int i = 2; i <= high; i++) {
            if (isp(i)) {
                sushu.add(i);
            }
        }
        sushu.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = low; i <= high; i++) {
            if (sushu.contains(i)) {
                System.out.println(i + "=" + i);
                continue;
            }
            StringBuilder msg = new StringBuilder(i + "=");
            int b=i;
            while (!sushu.contains(b)) {
                for(Integer  num:sushu){
                    if(b%num==0){
                        b/=num;
                        msg.append(num);
                        break;
                    }
                }
                msg.append("*");
            }
            msg.append(sushu.get(sushu.indexOf(b)));
            System.out.println(msg);

        }
    }

    public static boolean isp(int n) {
        int i;
        if (n % 2 == 0) return false;
        for (i = 3; i <= sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }


}
