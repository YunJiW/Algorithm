import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static char Map[][];

	// 맵의 길이
	static int L;
	// 맵의 너비
	static int W;

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };

	static int Max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());

		Map = new char[L][W];

		// 맵을 생성
		for (int row = 0; row < L; row++) {
			String s = br.readLine();
			for (int col = 0; col < W; col++) {
				Map[row][col] = s.charAt(col);
			}
		}

		for (int row = 0; row < L; row++) {
			for (int col = 0; col < W; col++) {
				// 육지일경우 거기부터 마지막 지점들을 찾기
				if (Map[row][col] == 'L') {
					Starting_treasure(row, col);
				}
			}
		}
		System.out.print(Max);
	}

	private static void Starting_treasure(int row, int col) {
		Queue<int[]> que = new LinkedList<>();
		boolean visited[][] = new boolean[L][W];
		int time = 0;
		que.offer(new int[] { row, col ,time});
		visited[row][col] = true;
		while (!que.isEmpty()) {
			int cur[] = que.poll();

			boolean possible_going = false;
			for (int index = 0; index < 4; index++) {
				int nxt_row = cur[0] + dy[index];
				int nxt_col = cur[1] + dx[index];
				int times = cur[2];

				// 맵의 내부이면서 방문하지않고 물이 아닐경우에만
				if (nxt_row >= 0 && nxt_col >= 0 && nxt_row < L && nxt_col < W && !visited[nxt_row][nxt_col]
						&& Map[nxt_row][nxt_col] != 'W') {
					possible_going = true;
					que.offer(new int[] { nxt_row, nxt_col, times+1 });
					visited[nxt_row][nxt_col] = true;
				}
			}
			//갈곳이 없을 경우 => 마지막도착지
			if(!possible_going) {
				Max = Math.max(Max, cur[2]);
			}
		}

	}

}
