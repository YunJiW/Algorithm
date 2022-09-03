import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 테스트 케이스
		int T = Integer.parseInt(br.readLine());
		int[] dp;
		
		StringBuilder sb = new StringBuilder();
		for (int test = 0; test < T; test++) {
			int N = Integer.parseInt(br.readLine());
			dp = new int[N+1];
			dp[1] = 1;
			if(N >= 2)
				dp[2] = 2;
			if(N >= 3)
				dp[3] = 4;
			
			for(int index = 4; index <= N;index++)
			{
				dp[index] = dp[index-3] + dp[index-2] + dp[index-1];
			}
			
			sb.append(dp[N]).append("\n");
		}
		
		System.out.print(sb);
	}
}
