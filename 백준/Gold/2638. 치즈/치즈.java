import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	static int[][] map;
	static boolean[][] check;
	static int N;
	static int M;

	static int year = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int col = 0; col < N; col++) {

			st = new StringTokenizer(br.readLine());
			for (int row = 0; row < M; row++) {
				map[col][row] = Integer.parseInt(st.nextToken());
			}
		}


		while (true) {
			if (Cheese_Empty()) {
				System.out.print(year);
				return;
			}

			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					// 공기 체크
					if (map[col][row] == 0)
						bfs(col, row);
				}
			}

			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					if (map[col][row] == 1)
						around(col, row);
				}
			}
			
			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					if (map[col][row] == 2 || map[col][row] == 3 || map[col][row] == 4)
						map[col][row] =0;
				}
			}
			year++;
		}
	}

	private static boolean Cheese_Empty() {
		for (int cols = 0; cols < N; cols++) {
			for (int rows = 0; rows < M; rows++) {
				// 치즈일경우 주변 체크
				if (map[cols][rows] != 0) {
					return false;
				}
			}

		}
		return true;
	}

	// 치즈의 주변 체크
	private static void around(int col, int row) {
		int x = col;
		int y = row;

		int cnt = 0;

		for (int index = 0; index < 4; index++) {
			int r_x = x + dx[index];
			int r_y = y + dy[index];

			if (r_x < 0 || r_x >= N || r_y < 0 || r_y >= M)
				continue;
			if (map[r_x][r_y] == 4) {
				cnt++;
			}
		}
		// 2이상일경우 C로 체크
		if (cnt >= 2)
			map[x][y] = 2;

	}

	private static void bfs(int r_x, int r_y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r_x, r_y });
		check = new boolean[N][M];

		map[r_x][r_y] = 3;
		check[r_x][r_y] = true;
		while (!queue.isEmpty()) {
			int[] val = queue.poll();
			int x = val[0];
			int y = val[1];

			for (int index = 0; index < 4; index++) {
				int qx = x + dx[index];
				int qy = y + dy[index];

				if (qx < 0 || qx >= N || qy < 0 || qy >= M || map[qx][qy] == 4) {
					map[x][y] = 4;
					continue;
				}
				if (map[qx][qy] == 0 && !check[qx][qy]) {
					check[qx][qy] = true;
					queue.offer(new int[] { qx, qy });
				}

			}
		}
	}
}
