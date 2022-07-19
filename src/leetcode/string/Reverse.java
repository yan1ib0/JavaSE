package leetcode.string;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 14:12
 * 整数反转
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(new Reverse().reverse(123));
    }
    public int reverse(int x) {
        StringBuilder str = new StringBuilder(String.valueOf(x));
        boolean flag = false;
        if (str.toString().indexOf('-') != -1) {
            str = new StringBuilder(str.substring(1));
            flag = true;
        }
        int[] target = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            String[] strings = str.toString().split("");
            target[i]= Integer.parseInt(strings[i]);
        }
        reverseString(target);
        str = new StringBuilder();
        for (int i:
             target) {
            str.append(i);
        }
        str = new StringBuilder(str.toString().replace("0", " "));
        str = new StringBuilder(str.toString().trim());
        str = new StringBuilder(str.toString().replace(" ", "0"));
        if (flag)
            str.insert(0, "-");
        int res=0;
        try{
             res=Integer.parseInt(str.toString());
        }catch (NumberFormatException e){
            return 0;
        }


        return res;
    }

    public void reverseString(int[] s) {
        int len = s.length;
        int temp;
        for (int i = 0; i < len / 2; i++) {
            temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }
}
