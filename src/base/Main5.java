package base;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Excalibur_yan
 * @date 2022/1/2 13:39
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer, Integer> map=new HashMap<>();
        int l=sc.nextInt();
        //简单 占内存
//        for(int i=0;i<l;i++){
//            map.putIfAbsent(sc.nextInt(), i+1);
//        }
//        Integer num=map.getOrDefault(sc.nextInt(),-1);
//        System.out.println(num);
        //复杂 内存占用小
        int [] arr=new int[l];
        for(int i=0;i<l;i++){
            arr[i]=sc.nextInt();
        }
        int result=sc.nextInt();
        for(int i=0;i< arr.length;i++) {
            if (arr[i] == result) {
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(-1);
    }
}
