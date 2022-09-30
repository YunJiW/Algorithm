
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] box = new int[N + 1][N + 1];
		long[][] dp = new long[N + 1][N + 1];

		dp[1][1] = 1;

		for (int col = 1; col <= N; col++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int row = 1; row <= N; row++) {
				box[col][row] = Integer.parseInt(st.nextToken());
			}
		}

		for (int col = 1; col <= N; col++) {
			for (int row = 1; row <= N; row++) {
				int next = box[col][row];

				if (next == 0)
					break;

				if (row + next <= N)
					dp[col][row + next] += dp[col][row];
				if (col + next <= N)
					dp[col + next][row] += dp[col][row];
			}
		}

		System.out.println(dp[N][N]);

	}

}
