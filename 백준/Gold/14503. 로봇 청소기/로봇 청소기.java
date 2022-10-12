import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
	static int North = 0;
	static int East = 1;
	static int South = 2;
	static int West = 3;

	static int N;
	static int M;

	// 북 동 남 서
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };


	static int[][] Map;
	static boolean[][] check;
	static int Room = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// N -> Y , M -> X
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N][M];
		check = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		int Y = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int direc = Integer.parseInt(st.nextToken());

		for (int col = 0; col < N; col++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int row = 0; row < M; row++) {
				Map[col][row] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(Y, X, direc);

		System.out.println(Room);
	}

	private static void dfs(int y, int x, int direc) {
		Map[y][x] = 2;

		int round = 0;
		for (int index = 0; index < 4; index++) {
			direc = (direc + 3) % 4;
			int Fx = x + dx[direc];
			int Fy = y + dy[direc];

			if (Fx < 0 || Fx >= M || Fy < 0 || Fy >= N)
				continue;

			if (Map[Fy][Fx] == 0) {
				Room++;
				dfs(Fy, Fx, direc);
				return;
			}
			round++;

		}

		if (round == 4) {
			if (Map[y - dy[direc]][x - dx[direc]] == 1) {
				return;
			} else {
					dfs(y - dy[direc], x - dx[direc], direc);
			}
		}

	}

}
