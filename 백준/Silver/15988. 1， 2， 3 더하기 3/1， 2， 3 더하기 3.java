import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int index =4; index<=1000000;index++)
		{
			dp[index] = (dp[index-1]+dp[index-2]+dp[index-3]) % 1000000009;
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append('\n');
		}
		
		System.out.print(sb);
	}
}
