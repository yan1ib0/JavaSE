package base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/3 20:06
 */
public class Main13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] arr= new int[len];
        for(int i=0;i<len;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
