package leetcode.array;

/**
 * @author Excalibur_yan
 * @date 2022/2/22 16:22
 */
public class Rotate {
    public static void main(String[] args) {
        new Rotate().containsDuplicate(new int[]{1,2,3,4});
    }
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k%=len;
        int index=0;
        int pre=nums[0];
        int next;
        int i=0;
        boolean[] visited = new boolean[len];
        if (visited[index]) {
            index = (index + 1) % len;
            pre = nums[index];
            i--;
        }
        while(i<len){
            visited[index] = true;
            index=(index+k)%len;
            next=nums[index];
            nums[index]=pre;
            pre=next;
            i++;
        }
    }
    public boolean containsDuplicate(int[] nums) {
        int num=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i!=0&&num==nums[i])
                num+=nums[i];
            else
                num^=nums[i];
        }
        return num!=sum;
    }
}
