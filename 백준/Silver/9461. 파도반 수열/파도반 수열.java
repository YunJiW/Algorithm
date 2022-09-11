import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for(int testCase=0; testCase <T;testCase++)
		{
			int N = Integer.parseInt(br.readLine());
			long[] dp = new long[N + 4];
			dp[0] = 1;
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 2;
			dp[4] = 2;
			
			if(N >= 5)
			{
				for(int index =5; index <= N;index++)
				{
					dp[index] = dp[index-5] + dp[index-1];
				}
			}
			sb.append(dp[N-1]).append('\n');
		}
		
		System.out.print(sb);
	}
}
