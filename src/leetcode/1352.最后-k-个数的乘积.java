import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1352 lang=java
 *
 * [1352] 最后 K 个数的乘积
 */

// @lc code=start
class ProductOfNumbers {
    List<Integer> preIntegers;

    public ProductOfNumbers() {
        preIntegers = new ArrayList<>();
        preIntegers.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            preIntegers.clear();
            preIntegers.add(1);
            return;
        }
        int n=preIntegers.size();
        preIntegers.add(preIntegers.get(n-1)*num);
    }

    public int getProduct(int k) {
        int n = preIntegers.size();
        if (k > n - 1) {
            // 不足 k 个元素，是因为最后 k 个元素存在 0
            return 0;
        }

        return preIntegers.get(n-1)/preIntegers.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
// @lc code=end
