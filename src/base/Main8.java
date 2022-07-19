package base;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 14:50
 */
public class Main8 {
    public static void main(String[] args) {
        int num =1000;
        while (num<10000){
            char[] chars=Integer.toString(num).toCharArray();
            if(chars[0]==chars[3]&&chars[1]==chars[2]){
                System.out.println(num);
            }
            num++;
        }
    }
}
