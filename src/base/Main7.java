package base;


/**
 * @author Excalibur_yan
 * @date 2022/1/2 14:14
 */
public class Main7 {
    public static void main(String[] args) {
        int num = 100;
        int[] arr=new int[3];
        while(num<1000){
            int i=num;
            arr[0]=i%10;i/=10;
            arr[1]=i%10;i/=10;
            arr[2]=i%10;i/=10;
            int sum= (int) (Math.pow(arr[0],3)+Math.pow(arr[1],3)+Math.pow(arr[2],3));
            if(sum==num)
                System.out.println(num);
            num++;
        }

    }
}
