package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 19:23
 */
public class Main11_未解决_太阴间 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        String[] strings=new String[i];
        for(int j=0;j<i;j++){
            strings[j]=sc.next();
        }
        for(String str:strings){
            // 处理进制转换
            char[] number=str.toCharArray();
            int num=0;
            int pos=0;
            for(int j=number.length-1;j>=0;j--){
                num+=(number[j]>57?number[j]-55:number[j]-48)*Math.pow(16,pos);
                pos++;
            }
            System.out.println(Integer.toOctalString(num));
        }

    }

}
