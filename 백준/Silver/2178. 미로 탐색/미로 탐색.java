import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static boolean[][] check;
	static int[][] Maze;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Maze = new int[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];

		for (int col = 1; col <= N; col++) {
			String s = br.readLine();
			for (int row = 0; row < M; row++) {
				Maze[col][row + 1] = s.charAt(row) - '0';
			}
		}

		bfs(1, 1);
		System.out.print(Maze[N][M]);
	}

	private static void bfs(int col, int row) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { col, row });
		check[col][row] = true;
		while (!q.isEmpty()) {
			int[] val = q.poll();
			int x = val[0];
			int y = val[1];

			for (int index = 0; index < 4; index++) {
				int xx = x + dx[index];
				int yy = y + dy[index];

				if (xx <= 0 || xx > N || yy <= 0 || yy > M)
					continue;

				if (check[xx][yy] || Maze[xx][yy] == 0) {
					continue;
				}

				q.offer(new int[] { xx, yy });
				check[xx][yy] = true;
				Maze[xx][yy] = Maze[x][y] + 1;
			}
		}

	}

}
