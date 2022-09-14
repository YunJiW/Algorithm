
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		
		dp[1] = 1;
		if(N >=2)
			dp[2] = 2;
		
		for(int index = 3; index<=N;index++)
		{
			dp[index] = (dp[index-1]+dp[index-2])%15746;
		}
		
		
		System.out.print(dp[N]);
		
		
	}
}
