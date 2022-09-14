import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
//nCr = n-1Cr-1 + n-1Cr
public class Main {
	static int[][] dp;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][N+1];
		
		
		for(int index = 1 ; index <=N;index++)
		{
			dp[index][index] = 1;
			dp[index][0] = 1;
		}
		
		
		for(int index =2; index <=N;index++)
		{
			for(int j =1 ; j < index;j++)
			{
				dp[index][j] = (dp[index-1][j-1] + dp[index-1][j])%10007;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
