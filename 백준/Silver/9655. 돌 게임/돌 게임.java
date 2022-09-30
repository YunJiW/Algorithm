
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] dp = new String[N + 1];

		dp[1] = "SK";
		if (N >= 2) {
			dp[2] = "CY";
		}
		
		for(int index = 3; index <=N;index++)
		{
			dp[index] = dp[index-2];
		}
		System.out.println(dp[N]);

	}

}
