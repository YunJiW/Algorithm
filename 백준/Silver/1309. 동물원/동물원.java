import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main{
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for(int index = 2;index <=N;index++)
		{
			dp[index][0] = dp[index-1][0] + dp[index-1][1] + dp[index-1][2];
			dp[index][1] = dp[index-1][0] + dp[index-1][2];
			dp[index][2] = dp[index-1][0] + dp[index-1][1];
			
			dp[index][0] %= 9901;
			dp[index][1] %= 9901;
			dp[index][2] %= 9901;
		}
		
		int sum = 0;
		
		sum += dp[N][0] + dp[N][1] + dp[N][2];
		
		System.out.println(sum % 9901);
		
		
		
	}

}
