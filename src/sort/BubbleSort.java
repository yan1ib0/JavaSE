package sort;

/**
 * 冒泡是经典交换排序 时间复杂度为n^2
 */
public class BubbleSort {
    int [] arr=new int[]{2,9,1,4,7,3,6};
    public static void main(String[] args) {
        new BubbleSort().sort();
    }

    private void sort(){
        for(int i=0;i<=arr.length;i++){
            int temp;
            for(int j=1;j<arr.length;j++){
                if(arr[j-1]>arr[j]){
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        for(int a:arr){
            System.out.print(a+",");
        }

    }
}
