package leetcode.other;

import java.util.Stack;

/**
 * @author Excalibur
 * @date 2022/3/20 14:30
 * @IDE IntelliJ IDEA
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars=s.toCharArray();
        for (char c:chars) {
            if (c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else if(stack.isEmpty()||stack.pop()!=c)
                return false;
        }
        return stack.isEmpty();
    }
}
