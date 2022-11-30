import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static boolean check[][];
	private static char Map[][];

	private static int N;

	private static int col_weak = 0;
	private static int cnt = 0;

	private static int dx[] = { 0, 0, -1, 1 };
	private static int dy[] = { -1, 1, 0, 0, };

	static class block {
		int row;
		int col;
		char color;

		block(int row, int col, char color) {
			this.row = row;
			this.col = col;
			this.color = color;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		Map = new char[N][N];
		check = new boolean[N][N];

		for (int row = 0; row < N; row++) {
			String line = br.readLine();
			for (int col = 0; col < N; col++) {
				Map[row][col] = line.charAt(col);
			}
		}
		// 색약이 아닌사람
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!check[row][col]) {
					checking(row, col, Map[row][col]);

					cnt++;
				}
			}
		}
		// reset
		check = new boolean[N][N];

		// 적록색약인사람
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (!check[row][col]) {
					checking_weak(row, col, Map[row][col]);

					col_weak++;
				}
			}
		}
		
		System.out.println(cnt + " " + col_weak);
	}

	//적록색약
	private static void checking_weak(int row, int col, char color) {
		Queue<block> q = new LinkedList<>();
		q.offer(new block(row, col, color));
		
		check[row][col] = true;
		
		
		while(!q.isEmpty())
		{
			block value = q.poll();
			//R또는 G일경우
			if(value.color == 'R' || value.color =='G')
			{
				for (int index = 0; index < 4; index++) {
					int nxt_x = value.row + dx[index];
					int nxt_y = value.col + dy[index];


					// 범위를 벗어나거나 같은 색이 아닐경우
					if (nxt_x < 0 || nxt_x >= N || nxt_y < 0 || nxt_y >= N  || check[nxt_x][nxt_y])
						continue;

					char nxt_c = Map[nxt_x][nxt_y];
					
					if(nxt_c == 'B')
						continue;
					check[nxt_x][nxt_y] = true;
					q.offer(new block(nxt_x, nxt_y, nxt_c));

				}
			}else
			{
				for (int index = 0; index < 4; index++) {
					int nxt_x = value.row + dx[index];
					int nxt_y = value.col + dy[index];


					// 범위를 벗어나거나 같은 색이 아닐경우
					if (nxt_x < 0 || nxt_x >= N || nxt_y < 0 || nxt_y >= N || check[nxt_x][nxt_y])
						continue;
					
					char nxt_c = Map[nxt_x][nxt_y];
					
					if(nxt_c != 'B')
						continue;

					check[nxt_x][nxt_y] = true;
					q.offer(new block(nxt_x, nxt_y, nxt_c));

				}
			}
		}
	}

	//색약아닌사람
	private static void checking(int row, int col, char color) {
		Queue<block> q = new LinkedList<>();
		q.offer(new block(row, col, color));

		check[row][col] = true;
			while (!q.isEmpty()) {
				block value = q.poll();
				for (int index = 0; index < 4; index++) {
					int nxt_x = value.row + dx[index];
					int nxt_y = value.col + dy[index];
					
					// 범위를 벗어나거나 같은 색이 아닐경우
					if (nxt_x < 0 || nxt_x >= N || nxt_y < 0 || nxt_y >= N || check[nxt_x][nxt_y])
						continue;
					
					char nxt_c = Map[nxt_x][nxt_y];
					
					if(nxt_c != value.color)
						continue;



					check[nxt_x][nxt_y] = true;
					q.offer(new block(nxt_x, nxt_y, nxt_c));

				}

			}
	}

}
