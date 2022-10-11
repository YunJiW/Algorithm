import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main{

	static int N;
	static int M;

	static int[][] box;
	static boolean[][] check;
	static int max = Integer.MIN_VALUE;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		int zero = 0;

		for (int col = 0; col < N; col++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int row = 0; row < M; row++) {
				box[col][row] = Integer.parseInt(st.nextToken());
				if (box[col][row] == 0)
					zero++;
			}
		}
		if (zero == 0) {
			System.out.print(0);
			return;
		}

		//익은 토마토 넣어주기
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < M; row++) {
				if (box[col][row] == 1) {
					//
					q.offer(new int[] { col, row });
				}
			}
		}
		bfs();
		
		//0이 있는지 확인
		for (int col = 0; col < N; col++) {
			for (int row = 0; row < M; row++) {
				if (box[col][row] == 0) {
					System.out.print(-1);
					return;
				}
				if(box[col][row] > max)
					max = box[col][row];
			}
		}
		System.out.println(max - 1);
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			int[] poll = q.poll();
			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { -1, 1, 0, 0 };

			for (int index = 0; index < 4; index++) {
				int qx = poll[1] + dx[index];
				int qy = poll[0] + dy[index];

				if (qx < 0 || qx >= M || qy < 0 || qy >= N)
					continue;

				if (box[qy][qx] == 0) {
					q.offer(new int[] { qy, qx });
					box[qy][qx] = box[poll[0]][poll[1]] + 1;
				}

			}

		}

	}

}
