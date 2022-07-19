package base.dc;

import java.util.Scanner;

public class FastPow {

	private static char[] res;

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int a=sc.nextInt();
		int n=sc.nextInt();
		int res=fastPow2(n,a);
		System.out.println(res);
		
	}
	// 位运算 快速幂 矩阵乘法 
	private static int fastPow2(int n, int a) {
		int ans=1;
		while(n!=0) {
			if((n&1)==1)
				ans=ans*a;
			a=a*a;
			n>>=1;
		}
		return ans;
	}
	//logN的复杂度
	private static int fastPow1(int n, int a) {
		if(n==1) return a;
		int temp =fastPow1(n/2,a);
		if(n%2==1)
			return temp*temp*a;
		return temp*temp;
	}

}
