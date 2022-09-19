import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		int[] dp = new int[N+1];
		
		int[] wine = new int[N+1];
		
		
		for(int index = 1;index<=N;index++)
		{
			wine[index] = Integer.parseInt(br.readLine());
		}
		
		
		dp[1] = wine[1];
		if(N >=2)
		{
			dp[2] = dp[1] + wine[2];
		}
		
		for(int index = 3; index <=N;index++)
		{
			dp[index] = Math.max(dp[index-3] +wine[index]+wine[index-1],Math.max(dp[index-1],dp[index-2]+wine[index]));
		}
		
		System.out.println(dp[N]);
	}
}
