import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

//2일뒤에 다시 해보기
public class Main {

	static int N;
	static int M;
	static Robot Adu;
	static Robot[] Crazy;
	static char[][] Map;
	static int[][] visit;

	static int cnt, comCnt, move;
	static int[] Command;

	static int dx[] = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int dy[] = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	//아두이노들 
	static class Robot {
		int x;
		int y;

		public Robot(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new char[N][M];
		visit = new int[N][M];
		Crazy = new Robot[N * M];

		cnt = 0;
		for (int col = 0; col < N; col++) {
			String S = br.readLine();
			for (int row = 0; row < M; row++) {
				Map[col][row] = S.charAt(row);
				if (S.charAt(row) == 'I') {
					Adu = new Robot(col, row);
				} else if (S.charAt(row) == 'R') {
					visit[col][row]++;
					Crazy[cnt++] = new Robot(col, row);
				}
				Map[col][row] = '.';

			}
		}

		// move 받아 두기
		String moves = br.readLine();
		comCnt = moves.length();
		Command = new int[comCnt];
		for (int index = 0; index < comCnt; index++) {
			Command[index] = moves.charAt(index) - '0' -1;
		}

		move = 0;
		if (checking()) {
			for(int i =0 ; i <cnt; i++)
				Map[Crazy[i].x][Crazy[i].y] = 'R';
			Map[Adu.x][Adu.y] = 'I';
			
			for(int col =0 ;col <N;col++)
			{
				for(int row = 0; row<M;row++)
				{
					System.out.print(Map[col][row]);
				}
				System.out.println();
			}

		} else {
			System.out.print("kraj " + move);
		}

	}

	private static boolean checking() {

		while (move++ < comCnt) {

			Adu.x += dx[Command[move - 1]];
			Adu.y += dy[Command[move - 1]];

			if (visit[Adu.x][Adu.y] != 0)
				return false;

			for (int index = 0; index < cnt; index++) {
				int min = Integer.MAX_VALUE;
				int a_x = -1, a_y = -1;

				for (int dis = 0; dis < 9; dis++) {
					int nx = Crazy[index].x + dx[dis];
					int ny = Crazy[index].y + dy[dis];

					if (nx < 0 || nx >= N || ny < 0 || ny >= M)
						continue;
					int calc = Math.abs(Adu.x - nx) + Math.abs(Adu.y - ny);

					if (min > calc) {
						min = calc;
						a_x = nx;
						a_y = ny;
					}

				}
				// 미친 아두가 종수 아두와 같이 있는경우로 끝남.
				if (min == 0)
					return false;

				visit[Crazy[index].x][Crazy[index].y]--;
				Crazy[index].x = a_x;
				Crazy[index].y = a_y;
				visit[Crazy[index].x][Crazy[index].y]++;
			}

			for (int col = 0; col < N; col++) {
				for (int row = 0; row < M; row++) {
					if (visit[col][row] >= 2) {
						boom(col, row);
						visit[col][row] = 0;
					}
				}
			}
		}
		return true;
	}

	private static void boom(int col, int row) {
		for (int i = 0; i < cnt; i++) {
			if (Crazy[i].x == col && Crazy[i].y == row) {
				Crazy[i] = Crazy[--cnt];
				i--;
			}
		}
	}

}
