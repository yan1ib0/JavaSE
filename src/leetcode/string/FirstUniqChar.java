package leetcode.string;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 15:08
 * @apiNote  第一个和最后一个索引一致 那么肯定是唯一的
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        for (int i = 0; i <s.length() ; i++) {
            char a=s.charAt(i);
            if (s.indexOf(a)==s.lastIndexOf(a))
                return i;
        }
        return -1;
    }
}
