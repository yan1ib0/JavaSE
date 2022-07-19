package base;

import java.util.List;
import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/2/21 12:02
 * @apiNote 交换两个相邻的字符串  成功 输出最少交换次数  否则输出impossible
 */
public class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();
        int flag=0;
        int count = 0;
        for (char c:str.toCharArray()) {
            flag^=c;
        }
        int index;
        if(flag>=(int)'a' &&flag<=(int)'z'){
            char[] b=str.toCharArray();
            int mix=str.indexOf(flag);
            for (int i = 0; i <str.toCharArray().length ; i++) {
                if(b[i]==flag){
                    mix=Math.min(mix, i);
                }
            }
            index=mix;
            count+=Math.abs(len/2-mix);
        }

        len--;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if ((chars[i] ^ chars[len - i - 1]) != 0)
                for (int j = len - i - 1; j > i; j--) {
                    if (chars[i] == chars[j]) {
                        for (int k = j; k < len - i - 1; k++) {
                            char temp = chars[k + 1];
                            chars[k + 1] = chars[k];
                            chars[k] = temp;
                            count++;
                        }
                        break;
                    }
                }

        }
        System.out.println(count);
    }

}
