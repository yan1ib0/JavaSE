package leetcode.string;

/**
 * @author Excalibur
 * @date 2022/3/13 13:43
 * @IDE IntelliJ IDEA
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String res=strs[0];
        for (int i = 1; i <strs.length ; i++) {
            for (int j = 0; j <res.length() ; j++) {
                    if (strs[i].startsWith(res.substring(0, res.length()-j))){
                        res=res.substring(0, res.length()-j);
                        break;
                    }
                    if (j==res.length()-1)
                        return "";
            }
        }
        return res;
    }
}
