
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int year = 0;
	static int N;
	static int M;
	static int block = 0;

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int[][] Island;
	static int[][] Stack;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// N => Y , M => X
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Island = new int[N][M];
		Stack = new int[N][M];
		check = new boolean[N][M];

		for (int col = 0; col < N; col++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int row = 0; row < M; row++) {
				Island[col][row] = Integer.parseInt(st.nextToken());
			}
		}



		while (block < 2) {
			// 빙산 부수기
			block = 0;
			if(Empty_Island())
			{
				System.out.print(0);
				return;
				
			}
			// 빙산 근처 0인곳 찾기
			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					if (Island[col][row] != 0) {
						find_zero(col, row);
					}
				}
			}
			
			
			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					if (Island[col][row] != 0) {
						if (Stack[col][row] >= Island[col][row])
							Island[col][row] = 0;
						else
							Island[col][row] -= Stack[col][row];
					}
				}
			}
			year++;

			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					if (Island[col][row] != 0 && !check[col][row]) {
						bfs(col, row);

						block++;
					}
				}
			}
			
			
			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					check[col][row] = false;
				}
			}
		}

		System.out.print(year);

	}

	private static boolean Empty_Island() {
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < M; row++) {
				if(Island[col][row] != 0)
					return false;
			}
		}
		
		return true;
	}

	private static void find_zero(int col, int row) {

		int cnt = 0;
		for (int index = 0; index < 4; index++) {
			int x = row + dx[index];
			int y = col + dy[index];

			if (x < 0 || x >= M || y < 0 || y >= N) {
				continue;
			}
			if (Island[y][x] == 0)
				cnt++;
		}
		Stack[col][row] = cnt;
	}

	private static void bfs(int col, int row) {
		Queue<int[]> map = new LinkedList<>();
		map.offer(new int[] { col, row });
		check[col][row] = true;

		while (!map.isEmpty()) {
			int[] val = map.poll();

			for (int index = 0; index < 4; index++) {
				int y = val[0] + dy[index];
				int x = val[1] + dx[index];

				if (x < 0 || x >= M || y < 0 || y >= N) {
					continue;
				}

				if (Island[y][x] != 0 && !check[y][x]) {
					map.offer(new int[] { y, x });
					check[y][x] = true;
				}
			}
		}
	}

}
