import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static int N;

	static int Map[][];
	// 방문 여부
	static boolean Checking[][];

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	// 땅의 높이의 최소와 최대를 체크
	static int Max_ground = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Map = new int[N][N];
		Checking = new boolean[N][N];

		StringTokenizer st;
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				Map[row][col] = Integer.parseInt(st.nextToken());
				Max_ground = Math.max(Max_ground, Map[row][col]);
			}
		}

		int cnt = Checking(0);

		System.out.println(cnt);

	}

	private static int Checking(int min_ground2) {
		int water = min_ground2;
		int Max_cnt = Integer.MIN_VALUE;
		while (water < Max_ground) {
			// 가라앉은 지역을 true로 잠긴 곳 체크
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (Map[row][col] <= water && !Checking[row][col]) {
						Checking[row][col] = true;
					}
				}
			}
			int cnt = 0;
			// 안전지역 개수 체크
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (!Checking[row][col]) {
						BFS(row, col);

						cnt++;
					}
				}
			}

			Max_cnt = Math.max(Max_cnt, cnt);
			reset(water);
			water++;

		}
		return Max_cnt;
	}

	private static void reset(int water) {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (Map[row][col] > water) {
					Checking[row][col] = false;
				}
			}
		}

	}

	private static void BFS(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { row, col });
		Checking[row][col] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int rows = cur[0];
			int cols = cur[1];

			for (int index = 0; index < 4; index++) {
				int nxt_row = rows + dx[index];
				int nxt_col = cols + dy[index];

				if (nxt_row < 0 || nxt_row >= N || nxt_col < 0 || nxt_col >= N)
					continue;

				if (!Checking[nxt_row][nxt_col]) {
					Checking[nxt_row][nxt_col] = true;
					q.offer(new int[] { nxt_row, nxt_col });
				}
			}
		}

	}

}
