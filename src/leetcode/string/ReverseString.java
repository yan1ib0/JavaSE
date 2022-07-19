package leetcode.string;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 14:04
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int len= s.length;
        for (int i = 0; i <len/2 ; i++) {
            s[i]^=s[len-1-i];
            s[len-1-i]^=s[i];
            s[i]^=s[len-1-i];
        }
    }
}
