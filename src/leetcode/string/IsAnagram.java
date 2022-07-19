package leetcode.string;

import java.util.Arrays;

/**
 * @author Excalibur_yan
 * @date 2022/3/11 15:26
 */
public class IsAnagram {

    public static void main(String[] args) {
        new IsAnagram().isAnagram("rat", "car");
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
//        HashMap<Character, Integer> maps=new HashMap<>();
//        HashMap<Character,  Integer> mapt=new HashMap<>();

//        for (int i = 0; i <s.length() ; i++) {
//            maps.put(s.charAt(i),maps.get(s.charAt(i))==null?1:maps.get(s.charAt(i))+1);
//            mapt.put(t.charAt(i),mapt.get(t.charAt(i))==null?1:mapt.get(t.charAt(i))+1);
//        }
//        if (maps.size()!=mapt.size())return false;
//        AtomicBoolean f= new AtomicBoolean(true);
//        maps.forEach((character, integer) ->{
//            if(!mapt.containsKey(character) || !Objects.equals(mapt.get(character), integer)){
//                f.set(false);
//            }
//        });
//        return f.get();
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        //对两个字符串中的字符进行排序
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);

    }
}
