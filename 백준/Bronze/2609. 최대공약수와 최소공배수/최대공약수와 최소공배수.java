import java.util.Scanner;

/*
 * 
 * 
 * 
 * 
 * 
  	유클리드 호제법
  	
  	
  	큰수 		작은수	나눈나머지
	a	%	b	=	c

	나누어 떨어졌을 때 b값이 최대 공약수


	최소공배수 ->

	a * b = 최대공약수 * 최소공배수

	따라서 (a*b)/최대공약수 = 최소공배수


	b

	r

 * 
 * 
 */


public class Main {
	
	public static int GCD(int a,int b) {
		int ans = 1;
		
		while(true){
			ans = a % b;
			a = b;
			if(ans != 0)
				b = ans;
			else
				break;
		}
		
		
		return b;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a < b)
		{
			int tmp = a;
			a = b;
			b = tmp;
			
		}
		
		//최대공약수
		int common = GCD(a,b);
		
		System.out.println(common);
		
		//최소공배수
		int largest = (a *b)/common;
		
		System.out.println(largest);
	}

}
