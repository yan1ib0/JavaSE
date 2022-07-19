package leetcode.string;

/**
 * @author Excalibur
 * @date 2022/3/13 13:00
 * @IDE IntelliJ IDEA
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(11));
        System.out.println("11131221133112132113212221");
    }
    public String countAndSay(int n) {
        if(n==1) return "1";
        String s=countAndSay(n-1);
        int start=0;
        int i=0;
        StringBuilder res=new StringBuilder();
        while(i<s.length()){
            if (i==s.length()-1||s.charAt(i)!=s.charAt(i+1)){
                res.append(i-start+1);
                start=i+1;
                res.append(s.charAt(i));
            }
            i++;
        }
    return res.toString();
    }
}
