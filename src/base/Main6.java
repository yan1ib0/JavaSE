package base;

import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 13:54
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int depth=sc.nextInt();
        int[][] arr=new int[depth][depth];
        for(int i=0;i<depth;i++){
            if(i==0){
                arr[0][0]=1;
                continue;
            }
            arr[i][0]=1;
            for(int j=1;j<=i;j++){

                arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
            }
        }
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr[i].length;j++){
                if(arr[i][j]!=0)
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
