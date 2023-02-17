import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int Map[][];
	static boolean visited[][];
	static int N;
	static int L;
	static int R;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int days = 0;
	static ArrayList<int[]> list;
	static int P_sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		Map = new int[N][N];

		// 각 구역의 인구수 먼저 적어두기
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				Map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		Run();
		System.out.println(days);
	}

	private static void Run() {

		while (true) {
			boolean is_check = false;
			visited = new boolean[N][N];
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					// 아직 확인이 안된곳이면 체크
					if (!visited[row][col]) {
						check_border(row, col);
					}
					
					//list 크기가 1보다 클경우 -> 인구이동이 발생한다는 것이기 때문에 true를 주고 인구이동을 시켜준다.
					if(list.size()> 1) {
						is_check = true;
						change();
						
					}
				}
			}
			// 인구이동이 발생한경우
			if (is_check)
				days++;
			// 인구이동이 발생하지 않을경우 끝
			else
				return;
		}

	}

	private static void change() {
		int avg = P_sum / list.size();
		
		for(int idx = 0; idx<list.size();idx++) {
			int[] point = list.get(idx);
			Map[point[0]][point[1]] = avg;
		}
		
	}

	private static void check_border(int row, int col) {
		Queue<int[]> que = new LinkedList<>();
		//인구이동 탐색용
		que.offer(new int[] { row, col });
		//인구이동이 필요한 구역들 저장용
		list = new ArrayList<>();
		list.add(new int[] {row,col});
		//방문 체크용
		visited[row][col] = true;
		P_sum = Map[row][col];

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			for (int idx = 0; idx < 4; idx++) {
				int nxt_row = cur[0] + dx[idx];
				int nxt_col = cur[1] + dy[idx];

				//맵의 내부이면서 아직 방문하지 않았을 경우
				if (nxt_row >= 0 && nxt_row < N && nxt_col >= 0 && nxt_col < N && !visited[nxt_row][nxt_col]) {
					//L 과 R사이의 차이의 값을 가질때
					if (check_diff(Map[cur[0]][cur[1]], Map[nxt_row][nxt_col])) {
						que.offer(new int[] {nxt_row,nxt_col});
						list.add(new int[] {nxt_row,nxt_col});
						P_sum += Map[nxt_row][nxt_col];
						visited[nxt_row][nxt_col] = true;
					}
				}

			}

		}
	}

	private static boolean check_diff(int cur, int nxt) {
		int diff = Math.abs(cur - nxt);
		if (diff >= L && diff <= R)
			return true;

		return false;

	}

}
