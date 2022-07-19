package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/21 20:35
 * @IDE IntelliJ IDEA
 * 字母异位词
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for (String s:strs) {
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String sort=String.valueOf(ch);
            if (!map.containsKey(sort)){
                map.put(sort, new ArrayList<>());
            }
            map.get(sort).add(s);
        }
        return  new ArrayList<>(map.values());
    }
}
