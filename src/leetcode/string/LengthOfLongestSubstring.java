package leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Excalibur
 * @date 2022/3/27 20:31
 * @IDE IntelliJ IDEA
 */
public class LengthOfLongestSubstring {
    //用map
    public int lengthOfLongestSubstring(String s) {
        char[] ch=s.toCharArray();
        int max=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0,j=0; i <ch.length ; i++) {
            if(map.containsKey(ch[i])){
                j=Math.max(j, map.get(ch[i])+1);
            }
            map.put(ch[i],i);
            max=Math.max(max, i-j+1);
        }
        return max;
    }
    // 用队列
    public int lengthOfLongestSubString2(String s){
        //创建队列
        Queue<Character> queue = new LinkedList<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            while (queue.contains(c)) {
                //如果有重复的，队头出队，直到没有重复的为止
                queue.poll();
            }
            //添加到队尾
            queue.add(c);
            //更新max
            max = Math.max(max, queue.size());
        }
        return max;
    }
}
