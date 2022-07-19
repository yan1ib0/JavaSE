package leetcode.other;

/**
 * @author Excalibur
 * @date 2022/3/20 13:50
 * @IDE IntelliJ IDEA
 *  按位异或 的count
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
