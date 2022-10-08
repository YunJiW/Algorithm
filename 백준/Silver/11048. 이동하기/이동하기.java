import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

	static int[][] maze;
	static int[][] dp;
	
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N + 1][M + 1];

		dp = new int[N + 1][M + 1];

		for (int y = 1; y <= N; y++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int x = 1; x <= M; x++) {
				maze[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int col = 1 ; col<=N;col++)
		{
			for(int row = 1; row<=M;row++)
			{
				dp[col][row] = Math.max(dp[col-1][row], dp[col][row-1] ) + maze[col][row];
			}
		}
		
		System.out.print(dp[N][M]);

	}


}
