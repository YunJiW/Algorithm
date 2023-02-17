import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	// 위치 체크용
	static class point {
		int row;
		int col;

		point(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

	static int R;
	static int C;
	static int T;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	// 맵
	static int Map[][];
	static int copyMap[][];

	// 미세먼지 위치
	static Queue<point> dusts;

	// 공기 청정기 위치
	static ArrayList<point> air_controller;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		dusts = new LinkedList<>();
		air_controller = new ArrayList<>();
		Map = new int[R][C];
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				int num = Integer.parseInt(st.nextToken());
				if (num != 0 && num != -1) {
					dusts.offer(new point(row, col));
				}
				// 처음에 찾아서 계속 사용예정
				else if (num == -1) {
					air_controller.add(new point(row, col));
				}
				Map[row][col] = num;
			}
		}

		for (int Time = 0; Time < T; Time++) {
			// 미세먼지 퍼뜨리기
			Run();
			// 공기청정기 실행
			Run_air_control();
			// 미세먼지 체크
			Checking_find_dust();
		}

		System.out.println(check_dust());
	}


	// 공기청정기 실행
	private static void Run_air_control() {
		// 위쪽 반시계
		point top = air_controller.get(0);

		for (int x = top.row - 1; x > 0; x--) {
			Map[x][0] = Map[x - 1][0];
		}

		for (int y = 0; y < C - 1; y++) {
			Map[0][y] = Map[0][y + 1];
		}
		
		for(int row =0; row < top.row;row++) {
			Map[row][C-1] = Map[row+1][C-1];
		}

		for (int y = C - 1; y > 1; y--) {
			Map[top.row][y] = Map[top.row][y - 1];
		}

		Map[top.row][1] = 0;

		// 아래쪽 시계방향 회전
		point bottom = air_controller.get(1);

		for (int row = bottom.row + 1; row < R - 1; row++) {
			Map[row][0] = Map[row + 1][0];
		}

		for (int col = 0; col < C - 1; col++) {
			Map[R - 1][col] = Map[R - 1][col + 1];
		}

		for (int row = R - 1; row > bottom.row; row--) {
			Map[row][C - 1] = Map[row - 1][C - 1];
		}

		for (int col = C - 1; col > 0; col--) {
			Map[bottom.row][col] = Map[bottom.row][col - 1];
		}
		Map[bottom.row][1] = 0;

	}

	// 미세먼지들의 위치 찾아두기
	private static void Checking_find_dust() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (Map[row][col] > 0) {
					dusts.offer(new point(row, col));
				}
			}
		}
	}

	// 시행
	private static void Run() {
		copyMap = new int[R][C];
		// 미세먼지 변화시 사용할 copyMap
		copyMap[air_controller.get(0).row][air_controller.get(0).col] = -1;
		copyMap[air_controller.get(1).row][air_controller.get(1).col] = -1;

		// 찾아둔 미세먼지들의 위치에서 버뜨리기.
		while (!dusts.isEmpty()) {
			point cur = dusts.poll();
			Queue<point> pos = new LinkedList<>();
			copyMap[cur.row][cur.col] += Map[cur.row][cur.col];
			// 어쩌피 5로나눈 값이 0일경우 퍼뜨릴수없으니 패스
			if (Map[cur.row][cur.col] / 5 == 0) {
				continue;
			}
			// 4방향을 체크
			for (int idx = 0; idx < 4; idx++) {
				int nxt_row = cur.row + dx[idx];
				int nxt_col = cur.col + dy[idx];

				// 맵의 내부이면서 공기청정기가 아닐경우 퍼질수있음.
				if (nxt_row >= 0 && nxt_row < R && nxt_col >= 0 && nxt_col < C && Map[nxt_row][nxt_col] != -1) {
					pos.offer(new point(nxt_row, nxt_col));
				}
			}
			int dust_div = Map[cur.row][cur.col] / 5;
			copyMap[cur.row][cur.col] -= (dust_div * pos.size());
			// 퍼뜨리기
			while (!pos.isEmpty()) {
				point check = pos.poll();
				copyMap[check.row][check.col] += dust_div;
			}

		}
		Map = copyMap;
	}

	// 남아있는 미세먼지 출력용
	private static int check_dust() {
		int dust_amount = 0;
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if (Map[row][col] != -1) {
					dust_amount += Map[row][col];
				}
			}
		}
		return dust_amount;
	}

}
