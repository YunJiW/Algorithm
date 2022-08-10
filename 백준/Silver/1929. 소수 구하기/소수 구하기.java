//백준 1929
// M이상 N이하의 소수를 모두 출력하는 프로그램

// 에라토스테네스의 체

// " k=2 부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다"

/*  시간복잡도 (n^1/2)
	가장먼저 소수를 판별할 범위만큼 배열을 할당하여, 해당하는 값을 넣어주고 ,이후에 하나씩 지워가는 방법
	1. 배열을 생성하여 초기화
	2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
	3. 2부터 시작하여 남아있는 수를 모두 출력한다.



*/

import java.util.Scanner;

public class Main {
	public static boolean[] prime;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//M이상 N이하의 소수
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		//N이하기때문에 N까지 체크해야함.
		prime = new boolean[N+1];
		Prime_num();
		
		
		for(int i = M ; i<prime.length;i++)
		{
			if(prime[i] != true)
			{
				System.out.println(i);
			}
		}
		
		
	}
	// 소수가 아닐경우 true
	public static void Prime_num() {
		
		//0과 1은 소수가 아니기 때문에
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length);i++)
		{
			if(prime[i]) continue;
			for(int j = 2*i; j<prime.length;j += i)
			{
				 prime[j] = true;
			}
		}
	}


}
