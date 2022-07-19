package leetcode.array;

/**
 * @author Excalibur_yan
 * @date 2022/3/8 12:34
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index=digits.length;
        for (int i= digits.length-1;i>=0;i--) {
            if (digits[i]<9){
                digits[i]=0;
                digits[i]++;
                break;
            }else if(digits[i]==9){
                digits[i]=0;
            }

            if (i==0){
               int[] a=new int[digits.length+1];
               a[0]=1;
               return a;
            }
        }
        return digits;
    }
}
