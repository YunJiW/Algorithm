import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

//플로이드 와샬 알고리즘으로 최단 거리 계산이 제일 중요한 조건중하나
public class Main {

	static int N;
	static int K;
	static int ans = Integer.MAX_VALUE;
	static int[][] time;
	static boolean[] planet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		time = new int[N][N];

		for (int col = 0; col < N; col++) {
			st = new StringTokenizer(br.readLine());

			for (int row = 0; row < N; row++) {
				time[col][row] = Integer.parseInt(st.nextToken());
			}
		}
		// 플로이드 워셜 알고리즘
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (time[i][k] + time[k][j] < time[i][j])
						time[i][j] = time[i][k] + time[k][j];
				}
			}
		}
		planet = new boolean[N];
		planet[K] = true;

		dfs(K, 0, 0);

		System.out.println(ans);

	}

	public static void dfs(int location, int depth, int sum) {
		if (depth == N - 1) {
			ans = Math.min(sum, ans);
			return;
		}

		for (int index = 0; index < N; index++) {
			if (!planet[index]) {
				planet[index] = true;
				dfs(index, depth + 1, sum + time[location][index]);
				planet[index] = false;
			}

		}
	}

}
