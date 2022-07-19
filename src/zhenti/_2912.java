package zhenti;


import java.util.Scanner;
public class _2912 {
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long res=find(n);
		System.out.println(res);
	}
	void TestRun() throws Exception {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long res=find(n);
		System.out.println(res);
		System.out.println("Hello World!");
	}
	
	private static long find(int n) {
		if (n==1) return 1;
		long res=1;
		int[] row=new int[n+1];
		row[0]=1;
		for(int i=0;i<=n;i++) { //n+1 层 0 1 0 1 2
			for(int j=i;j>0;j--) {
				row[j]=row[j-1]+row[j];
				if(row[j]==n) return res;
				res++;
			}
			res++;
		}
		return res;
	}
}
