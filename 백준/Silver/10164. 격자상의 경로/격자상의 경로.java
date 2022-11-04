import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
	static class Point {
		int row;
		int col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int dx[] = { 0, 1 };
	static int dy[] = { 1, 0 };
	static int Map[][];

	static int N;
	static int M;
	static int K;

	static int dp[][];
	static Point Check_point;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Map = new int[N + 1][M + 1];
		dp = new int[N + 1][M + 1];

		dp[1][1] = 0;
		for (int row = 1; row <= N; row++) {
			for (int col = 1; col <= M; col++) {
				Map[row][col] = (row - 1) * M + col;
				if (Map[row][col] == K)
					Check_point = new Point(row, col);
			}
		}

		int result;

		if (K == 0) {
			result = dfs(new Point(1, 1), new Point(N, M));
		} else {
			result = dfs(new Point(1, 1), Check_point) * dfs(Check_point, new Point(N, M));
		}
		
		System.out.print(result);
	}

	private static int dfs(Point cur, Point dst) {
		if (cur.row == dst.row && cur.col == dst.col) {
			return 1;
		}

		for (int index = 0; index < 2; index++) {
			Point next = new Point(cur.row + dx[index], cur.col + dy[index]);
			
			if(isValidRange(next,dst)) continue;
			if(dp[next.row][next.col]!= 0 )
			{
				dp[cur.row][cur.col] += dp[next.row][next.col]; 
			}else {
				dp[cur.row][cur.col] += dfs(next,dst);
			}
		}

		return dp[cur.row][cur.col];
	}

	private static boolean isValidRange(Point pos, Point dst) {
		return !(1 <= pos.row && pos.row <= dst.row && 1 <= pos.col && pos.col <= dst.col);
	}

}
