package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Excalibur
 * @date 2022/3/19 14:16
 * @IDE IntelliJ IDEA
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        Integer index=1;
        while(res.size()<n){
            if (index%15==0)res.add("FizzBuzz");
            else if (index%3==0)
                res.add("Fizz");
            else if(index%5==0)
                res.add("Buzz");
            else
            res.add(index.toString());
          index++;
        }
        return res;
    }
}
