package leetcode.math;

/**
 * @author Excalibur
 * @date 2022/3/19 14:40
 * @IDE IntelliJ IDEA
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if(n==1)return 0;
        if(n==2||n==3)return 1;
        if(n%6!=1&&n%6!=5)return 0;
        for(int i=5;i<=Math.sqrt(n);i+=6)
            if(n%i==0||n%(i+2)==0)return 0;
        return 1;
        /*  boolean[] arr = new boolean[n];
        int cnt = 0;
        for (int i = 2; i <n ; i++) {
            if (arr[i]) continue;
            cnt++;
            for(int j = i; j < n; j+=i) {
                arr[j] = true;
            }
        }
        return cnt;*/
    }
}
