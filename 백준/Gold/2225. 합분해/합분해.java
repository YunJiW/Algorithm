import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//합 
		int N = Integer.parseInt(st.nextToken());
		//개수
		int K = Integer.parseInt(st.nextToken());
		
		
		int dp[][] = new int[N+1][K+1];
		
		for(int index =1; index <=K;index++)
		{
			dp[0][index] = 1;
		}
		for(int index =0 ;index <=N;index++) {
			dp[index][1] = 1;
		}
		
		for(int row =1; row <=N;row++) {
			for(int col = 2; col <=K;col++) {
				dp[row][col] = (dp[row-1][col] + dp[row][col-1]) %1000000000;
			}
		}
		
		System.out.println(dp[N][K]%1000000000);
	}

}
