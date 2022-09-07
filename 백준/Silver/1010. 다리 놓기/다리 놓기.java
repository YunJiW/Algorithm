import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[][] dp = new int[30][30];

		StringBuilder sb = new StringBuilder();

		// 조합 성질
		for (int index = 0; index < 30; index++) {

			dp[index][index] = 1;
			dp[index][0] = 1;
		}

		// 조합의 성질 nCr = n-1Cr-1 + n-1Cr
		for (int index = 2; index < 30; index++) {
			for (int i = 1; i < 30; i++) {
				dp[index][i] = dp[index - 1][i - 1] + dp[index - 1][i];
			}
		}

		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(dp[M][N]).append('\n');

		}
		System.out.print(sb);
	}
}
