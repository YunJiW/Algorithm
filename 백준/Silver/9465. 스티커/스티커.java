
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1; test_case <= T;test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int Map[][] = new int[2][N+1];
			int dp[][] = new int[2][N+1];
		
			for(int row = 0; row < 2; row++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int col = 1;col <= N;col++)
				{
					Map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][1] = Map[0][1];
			dp[1][1] = Map[1][1];
			
			for(int index = 2; index <=N;index++)
			{
				dp[0][index] = Math.max(dp[1][index-1],dp[1][index-2]) + Map[0][index];
				dp[1][index] = Math.max(dp[0][index-1],dp[0][index-2]) + Map[1][index];
			}
			
			System.out.println(Math.max(dp[0][N],dp[1][N]));
		}
	}

}
