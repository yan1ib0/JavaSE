package leetcode.string;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 21:41
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(new IsPalindrome()
                .isPalindrome(""));
    }
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]","");
        s=s.toLowerCase();
        String rev = new StringBuffer(s).reverse().toString();
        return s.equals(rev);
    }
}
