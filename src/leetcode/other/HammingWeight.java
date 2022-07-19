package leetcode.other;

/**
 * @author Excalibur
 * @date 2022/3/20 13:46
 * @IDE IntelliJ IDEA
 * 巧妙的位运算
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count=0;
        for (int i = 0; i <32 ; i++) {
            if(((n>>>1)&1)==1){
                count++;
            }
        }
        return count;
    }
}
