import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] dp = new int[N][N];

		for (int index = 0; index < N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int i = 0;
			while (st.hasMoreTokens()) {
				dp[index][i] = Integer.parseInt(st.nextToken());
				i++;
			}
		}
		for (int index = 1; index < N; index++) {
			for (int j = 0; j <= index; j++) {
				if (j == 0) {
					dp[index][j] = dp[index][j] + dp[index -1][j];
				} else{
					dp[index][j] = dp[index][j] + Math.max(dp[index-1][j-1],dp[index-1][j]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int index = 0; index <N;index++)
		{
			max =Math.max(max, dp[N-1][index]);
		}
		
		System.out.println(max);
	}
}
