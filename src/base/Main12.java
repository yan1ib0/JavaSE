package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 20:00
 */
public class Main12 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String string=sc.next();
            // 处理进制转换
            char[] number=string.toCharArray();
            long num=0;
            int pos=0;
            for(int j=number.length-1;j>=0;j--){
                num+=(number[j]>57?number[j]-55:number[j]-48)*Math.pow(16,pos);
                pos++;
            }
            System.out.println(num);


    }
}
