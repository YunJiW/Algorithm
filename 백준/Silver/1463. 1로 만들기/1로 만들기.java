import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		
		dp[1] = 0;
		
		
		for(int index= 2; index<= N;index++)
		{
			dp[index] = dp[index-1] + 1;
			
			if(index % 2 == 0)
			{
				dp[index] = Math.min(dp[index],dp[index/2] + 1 );
			}
			if(index % 3 == 0)
			{
				dp[index] = Math.min(dp[index], dp[index/3] +1);
			}
			
		}
		System.out.println(dp[N]);
	}
}
