import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
public class Main {
	
	static int Max = Integer.MIN_VALUE;
	
	
	static int N;
	static int K;
	
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int W[] = new int[N+1];
		int V[] = new int[N+1];
		
		int dp[][] = new int[N+1][K+1];
		
		
		for(int index =1 ;index <= N;index++)
		{
			st = new StringTokenizer(br.readLine());
			
			W[index] = Integer.parseInt(st.nextToken());
			V[index] = Integer.parseInt(st.nextToken());
			
		}
		
		for(int i=1;i<=N;i++) {
			for(int j =1;j<=K;j++)
			{
				if(W[i]>j) {
					dp[i][j] = dp[i-1][j];
				}
				
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j - W[i]] + V[i]);
				}
			}
		}
		
		
		
		System.out.println(dp[N][K]);
	}


}
 