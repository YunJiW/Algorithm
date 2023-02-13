import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	
	//최대 100개의 수까지 가능하고 값은 0~20까지이기때문에 가능.
	static long dp[][] = new long[100][21];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int number[] = new int[N];
		for(int index = 0; index < N;index++) {
			number[index] =Integer.parseInt(st.nextToken());
		}
		
		dp[0][number[0]] = 1;
		for(int index = 1; index<N-1;index++) {
			for(int check = 0; check<=20; check++) {
				if(dp[index-1][check] != 0) {
					int plus = check +number[index] ;
					int minus = check -number[index];
					
					
					if(plus >= 0 && plus <= 20) {
						dp[index][plus] += dp[index-1][check];
					}
					if(minus >=0 && minus <= 20) {
						dp[index][minus] +=dp[index-1][check];
					}
				}
			}
		}
		
		System.out.println(dp[N-2][number[N-1]]);
		
		
		
	}

}
