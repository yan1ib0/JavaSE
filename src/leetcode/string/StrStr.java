package leetcode.string;

import java.util.Objects;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 22:26
 */
public class StrStr {
    public static void main(String[] args) {
        new StrStr().strStr("mississippi",
                "issip");
    }
    public int strStr(String haystack, String needle) {
        int len1=haystack.length();
        int len2=needle.length();
        int i=0,j=0;
        while (true){
            if (j>len2)
                return i-needle.length();
            if (i>=len1)
                return -1;
            if (Objects.equals(haystack.charAt(i),needle.charAt(j)))
                j++;
            else if(j!=0){
                i-=(j+1);
                j=0;
            }
            i++;
        }
    }
}
