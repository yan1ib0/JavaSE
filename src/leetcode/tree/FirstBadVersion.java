package leetcode.tree;

/**
 * @author Excalibur
 * @date 2022/3/18 15:10
 * @IDE IntelliJ IDEA
 * 简简单单的二分
 */
public class FirstBadVersion {
    public int fbv=1702766719;

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(2126753390));
    }
    public int firstBadVersion(int n) {
        int start=1;
        int end=n;
        int mid;
        int res=1;
        while(start<=end){
            mid=start+(end+start)/2;
            if (isBadVersion(mid)){
                res=mid;
                end=mid-1;
            }else
                start=mid+1;
        }
        return  res;
    }

    private boolean isBadVersion(int n){
        return n >= fbv;
    }
}
